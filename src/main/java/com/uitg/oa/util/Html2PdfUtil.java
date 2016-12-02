package com.uitg.oa.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.tidy.Tidy;
import org.w3c.tidy.TidyMessage;
import org.w3c.tidy.TidyMessageListener;
import org.xhtmlrenderer.layout.SharedContext;
import org.xhtmlrenderer.pdf.ITextFontResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
//import com.sungard.agr.getpaid.foundation.blbean.CompanyValue;
//import com.sungard.agr.getpaid.foundation.ejb_config.AppServerContext;
//import com.sungard.agr.getpaid.foundation.util.CommonUtil;
//import com.sungard.agr.getpaid.foundation.util.FontUtil;
//import com.sungard.agr.getpaid.foundation.util.GenericConstants;
//import com.xpjsky.oa.controller.admin.SettingController;


public class Html2PdfUtil{
	//private static final Logger log = ESAPI.getLogger(Html2PdfUtil.class);
	private final static Logger log = LoggerFactory.getLogger(Html2PdfUtil.class);

	private static final int LEFT_JUSTIFY   = 0;
	private static final int RIGHT_JUSTIFY  = 1;
	private static final int CENTER_JUSTIFY = 2;
	
	private static final String SPACES = "    ";
	private static final String ENCODING="UTF-8";

