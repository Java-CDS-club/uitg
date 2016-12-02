//package com.uitg.oa.util;
//
//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.StringWriter;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//import java.util.StringTokenizer;
//import java.util.Vector;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.stream.StreamResult;
//import javax.xml.transform.stream.StreamSource;
//
//import org.apache.commons.lang.StringEscapeUtils;
//import org.apache.commons.lang.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.w3c.tidy.Tidy;
//import org.w3c.tidy.TidyMessage;
//import org.w3c.tidy.TidyMessageListener;
//import org.xhtmlrenderer.layout.SharedContext;
//import org.xhtmlrenderer.pdf.ITextFontResolver;
//import org.xhtmlrenderer.pdf.ITextRenderer;
//import org.xml.sax.SAXException;
//
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.pdf.BaseFont;
//import com.lowagie.text.pdf.PdfWriter;
////import com.sungard.agr.getpaid.foundation.blbean.CompanyValue;
////import com.sungard.agr.getpaid.foundation.ejb_config.AppServerContext;
////import com.sungard.agr.getpaid.foundation.util.CommonUtil;
////import com.sungard.agr.getpaid.foundation.util.FontUtil;
////import com.sungard.agr.getpaid.foundation.util.GenericConstants;
////import com.xpjsky.oa.controller.admin.SettingController;
//
//public class PdfUtil {
//	
//	//private static final Logger log = ESAPI.getLogger(Html2PdfUtil.class);
//	private final static Logger log = LoggerFactory.getLogger(Html2PdfUtil.class);
//
//	private static final int LEFT_JUSTIFY   = 0;
//	private static final int RIGHT_JUSTIFY  = 1;
//	private static final int CENTER_JUSTIFY = 2;
//	
//	private static final String SPACES = "    ";
//
//	/**
//	 * Convert html to pdf
//	 * 
//	 * @param htmlContent String
//	 * @param fonts HashMap - key is String (fontFamily) value is ArrayList of Strings (path to font files)
//	 * @return ByteArrayOutputStream of PDF
//	 */
//	public static ByteArrayOutputStream convertHtml2Pdf(String htmlContent, Map<String, List<String>> fonts)throws Exception {
//
// 		ByteArrayOutputStream baos = convertHtml2Pdf(htmlContent, fonts, null); 
// 		return baos;
//	}
//
//	/**
//	 * Convert html to pdf
//	 * <br/> if companyValue is not null uses companyValue to get margins
//	 * <br/> Returns empty String when htmlContent is null
//	 * 
//	 * @param htmlContent String
//	 * @param fonts HashMap - can be null - key is String (fontFamily) value is ArrayList of Strings (path to font files)
//	 * @param companyValue CompanyValue
//	 * @return ByteArrayOutputStream of PDF
//	 */
//	public static ByteArrayOutputStream convertHtml2Pdf(String htmlContent,  Map<String, List<String>> fonts, CompanyValue companyValue) throws Exception {
////		if(log.isDebugEnabled()){
//// 			log.debug(Logger.EVENT_UNSPECIFIED, "htmlContent: "+htmlContent);
////			log.debug(Logger.EVENT_UNSPECIFIED, "fonts: "+fonts);
////		}
////		log.info(Logger.EVENT_UNSPECIFIED, "companyValue: "+companyValue);
//		ByteArrayOutputStream baos = new ByteArrayOutputStream();	
//		ByteArrayOutputStream tidyOut = null;
//		InputStream tidyIn = null;
//		String generateStyle = "";
//		try {
//			if(htmlContent == null){
//				htmlContent="";	
//			}
//			
//
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
//	
//			tidyOut = new ByteArrayOutputStream(); 
//			ITextRenderer renderer = new ITextRenderer();
//			renderer.setPDFVersion(PdfWriter.VERSION_1_7);
//			
//			
//			ITextFontResolver fr = renderer.getFontResolver();
//			
//			validateTemplate(htmlContent,tidyOut,true);
//			
//			String temp = tidyOut.toString(GenericConstants.ENCODING);
//
//			String matchedString = "";
//	
//			Pattern pattern = Pattern.compile("font-family(.*?):(.*?);",Pattern.DOTALL);
//			Matcher matcher = pattern.matcher(generateStyle);
//			
//			//add fonts from style section
//			while(matcher.find()){			
//				matchedString = matcher.group().toLowerCase();
//				addFonts(matchedString,fr,fonts); 
//			}
//	
//			//add fonts from body section
//			matcher = pattern.matcher(temp);
//			while(matcher.find()){
//				matchedString = matcher.group().toLowerCase();
//			    addFonts(matchedString,fr,fonts);
//			}
//			temp = StringUtils.replace(temp, "&nbsp;", GenericConstants.HTML_SPACE);
//			
//			// now tidied xhtml can be parsed	
//			tidyIn = new ByteArrayInputStream(CommonUtil.convertToByte(temp));
//	
//			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//	
//			// turn off external dtd loading, we don't need it
//			dbf.setNamespaceAware(true);
//			dbf.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",Boolean.FALSE);
//			dbf.setFeature("http://xml.org/sax/features/validation", Boolean.FALSE);
//			
//			DocumentBuilder db = dbf.newDocumentBuilder();
//			//db.setEntityResolver(new BlankingResolver());
//			
//			org.w3c.dom.Document document = db.parse(tidyIn);
//			
//			org.w3c.dom.Element style = document.createElement("style");
//			
//			//The style generate by ckeditor are all lowercase, in order to be consistent with ckeditor, we modified the xhtmlrender's font name to lowercase.
//			//If we want to show the style correctly in pdf, we should make sure the font style to lower case.
////			if(log.isDebugEnabled()){
////				log.debug(Logger.EVENT_UNSPECIFIED, "generateStyle: "+generateStyle);
////			}
//			String textContent = generateStyle + "\n";
//			if (!generateStyle.contains("@page")) {
//				//log.debug(Logger.EVENT_UNSPECIFIED, "@page not present in style");
//				if (companyValue != null) {
//					textContent += getPDFPageStyle(companyValue);
//				} else {
//					textContent += getPDFPageStyle(new Properties());
//				}
//			} else {
//				//log.debug(Logger.EVENT_UNSPECIFIED, "@page already present in style");
//			}
//			if(log.isDebugEnabled()){
//				//log.debug(Logger.EVENT_UNSPECIFIED, "textContent: "+textContent);
//			}
//			style.setTextContent(textContent);
//
//			// and add it to <head>
//			org.w3c.dom.Element root = document.getDocumentElement();
//			root.getElementsByTagName("head").item(0).appendChild(style);
//	
//			// we've got document, now let's render it
//			renderer.setDocument(document, null);
//	
//			// do the layout
//			renderer.layout();
//	
//			// and finally pdf creation
//			renderer.createPDF(baos);
//		} catch (DocumentException e) {
//			log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
//			throw e;
//		} catch (IOException e) {
//			log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
//			throw e;
//		} catch (ParserConfigurationException e) {
//			log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
//			throw e;
//		} catch (SAXException e) {
//			log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
//			throw e;
//		} catch (Exception e) {
//			log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
//			throw e;
//		}finally{
//			if(tidyOut != null){
//			    tidyOut.close();
//			}
//			if(tidyIn != null){
//			    tidyIn.close();
//			}
//		}		
//		return baos;
//	}
//	
//	/**
//	   Returns a byte array representing the PDF file or an empty byte array if htmlString is null.
//
//	 * @param String htmlString - text in html form. 
//	 * @param CompanyValue companyValue - used to for reading the margins for the pdf. 
//	 */	
//	public static byte[] convertHTMLToPDFBytes(String htmlString, CompanyValue companyValue) {
//		try {
//			ByteArrayOutputStream baos = convertHtml2Pdf(htmlString, FontUtil.getFonts(), companyValue);
//			return baos.toByteArray();      		        		
//		} catch (Exception e) {
//			//log.error(Logger.EVENT_FAILURE, e.getMessage(),e);
//			throw new RuntimeException(e.getMessage());
//		}
//	}
//
//	private static String replaceTables( String htmlContent ) {
//		String table = extractByTags( htmlContent,"<table","</table>",true );
//
//		while ( table != null ) {
//			ArrayList<Integer> colSize = new ArrayList<Integer>();
//			StringTokenizer st         = new StringTokenizer( table,"\n" );
//			StringBuffer sb            = new StringBuffer( "<pre>\n" );
//			boolean firstTR            = true;
//			String token;
//			String value;
//			int pos = -1;
//
//			// 1st pass is to determine the max size of all the columns.
//			while ( st.hasMoreTokens() ) {
//				token = st.nextToken();
//
//				if ( token.startsWith( "<tr>" ) || token.startsWith( "<tr " ) ) {
//					pos = 0;			// Every time with hit a <tr> this is back to the 1st column.
//				} else if ( token.startsWith( "<td" ) || token.startsWith( "<th>" ) || token.startsWith( "<th " ) ) {
//					
//					// Do the substring, since I don't want the 2nd tag to pick up the 1st tag.
//					value = extractByTags( token.substring(3),">","<",false );
//
//					if ( colSize.size() < pos+1 ) {
//						colSize.add( Integer.valueOf(value.length()));
//					} else {
//						Integer integer = colSize.get( pos );
//
//						if ( integer.intValue() < value.length() ) {
//							colSize.set( pos, Integer.valueOf(value.length()));
//						}
//					}
//
//					pos++;
//				}
//			}
//
//			// Reload for parsing.
//			st = new StringTokenizer( table,"\n" );
//
//			// 2nd pass is to pad the output and write it to a stringbuffer for output.
//			while ( st.hasMoreTokens() ) {
//				token = st.nextToken();
//
//				if ( token.startsWith( "<tr>" ) || token.startsWith( "<tr " ) ) {
//					
//                    // When we finish with the first row, we need to add line feeds between each row.
//					if ( firstTR ) {
//						firstTR = false;
//					} else {
//						sb.append( "\n" );
//					}
//
//					pos = 0;			// Every time with hit a <tr> this is back to the 1st column.
//				} else if ( token.startsWith( "<td" ) || token.startsWith( "<th>" ) || token.startsWith( "<th " ) ) {
//					
//					// Do the substring, since I don't want the 2nd tag to pick up the 1st tag.
//					value       = extractByTags( token.substring(3),">","<",false );
//					int padding = LEFT_JUSTIFY;
//					
//					if ( token.contains("text-align:right") ) {
//						padding = RIGHT_JUSTIFY;
//					} else if ( token.contains("text-align:center") ) {
//						padding = CENTER_JUSTIFY;
//					}
//					
//					sb.append( pad( value,colSize.get(pos).intValue(),padding ) + SPACES );
//					pos++;
//				}
//			}
//
//			// Closing tag.
//			sb.append( "\n</pre>\n" );
//
//			// Find the original table so we can remove it to replace it with the StringBuffer.
//			int startTag = htmlContent.indexOf( "<table" );
//			int endTag   = htmlContent.indexOf( "</table>" );
//
//			// Replace the table with my output.
//			htmlContent = htmlContent.substring( 0,startTag ) + sb.toString() + htmlContent.substring( endTag+8 );
//
//			// Look for another table.
//			table = extractByTags( htmlContent,"<table","</table>",true );
//		}
//
//		return htmlContent;
//	}
//	
//	private static String pad( String valueArg, int length, int padding ) {
//		StringBuilder value = new StringBuilder(valueArg);
//		if ( padding == RIGHT_JUSTIFY ) {
//			while ( value.length() < length ) {
//				value.append(" ").append(value);
//			}
//		} else if ( padding == LEFT_JUSTIFY ) {
//			while ( value.length() < length ) {
//				value.append(" ");
//			}
//		} else { // Center
//			while ( value.length() < length ) {
//				value = new StringBuilder(" " + value + " ");
//			}
//			
//			if (value.length() > length ) {
//				value = new StringBuilder(value.substring( 0,length ));
//			}
//		}
//		
//		return value.toString();
//	}
//	
//	private static String extractByTags( String htmlContent, String startTag, String endTag, boolean includeTags ) {
//		int beginTagPos = htmlContent.indexOf( startTag );
//
//		if ( beginTagPos == -1 ) {
//			return null;
//		} else {
//			int endTagPos = htmlContent.indexOf( endTag );
//
//			if ( endTagPos == -1 ) {
//				return null;
//			} else if (includeTags) {
//				return htmlContent.substring( beginTagPos, endTagPos+endTag.length() );
//			} else {
//				return htmlContent.substring( beginTagPos+startTag.length(), endTagPos );
//			}
//		}
//	}
//	
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
//	public static String getPDFPageStyle() {
//
// 		String pdfPageStyle = getPDFPageStyle(new Properties());
// 		return pdfPageStyle;
//	}
//	
//	public static String getPDFPageStyle(CompanyValue companyValue) {
//
// 		Properties cssStyle = new Properties();
//		cssStyle.put(StyleSheetConstants.TOP_MARGIN, companyValue.getTopMargin().toString());
//		cssStyle.put(StyleSheetConstants.BOTTOM_MARGIN, companyValue.getBottomMargin().toString());
//		cssStyle.put(StyleSheetConstants.LEFT_MARGIN, companyValue.getLeftMargin().toString());
//		cssStyle.put(StyleSheetConstants.RIGHT_MARGIN, companyValue.getRightMargin().toString());
//		String pdfPageStyle = getPDFPageStyle(cssStyle);
// 		return pdfPageStyle;
//	}
//
//	public static String getPDFPageStyle(Properties cssStyle) {
//		if(log.isDebugEnabled()){
//			log.debug(Logger.EVENT_UNSPECIFIED, cssStyle.toString());
//		}
//		String pageheaderalign = (String)cssStyle.getProperty(StyleSheetConstants.PAGE_HEADER_ALIGN);
//		if(pageheaderalign ==null){
//			pageheaderalign = "@top-left";
//		}	
//		String pageheadertextalign = pageheaderalign.split("-")[1]+";";
//		String header = pageheaderalign.trim() +"{content: element(pageHeader);}" ;
//		String pageHeader = "#page-number:before {content: \"Page \" counter(page);} \r\n" +"#pageHeader{position: running(pageHeader);text-align:"+ pageheadertextalign+"}";
//
//		String topMargin = getValue((String)cssStyle.get(StyleSheetConstants.TOP_MARGIN), StyleSheetConstants.DEFAULT_MARGIN);
//		String bottomMargin = getValue((String)cssStyle.get(StyleSheetConstants.BOTTOM_MARGIN), StyleSheetConstants.DEFAULT_MARGIN);
//		String leftMargin = getValue((String)cssStyle.get(StyleSheetConstants.LEFT_MARGIN), StyleSheetConstants.DEFAULT_MARGIN);
//		String rightMargin = getValue((String)cssStyle.get(StyleSheetConstants.RIGHT_MARGIN), StyleSheetConstants.DEFAULT_MARGIN);
//		String pageLayout = StyleSheetConstants.LANDSCAPE.equals((String)cssStyle.get(StyleSheetConstants.PAGE_LAYOUT)) ?  StyleSheetConstants.LANDSCAPE :  StyleSheetConstants.PORTRAIT;
//		Map<String, String> pageDimensions = StyleSheetConstants.LANDSCAPE.equals(pageLayout) ?  StyleSheetConstants.LANDSCAPE_DIMENSIONS :  StyleSheetConstants.PORTRAIT_DIMENSIONS;
//		String pageSize = (String)cssStyle.get(StyleSheetConstants.PAGE_SIZE);
//		if (StringUtils.isBlank(pageSize)) {
//			try {
//				pageSize = AppServerContext.getSystemProperty("PAGESIZE").toUpperCase();
//			} catch (Exception e) {
//				//log.debug(Logger.EVENT_UNSPECIFIED, e.getMessage(), e);
//				pageSize = StyleSheetConstants.LETTER;
//			}			
//		}
//		if (!pageDimensions.containsKey(pageSize)) {
//			pageSize = StyleSheetConstants.LETTER; // default is letter
//		}
//		String pageDimension = pageDimensions.get(pageSize);
//		String pdfPageStyle = 
//				"@page" +
//				" {size: "+pageDimension+ GenericConstants.SEMICOLON +
//				" margin-top: "+ topMargin+"in;" +
//				" margin-right: "+rightMargin+"in;" +
//				" margin-bottom: "+bottomMargin +"in;" +
//				" margin-left: "+ leftMargin+"in;"
//				+ header + " }\r\n" + pageHeader;
//		if(log.isDebugEnabled()){
//			log.debug(Logger.EVENT_UNSPECIFIED, "pdfPageStyle: "+pdfPageStyle);
//			log.debug(Logger.EVENT_UNSPECIFIED, "end");
//		}
//		return pdfPageStyle;
//	}
//	
//	private static String getValue(String value, String defaultValue) {
//		return (StringUtils.isBlank(value)) ? defaultValue : value;
//	}
//	
//	/**
//	 * Validate the html template
//	 * 
//	 * @param htmlContent String
//	 * @param tidyOut ByteArrayOutputStream
//	 * @param forceOutput boolean - if true, tidy will output document even if errors were found, will discarding unexpected tag 
//	 * @return error message after tidy the html template
//	 */
//	public static String validateTemplate(String htmlContent,ByteArrayOutputStream tidyOut, boolean forceOutput) throws Exception{
//		StringBuffer message = new StringBuffer();
//		
//		if(htmlContent == null){
//			htmlContent = "";
//		}
//		
//		if(tidyOut == null){
//			tidyOut = new ByteArrayOutputStream(); 
//		}
//		
//		// html->xhtml conversion		
//		Tidy tidy = new Tidy();
//		tidy.setXHTML(true);
//		tidy.setInputEncoding(GenericConstants.ENCODING);
//		tidy.setOutputEncoding(GenericConstants.ENCODING);
//		//start to discard the unrecognized or unexpected tag
//		
//		GPTidyMessageListener gplistener = new GPTidyMessageListener();
//		tidy.setMessageListener(gplistener);		
//		
//		if(forceOutput){	
//			//tidy.setMakeBare(true);//remove Microsoft cruft. Comment this for this would discard or replace html space '&nbsp;' to ''
//			//tidy.setWord2000(true);//draconian cleaning for Word2000.
//			//'set make clean' will replace style="" with style class
//			tidy.setMakeClean(true);//remove presentational clutter.
//		    tidy.setForceOutput(true);//tidy will output document even if errors were found, will discarding unexpected tag		
//		}
//		//end
//		
//		tidy.parse(new ByteArrayInputStream(CommonUtil.convertToByte(htmlContent)), tidyOut);
//		
//		int errorCount = 0;
//		for(TidyMessage msg: gplistener.getMessages() ){
//			if (msg.getLevel().equals(TidyMessage.Level.ERROR)){
//				errorCount++;
//				
//				if(errorCount==1){
//					log.warning(Logger.EVENT_FAILURE, "============================Starting Invalidte template:========================");
//				}
//				
//				log.warning(Logger.EVENT_FAILURE, "============================"+"line "+ msg.getLine()+" column "+ msg.getColumn()+" - Error: " +msg.getMessage()+"============================");
//			    			    
//				message.append("jtidy:");
//				message.append("line "+ msg.getLine()+" column "+ msg.getColumn()+" - Error: " +msg.getMessage());
//				message.append("<br/>");
//		    }
//		}
//		
//		if(errorCount>0){
//			log.info(Logger.EVENT_UNSPECIFIED, "============================End Invalidate template:========================");
//		}
//		
//		return StringEscapeUtils.escapeHtml(message.toString());
//	}
//	
//	/** uncomment for testing 
//	public  static void main(String[] args) throws Exception{
//
//		FileInputStream fio = new FileInputStream("c:/test.txt");
//		byte[] bytes = new byte[fio.available()];
//		fio.read(bytes);
//		Html2PdfUtil.convertHtml2Text(new String(bytes,"UTF-8"), null);
//	}
//	*/
//}
//
//class GPTidyMessageListener implements TidyMessageListener{
//	
//	private List<TidyMessage> messages;
//	
//    public GPTidyMessageListener(){
//    	this.messages = new Vector<TidyMessage>();
//    }
//    
//	public void messageReceived(TidyMessage message) {
//		if (message.getLevel().equals(TidyMessage.Level.ERROR)|| message.getLevel().equals(TidyMessage.Level.WARNING)){
//			messages.add(message);
//	    }
//	}
//
//	public List<TidyMessage> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(List<TidyMessage> messages) {
//		this.messages = messages;
//	}
//	
//}
//