	/**
	 * Convert html to pdf
	 * @return ByteArrayOutputStream of PDF
	 */
	public static ByteArrayOutputStream convertHtml2Pdf(String htmlContent, boolean isLandscape) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();	
		ByteArrayOutputStream tidyOut = null;
		InputStream tidyIn = null;
		String generateStyle = "";
		try {
			if(htmlContent == null){
				htmlContent="";	
			}
			

//			htmlContent = StringUtils.replace(htmlContent, "\r", "");			
//			htmlContent = StringUtils.replace(htmlContent, "<body>", "");
//			htmlContent = StringUtils.replace(htmlContent, "</body>", "");
//			
//			int startStyle = htmlContent.indexOf("<style type=\"text/css\">\n");
//			int endStyle = htmlContent.indexOf("</style>\n");
//			
//			if(endStyle == -1){
//				endStyle = htmlContent.indexOf("</style>");
//			}
//			
//			
//
//			if (startStyle != -1 && endStyle != -1) {
//				generateStyle = htmlContent.substring(startStyle + "<style type=\"text/css\">\n".length(), endStyle);
//				htmlContent = htmlContent.substring(0, startStyle) + htmlContent.substring(endStyle + "</style>\n".length());
//			}
//
//			if (htmlContent.indexOf("/P/") != -1) {
//				htmlContent = htmlContent.replaceAll("/P/","<div style=\"page-break-after: always\"><span style=\"display: none\">&nbsp;</span></div>");
//			}
	
			tidyOut = new ByteArrayOutputStream(); 
			ITextRenderer renderer = new ITextRenderer();
			renderer.setPDFVersion(PdfWriter.VERSION_1_7);
			
			
			ITextFontResolver fr = renderer.getFontResolver();
			//fr.addFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			//String path = System.getProperty("user.dir");
		    String path = Html2PdfUtil.class.getResource("/").getPath();
			//fr.addFont(path+"/../fonts/ARIALUNI.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); 
			fr.addFont(path+"/../fonts/msyh.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); 
			fr.addFont(path+"/../fonts/msyhbd.ttc", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED); 
			
			//htmlContent = StringUtils.replace(htmlContent," ", "&#160;");
			htmlContent = new String(htmlContent.getBytes("UTF-8"),"UTF-8");
			validateTemplate(htmlContent,tidyOut,true);
			
			String temp = tidyOut.toString(ENCODING);

//			String matchedString = "";
//	
//			Pattern pattern = Pattern.compile("font-family(.*?):(.*?);",Pattern.DOTALL);
//			Matcher matcher = pattern.matcher(generateStyle);
//			
//			//add fonts from style section
//			while(matcher.find()){			
//				matchedString = matcher.group().toLowerCase();
//				//addFonts(matchedString,fr,fonts); 
//			}
//	
//			//add fonts from body section
//			matcher = pattern.matcher(temp);
//			while(matcher.find()){
//				matchedString = matcher.group().toLowerCase();
//			    //addFonts(matchedString,fr,fonts);
//			}
			
			// now tidied xhtml can be parsed	
			tidyIn = new ByteArrayInputStream(temp.getBytes(ENCODING));
	
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	
			// turn off external dtd loading, we don't need it
			dbf.setNamespaceAware(true);
			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",Boolean.FALSE);
			dbf.setFeature("http://xml.org/sax/features/validation", Boolean.FALSE);
			
			DocumentBuilder db = dbf.newDocumentBuilder();
			//db.setEntityResolver(new BlankingResolver());
			
			org.w3c.dom.Document document = db.parse(tidyIn);
			
			org.w3c.dom.Element style = document.createElement("style");
			
			//The style generate by ckeditor are all lowercase, in order to be consistent with ckeditor, we modified the xhtmlrender's font name to lowercase.
			//If we want to show the style correctly in pdf, we should make sure the font style to lower case.
//			if(log.isDebugEnabled()){
//				log.debug(Logger.EVENT_UNSPECIFIED, "generateStyle: "+generateStyle);
//			}
			String textContent = generateStyle + "\n";

			textContent += getPDFPageStyle(isLandscape);

			if(log.isDebugEnabled()){
				//log.debug(Logger.EVENT_UNSPECIFIED, "textContent: "+textContent);
			}
			style.setTextContent(textContent);

			// and add it to <head>
			org.w3c.dom.Element root = document.getDocumentElement();
			root.getElementsByTagName("head").item(0).appendChild(style);
	
			// we've got document, now let's render it
			renderer.setDocument(document, null);
	
			// do the layout
			renderer.layout();
	
			// and finally pdf creation
			renderer.createPDF(baos);
		} catch (DocumentException e) {
			//log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
			throw e;
		} catch (IOException e) {
			//log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
			throw e;
		} catch (ParserConfigurationException e) {
			//log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
			throw e;
		} catch (SAXException e) {
			//log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
			throw e;
		} catch (Exception e) {
			//log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
			throw e;
		}finally{
			if(tidyOut != null){
			    tidyOut.close();
			}
			if(tidyIn != null){
			    tidyIn.close();
			}
		}		
		return baos;
	}
	

	
//	private static void addFonts(String styleString, ITextFontResolver fr, Map<String, List<String>> fonts) throws DocumentException, IOException {
//		if(styleString.contains("font-family")){
//			/*avoid some comma(;) appeared before the font-family to cause StringIndexOutOfBoundsException*/
//			styleString = styleString.substring(styleString.indexOf("font-family"));
//			String fontFamily;
//			if(styleString.indexOf(GenericConstants.SEMICOLON)>-1){
//				fontFamily = styleString.substring(styleString.indexOf(GenericConstants.COLON)+1,styleString.indexOf(GenericConstants.SEMICOLON)).trim();
//			}else{
//				fontFamily = styleString.substring(styleString.indexOf(GenericConstants.COLON)+1).trim();
//			}
//
//			if(fonts != null) {
//				ArrayList fontGroup = (ArrayList)fonts.get(fontFamily);
//				if(fontGroup != null){
//					for(Iterator it = fontGroup.iterator();it.hasNext();){
//						String path = (String)it.next();
//						if(path.endsWith(".ttc")){							
//							fr.addFont(path,BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);							
//						}else{
//							fr.addFont(path,BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
//						}
//					}
//				}
//			}
//		}
//	}
//

	public static String getPDFPageStyle(boolean isLandscape) {
		if(log.isDebugEnabled()){
			//log.debug(Logger.EVENT_UNSPECIFIED, cssStyle.toString());
		}
//		String pageheaderalign = (String)cssStyle.getProperty(StyleSheetConstants.PAGE_HEADER_ALIGN);
//		if(pageheaderalign ==null){
//			pageheaderalign = "@top-left";
//		}	
//		String pageheadertextalign = pageheaderalign.split("-")[1]+";";
//		String header = pageheaderalign.trim() +"{content: element(pageHeader);}" ;
		String pageHeader = "#page-number:before {content: \"Page \" counter(page);} \r\n}";

		String topMargin = "";
		String bottomMargin = "";
		String leftMargin = "";
		String rightMargin = "";
		String pageLayout = "";//LANDSCAPE PORTRAIT;
		String landscape= isLandscape ? "landscape":"portrait";
		String pdfPageStyle = 
				"body {font-family:Microsoft YaHei UI,Arial Unicode MS ;} \r\n " +
		        ".colright {text-align:right;} .colcenter {text-align:center;} .bold {font-weight:bold;} \r\n "+
				" .bblue {background-color:#AED2F7;} .bblue2 {background-color:#7664F7;} .bred {background-color:#F4228B;} .red {color:#F4228B;}\r\n"+
				".table {border: 1px solid;border-collapse: collapse;width:100%;} \r\n .table td {border: 1px solid;} \r\n " +
				" @page {size:"+landscape +"; "+
				" margin-top: "+ topMargin+"in;" +
				" margin-right: "+rightMargin+"in;" +
				" margin-bottom: "+bottomMargin +"in;" +
				" margin-left: "+ leftMargin+"in;"
				+ " }\r\n" + pageHeader;
//		if(log.isDebugEnabled()){
//			log.debug(Logger.EVENT_UNSPECIFIED, "pdfPageStyle: "+pdfPageStyle);
//			log.debug(Logger.EVENT_UNSPECIFIED, "end");
//		}
		return pdfPageStyle;
	}
	
	private static String getValue(String value, String defaultValue) {
		return (StringUtils.isBlank(value)) ? defaultValue : value;
	}
	
	/**
	 * Validate the html template
	 * 
	 * @param htmlContent String
	 * @param tidyOut ByteArrayOutputStream
	 * @param forceOutput boolean - if true, tidy will output document even if errors were found, will discarding unexpected tag 
	 * @return error message after tidy the html template
	 */
	public static String validateTemplate(String htmlContent,ByteArrayOutputStream tidyOut, boolean forceOutput) throws Exception{
		StringBuffer message = new StringBuffer();
		
		if(htmlContent == null){
			htmlContent = "";
		}
		
		if(tidyOut == null){
			tidyOut = new ByteArrayOutputStream(); 
		}
		
		// html->xhtml conversion		
		Tidy tidy = new Tidy();
		tidy.setXHTML(true);
		tidy.setInputEncoding(ENCODING);
		tidy.setOutputEncoding(ENCODING);
		//start to discard the unrecognized or unexpected tag
		
		GPTidyMessageListener gplistener = new GPTidyMessageListener();
		tidy.setMessageListener(gplistener);		
		
		if(forceOutput){	
			//tidy.setMakeBare(true);//remove Microsoft cruft. Comment this for this would discard or replace html space '&nbsp;' to ''
			//tidy.setWord2000(true);//draconian cleaning for Word2000.
			//'set make clean' will replace style="" with style class
			tidy.setMakeClean(true);//remove presentational clutter.
		    tidy.setForceOutput(true);//tidy will output document even if errors were found, will discarding unexpected tag		
		}
		//end
		
		tidy.parse(new ByteArrayInputStream(htmlContent.getBytes(ENCODING)), tidyOut);
		
		int errorCount = 0;
		for(TidyMessage msg: gplistener.getMessages() ){
			if (msg.getLevel().equals(TidyMessage.Level.ERROR)){
				errorCount++;
				
				if(errorCount==1){
					//log.warning(Logger.EVENT_FAILURE, "============================Starting Invalidte template:========================");
				}
				
				///log.warning(Logger.EVENT_FAILURE, "============================"+"line "+ msg.getLine()+" column "+ msg.getColumn()+" - Error: " +msg.getMessage()+"============================");
			    			    
				message.append("jtidy:");
				message.append("line "+ msg.getLine()+" column "+ msg.getColumn()+" - Error: " +msg.getMessage());
				message.append("<br/>");
		    }
		}
		
		if(errorCount>0){
			//log.info(Logger.EVENT_UNSPECIFIED, "============================End Invalidate template:========================");
		}
		
		return StringEscapeUtils.escapeHtml(message.toString());
	}
	
}
	
	class GPTidyMessageListener implements TidyMessageListener{
		
		private List<TidyMessage> messages;
		
	    public GPTidyMessageListener(){
	    	this.messages = new Vector<TidyMessage>();
	    }
	    
		public void messageReceived(TidyMessage message) {
			if (message.getLevel().equals(TidyMessage.Level.ERROR)|| message.getLevel().equals(TidyMessage.Level.WARNING)){
				messages.add(message);
		    }
		}
	
		public List<TidyMessage> getMessages() {
			return messages;
		}
	
		public void setMessages(List<TidyMessage> messages) {
			this.messages = messages;
		}
	
}

