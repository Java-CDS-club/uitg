package com.uitg.oa.controller;

import com.uitg.oa.bean.Context;
import com.uitg.oa.bean.Page;
import com.uitg.oa.entity.BankAccount;
import com.uitg.oa.entity.Option;
import com.uitg.oa.entity.Order;
import com.uitg.oa.entity.User;
import com.uitg.oa.services.OrderService;
import com.uitg.oa.services.UserService;
import com.uitg.oa.util.CommonUtil;
import com.uitg.oa.util.Html2PdfUtil;
import com.uitg.oa.util.LangUtil;
import com.uitg.oa.util.BeanCopier;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Description Here
 *
 * @author Michael
 */
@Controller
@RequestMapping("/pdf")
public class PdfController extends BaseAdminController {

    private Logger logger = LoggerFactory.getLogger(PdfController.class);

    @Autowired
    UserService userService;
    
    @Autowired
    OrderService orderService;
    
    @Autowired  
    private HttpSession session;  
    
    @Autowired  
    HttpServletRequest request;

    @ModelAttribute
    public User getUser() {
        return new User();
    }

   
    @RequestMapping("/tep")
    public String teppdf(Model model, @ModelAttribute Order order,HttpServletResponse response) {
    	order = orderService.findById(Order.class, order.getId());
    	String clientname = LangUtil.getMessage("label.clientname", ctx);
    	String projectname = LangUtil.getMessage("label.projectname", ctx);
    	String clientcontact = LangUtil.getMessage("label.clientcontact", ctx);
    	String datereceived = LangUtil.getMessage("label.datereceived", ctx);
    	String estimateddelivered = LangUtil.getMessage("label.estimateddelivered", ctx);
    	String presentedby = LangUtil.getMessage("label.presentedby", ctx);
    	String srclan = LangUtil.getMessage("label.sourcelang", ctx);
    	String targetlan = LangUtil.getMessage("label.targetlang", ctx);
    	String proposedtimef = LangUtil.getMessage("label.proposedtimef", ctx);
    	String projscope = LangUtil.getMessage("label.projscope", ctx);
    	String deliveryformat = LangUtil.getMessage("label.deliveryformat", ctx);
    	String curr = LangUtil.getMessage("label.currency", ctx);
    	String paymentterms = LangUtil.getMessage("label.paymentterms", ctx);
    	String grandtotal = LangUtil.getMessage("label.grandtotal", ctx);   	
    	String item = LangUtil.getMessage("label.item", ctx);
    	String quantity = LangUtil.getMessage("label.quantity", ctx);
    	String unit = LangUtil.getMessage("label.unit", ctx);
    	String rate = LangUtil.getMessage("label.rate", ctx);
    	String amountin = LangUtil.getMessage("label.amountin", ctx);
    	String notes = LangUtil.getMessage("label.notes", ctx);
    	String repetition = LangUtil.getMessage("label.repetition", ctx);
    	String match100 = LangUtil.getMessage("label.match100", ctx);
    	String match95 = LangUtil.getMessage("label.match95", ctx);
    	String match85 = LangUtil.getMessage("label.match85", ctx);
    	String match75 = LangUtil.getMessage("label.match75", ctx);
    	String word = LangUtil.getMessage("label.word", ctx);   	
    	String unique = LangUtil.getMessage("label.unique", ctx);
    	String filePrepration = LangUtil.getMessage("label.filePrepration", ctx);
    	String glossaryCreation = LangUtil.getMessage("label.glossaryCreation", ctx);
    	String dtp = LangUtil.getMessage("label.dtp", ctx);
    	String projectmgmtfee = LangUtil.getMessage("label.projectmgmtfee", ctx); 
    	String hour = LangUtil.getMessage("label.hour", ctx);
    	String page = LangUtil.getMessage("label.page", ctx);
    	String project = LangUtil.getMessage("label.project", ctx);
    	String transubtotal = LangUtil.getMessage("label.transubtotal", ctx);
    	String ensubtotal = LangUtil.getMessage("label.ensubtotal", ctx);
    	String total4lang = LangUtil.getMessage("label.total4lang", ctx);
    	String discount = LangUtil.getMessage("label.discount", ctx);
    	String total = LangUtil.getMessage("label.total", ctx);
    	StringBuffer sb = new StringBuffer();
    	sb.append("<html><body><div style=\"float:left;\"> <img src=\"http://localhost:8080/uitg/img/logo_big.png\"/></div>");
    	sb.append("<div style=\"float:right;text-align:right;\"><u><span style=\"font-size:20px;\">UITG Consulting Ltd</span></u><br/>上海坦诺商务咨询有限公司<br/><br/>上海静安区奉贤路194号<br/>Contact No.18616765616<br/>John Xiao</div>");
    	sb.append("<div style=\"clear:both;font-size:12px;\"><table class=\"table\"><tbody>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:20%;\" class=\"bblue bold\">"+clientname+"</td>");
    	sb.append("<td style=\"width:15%;\">"+order.getClient().getCompanyName()+"</td>");
    	sb.append("<td style=\"width:20%;\" class=\"bblue bold\">"+projectname+"</td>");
    	sb.append("<td style=\"width:15%;\">"+order.getOrderDesc()+"</td>");
    	sb.append("<td style=\"width:15%;\" class=\"bblue bold\">"+clientcontact+"</td>");
    	sb.append("<td style=\"width:15%;\">"+order.getClient().getFirstName()+"&#160; "+order.getClient().getFamilyName()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bblue bold\">"+datereceived+"</td>");
    	sb.append("<td>"+order.getOrderDate()+"</td>");
    	sb.append("<td class=\"bblue bold\">"+estimateddelivered+"</td>");
    	sb.append("<td>"+order.getDeliveryDate()+"</td>");
    	sb.append("<td class=\"bblue bold\">"+presentedby+"</td>");
    	sb.append("<td>"+"UITG Quotation Team"+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bblue bold\">"+srclan+"</td>");
    	sb.append("<td>"+LangUtil.getLang(order.getSourceLanguage())+"</td>");
    	sb.append("<td class=\"bblue bold\">"+targetlan+"</td>");
    	sb.append("<td>"+LangUtil.getLang(order.getTargetLanguage())+"</td>");
    	sb.append("<td class=\"bblue bold\">"+proposedtimef+"</td>");
    	sb.append("<td>"+"10 business days"+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bblue bold\">"+projscope+"</td>");
    	sb.append("<td>"+"TEP"+"</td>");
    	sb.append("<td class=\"bblue bold\">"+deliveryformat+"</td>");
    	sb.append("<td>"+"Same as Source"+"</td>");
    	sb.append("<td class=\"bblue bold\">"+curr+"</td>");
    	sb.append("<td>"+order.getCurrency()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bblue bold\">"+paymentterms+"</td>");
    	sb.append("<td>"+"30 Days"+"</td>");
    	sb.append("<td class=\"bblue bold\"><span class=\"red\">"+grandtotal+":"+order.getCurrency()+"</span></td>");
    	sb.append("<td colspan=\"3\">"+order.getTotalamt()+"</td>");
    	sb.append("</tr>");
    	sb.append("</tbody>");
    	sb.append("</table>");
    	
    	sb.append("<table class=\"table\"><tbody>");
    	sb.append("<tr><td colspan=\"6\" style=\"height:20px;\"></td></tr>");
    	sb.append("<tr class=\"bblue bold\">");
    	sb.append("<td>"+LangUtil.getLang(order.getTargetLanguage())+"</td><td colspan=\"5\"></td>");
    	sb.append("</tr>");
    	sb.append("<tr class=\"bblue2\">");
    	sb.append("<td style=\"width:20%;\" class=\"colcenter bold\">"+item+"</td>");
    	sb.append("<td style=\"width:15%;\" class=\"colcenter bold\">"+unit+"</td>");
    	sb.append("<td style=\"width:10%;\" class=\"colcenter bold\">"+quantity+"</td>");
    	sb.append("<td style=\"width:10%;\" class=\"colcenter bold\">"+rate+"&#160; "+order.getCurrency()+"</td>");
    	sb.append("<td style=\"width:15%;\" class=\"colcenter bold\"><span class=\"red\">"+amountin+"&#160; "+order.getCurrency()+"</span></td>");
    	sb.append("<td style=\"width:30%;\" class=\"colcenter bold\">"+notes+"</td>");
    	sb.append("</tr>");
//    	sb.append("<tr>");
//    	sb.append("<td class=\"colcenter bold\">"+"Translations,Editing &amp; Proofreading"+"</td><td colspan=\"5\"></td>");
//    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter bold\">Translations,Editing</td>");
    	sb.append("<td>"+hour+"</td>");
    	sb.append("<td class=\"colright\">"+order.getEdit()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getEditRate()))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getEdit()*order.getEditRate()))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter bold\">Proofreading</td>");
    	sb.append("<td>"+hour+"</td>");
    	sb.append("<td class=\"colright\">"+order.getProofread()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getProofreadRate()))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getProofread()*order.getProofreadRate()))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+repetition+"</td>");
    	sb.append("<td>"+word+"</td>");
    	sb.append("<td class=\"colright\">"+order.getRepetition()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getUniqueRate()*0.3))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getRepetition()*order.getUniqueRate()*0.3))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+match100+"</td>");
    	sb.append("<td>"+word+"</td>");
    	sb.append("<td class=\"colright\">"+order.getMatch100()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getUniqueRate()*0.5))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getMatch100()*order.getUniqueRate()*0.5))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+match95+"</td>");
    	sb.append("<td>"+word+"</td>");
    	sb.append("<td class=\"colright\">"+order.getMatch95()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getUniqueRate()*0.6))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getMatch95()*order.getUniqueRate()*0.6))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+match85+"</td>");
    	sb.append("<td>"+word+"</td>");
    	sb.append("<td class=\"colright\">"+order.getMatch85()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getUniqueRate()*0.7))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getMatch85()*order.getUniqueRate()*0.7))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+match75+"</td>");
    	sb.append("<td>"+word+"</td>");
    	sb.append("<td class=\"colright\">"+order.getMatch75()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getUniqueRate()*0.8))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getMatch75()*order.getUniqueRate()*0.8))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+unique+"</td>");
    	sb.append("<td>"+word+"</td>");
    	sb.append("<td class=\"colright\">"+order.getUnique()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getUniqueRate()))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getUnique()*order.getUniqueRate()))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr class=\"bblue\">");
    	sb.append("<td class=\"colcenter bold\">"+transubtotal+"("+order.getCurrency()+")"+"</td>");
    	double transtotalamt = order.getEdit()*order.getEditRate()+order.getProofread()*order.getProofreadRate()
    			+order.getUniqueRate()*(order.getRepetition()*0.3+ order.getMatch100()*0.5
    			+order.getMatch95()*0.6+order.getMatch85()*0.7
    			+order.getMatch75()*0.8+order.getUnique());
    	sb.append("<td class=\"colright bold\" colspan=\"5\">"+Double.valueOf(CommonUtil.doublewith2(transtotalamt))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+filePrepration+"</td>");
    	sb.append("<td>"+hour+"</td>");
    	sb.append("<td class=\"colright\">"+order.getFilePrepration()+"</td>");
    	sb.append("<td class=\"colright\">150</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getFilePrepration()*150))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+glossaryCreation+"</td>");
    	sb.append("<td>"+hour+"</td>");
    	sb.append("<td class=\"colright\">"+order.getGlossary()+"</td>");
    	sb.append("<td class=\"colright\">150</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getGlossary()*150))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\">"+dtp+"</td>");
    	sb.append("<td>"+page+"</td>");
    	sb.append("<td class=\"colright\">"+order.getDtp()+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getDtpRate()))+"</td>");
    	sb.append("<td class=\"colright\">"+Double.valueOf(CommonUtil.doublewith2(order.getDtp()*order.getDtpRate()))+"</td>");
    	sb.append("<td>"+""+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr class=\"bblue\">");
    	double ensubtotalamt = order.getFilePrepration()*150+order.getGlossary()*150+order.getDtp()*order.getDtpRate();
    	sb.append("<td class=\"colcenter bold\">"+ensubtotal+"("+order.getCurrency()+")"+"</td>");
    	sb.append("<td class=\"colright bold\" colspan=\"5\">"+Double.valueOf(CommonUtil.doublewith2(ensubtotalamt))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr><td colspan=\"6\" style=\"height:20px;\"></td></tr>");
    	sb.append("</tr>");
    	sb.append("<tr class=\"bblue\">");
    	sb.append("<td class=\"colcenter bold\">"+projectmgmtfee+"</td>");
    	sb.append("<td>"+project+"</td>");
    	sb.append("<td class=\"colright\">1</td>");
    	sb.append("<td class=\"colright\">3%</td>");
    	sb.append("<td>"+""+"</td>");
    	double total4amt=transtotalamt+ensubtotalamt;
    	sb.append("<td class=\"colright bold\">"+Double.valueOf(CommonUtil.doublewith2(total4amt*0.03))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr><td colspan=\"6\" style=\"height:20px;\"</td></tr>");
    	sb.append("<tr class=\"bblue\">");
    	sb.append("<td class=\"colcenter bold\"><span class=\"red\">"+total4lang+"</span></td>");
    	
    	sb.append("<td class=\"colright bold\" colspan=\"5\">"+Double.valueOf(CommonUtil.doublewith2(total4amt*(1+0.03)))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr class=\"bblue\">");
    	sb.append("<td class=\"colcenter bold\">"+discount+"</td>");
    	sb.append("<td class=\"colright bold\" colspan=\"5\">"+CommonUtil.doublewith2(order.getDiscount())+"%</td>");
    	sb.append("</tr>");
    	sb.append("<tr class=\"bred\">");
    	sb.append("<td class=\"colcenter bold\">"+total+"("+order.getCurrency()+")"+"</td>");
    	sb.append("<td class=\"colcenter bold\" colspan=\"5\">"+Double.valueOf(CommonUtil.doublewith2(total4amt*(1+0.03)*((100-order.getDiscount())/100)))+"</td>");
    	sb.append("</tr>");
    	sb.append("</tbody></table></div></body></html>");
    	try {
    		
    		ByteArrayOutputStream bos = Html2PdfUtil.convertHtml2Pdf(sb.toString(),true);
    		byte[] pdf = bos.toByteArray();
    		//response.reset();      
 			//response.setContentType("APPLICATION/OCTET-STREAM");  
    		response.setContentType("application/pdf");
 	        response.setHeader("Content-Disposition", "inline; filename=TEP.pdf");
 	        response.setContentLength(pdf.length); 
		    OutputStream ouputStream = response.getOutputStream();  
            ouputStream.write(pdf, 0, pdf.length);  
            ouputStream.flush();  
            ouputStream.close(); 

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    @RequestMapping("/invoice")
    public String invpdf(Model model, @ModelAttribute Order order,HttpServletResponse response) {
    	order = orderService.findById(Order.class, order.getId());
    	BankAccount ba = orderService.findById(BankAccount.class, 1);
    	String clientname = LangUtil.getMessage("label.clientname", ctx);
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append("<html><body><div style=\"float:left;\"> <img src=\"http://localhost:8080/uitg/img/logo_big.png\"/></div>");
    	sb.append("<div style=\"float:right;text-align:right;\"><u><span style=\"font-size:20px;\">UITG Consulting Ltd</span></u><br/>上海坦诺商务咨询有限公司<br/><br/>上海静安区奉贤路194号<br/>Contact No.18616765616<br/>John Xiao</div>");
    	sb.append("<div style=\"clear:both;font-size:12px;\"><hr/><table style=\"width:100%;\"><tbody>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\"></td>");
    	sb.append("<td class=\"colright bold\" style=\"font-size:40px;\">INVOICE</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\">To: &#160;&#160;"+ order.getClient().getInvoiceReceiver()+"</td>");
    	sb.append("<td class=\"bold\"></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\"></td>");
    	sb.append("<td class=\"bold\">Date Sent:"+ (new java.text.SimpleDateFormat("MMM dd,yyyy")).format(new Date())+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\"></td>");
    	sb.append("<td class=\"bold\">Invoice No."+ order.getPo()+"</td>");
    	sb.append("</tr></tbody></table>");
    	sb.append("<table style=\"width:100%;\"><tbody><tr><td style=\"padding-top:100px;\"></td></tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bold\">Dear Sir/Madam,</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"padding-left:100px;\">The following invoice is payable "+ "30"+" days after receipt at the latest;</td>");
    	sb.append("</tr>");
    	sb.append("<tr></tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bold\">Project Description:</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"padding-left:120px;\">"+order.getOrderDesc()+"</td>");
    	sb.append("</tr>");
    	sb.append("</tbody></table>");
    	sb.append("<table class=\"table\"><tbody>");
    	sb.append("<tr class=\"bblue\">");
    	sb.append("<td class=\"colcenter bold\" style=\"width:10%;\">Qty.</td>");
    	sb.append("<td class=\"colcenter bold\" style=\"width:60%;\">Description</td>");
    	sb.append("<td class=\"colcenter bold\" style=\"width:10%;\">Unit Price</td>");
    	sb.append("<td class=\"colcenter bold\" style=\"width:20%;\">Line Total</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"colcenter\" style=\"width:10%;\">1</td>");
    	sb.append("<td style=\"width:60%;\">Description</td>");
    	sb.append("<td class=\"colright\" style=\"width:10%;\">N/A</td>");
    	sb.append("<td class=\"colright\" style=\"width:20%;\">"+Double.valueOf(CommonUtil.doublewith2(order.getTotalamt()))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:10%;border:0px;\"></td>");
    	sb.append("<td style=\"width:60%;border:0px;\"></td>");
    	sb.append("<td class=\"colright\" style=\"width:10%;\">Sub-total:</td>");
    	sb.append("<td class=\"colright\" style=\"width:20%;\">"+Double.valueOf(CommonUtil.doublewith2(order.getTotalamt()))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:10%;border:0px;\"></td>");
    	sb.append("<td style=\"width:60%;border:0px;\"></td>");
    	sb.append("<td class=\"colright\" style=\"width:10%;\">Tax:</td>");
    	sb.append("<td class=\"colright\" style=\"width:20%;\">0.0</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:10%;border:0px;\"></td>");
    	sb.append("<td style=\"width:60%;border:0px;\"></td>");
    	sb.append("<td class=\"colright\" style=\"width:10%;\">Total</td>");
    	sb.append("<td class=\"colright\" style=\"width:20%;\">"+Double.valueOf(CommonUtil.doublewith2(order.getTotalamt()))+"</td>");
    	sb.append("</tr>");
    	sb.append("</tbody></table>");   	
    	sb.append("<table style=\"width:100%;\" ><tbody>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bold\" style=\"width:70%;padding-top:50px;\">Chinese Bank Detail:(CNY only)</td>");
    	sb.append("<td></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bold\" style=\"width:70%;\">Name:"+ba.getBankName()+"</td>");
    	sb.append("<td></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bold\" style=\"width:70%;\">Account Name 户名:"+ba.getBankAccountName()+"</td>");
    	sb.append("<td></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td class=\"bold\" style=\"width:70%;\">Bank Account No.:"+ba.getBankAccountNo()+"</td>");
    	sb.append("<td></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\"></td>");
    	sb.append("<td class=\"bold\">Contact Details:</td>");    	
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\"></td>");
    	sb.append("<td>Tel:0086+186 1676 5616</td>");    	
    	sb.append("</tr>");
    	sb.append("<tr><td></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\"></td>");
    	sb.append("<td>Email:</td>");    	
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:70%;\"></td>");
    	sb.append("<td>john.xiao@uitg.co</td>");    	
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td>Best Regards,</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td>John</td>");
    	sb.append("</tr>");
    	sb.append("</tbody></table>");
    	sb.append("</div></body></html>");
    	try {
    		ByteArrayOutputStream bos = Html2PdfUtil.convertHtml2Pdf(sb.toString(),false);
    		byte[] pdf = bos.toByteArray();
    		//response.reset();      
 			//response.setContentType("APPLICATION/OCTET-STREAM");  
    		response.setContentType("application/pdf");
 	        response.setHeader("Content-Disposition", "inline; filename=Invoice.pdf");
 	        response.setContentLength(pdf.length); 
		    OutputStream ouputStream = response.getOutputStream();  
            ouputStream.write(pdf, 0, pdf.length);  
            ouputStream.flush();  
            ouputStream.close(); 
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    @RequestMapping("/offer")
    public String offerpdf(Model model, @ModelAttribute Order order,@RequestParam(required = false, defaultValue = "0") Integer userid, HttpServletResponse response) {
    	order.setAssignee(new User(userid));
    	String hql = "select order from Order order where order.po='"+order.getPo()+"' and order.assignee.id='"+userid+"'";
    	List orders = (List)orderService.findByHql(hql);
    	order = (Order)orders.get(0);
    	
    	BankAccount  bankAccount = new BankAccount();
	   	hql =  "select bank from BankAccount bank where bank.user.id='"+userid+"'";
	   	List bankAccounts = (List)orderService.findByHql(hql);
	   	if(bankAccounts.size()>0){
	   	    bankAccount =(BankAccount)bankAccounts.get(0);
	   	}
        if(bankAccount==null){
       	 bankAccount = new BankAccount();
        }
    	String clientname = LangUtil.getMessage("label.clientname", ctx);
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append("<html><body>");
    	sb.append("<table class=\"table\" style=\"width:100%;clear:both;\"><tbody>");
    	sb.append("<tr><td colspan=\"4\" class=\"colright\">PO No."+order.getPo());
    	sb.append("<div style=\"text-align:left;\">UITG Purchase Order For "+order.getAssignee().getFirstName()+" &#160;"+order.getAssignee().getFamilyName()+"</div>");
    	sb.append("<div style=\"margin-top:20px;\"> &#160; </div></td></tr>");
    	sb.append("<tr><td colspan=\"4\">");
    	sb.append("<div style=\"float:left;position: absolute; top: 15%;left:2%;\"> <img src=\"http://localhost:8080/uitg/img/logo_big.png\"/></div>");
    	sb.append("<div style=\"float:right;text-align:right;\"><u><span style=\"font-size:20px;margin-top:20px;\">UITG Consulting Ltd</span></u><br/>上海坦诺商务咨询有限公司<br/><br/>");
    	sb.append("上海静安区奉贤路194号<br/>Contact No.18616765616<br/>John Xiao</div><div style=\"margin-top:20px;clear:both;\"> &#160;</div>");
    	sb.append("</td></tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Project Name:</td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"4\" class=\"colcenter\">"+order.getOrderDesc()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Project Date:</td>");
    	sb.append("<td style=\"width:25%;\" class=\"colright\">"+order.getOrderDate()+"</td>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Source Language:</td>");
    	sb.append("<td style=\"width:25%;\" >"+LangUtil.getLang(order.getSourceLanguage())+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">File Received:</td>");
    	sb.append("<td style=\"width:25%;\" class=\"colright\">"+order.getOrderDate()+"</td>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Target Language:</td>");
    	sb.append("<td style=\"width:25%;\" >"+LangUtil.getLang(order.getTargetLanguage())+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">PO Issue Date:</td>");
    	sb.append("<td style=\"width:25%;\" class=\"colright\">"+order.getOrderDate()+"</td>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Currency:</td>");
    	sb.append("<td style=\"width:25%;\" >"+order.getCurrency()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\"></td>");
    	sb.append("<td style=\"width:25%;\" class=\"colright\"></td>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Payment Terms:</td>");
    	sb.append("<td style=\"width:25%;\" >Net 45 Days</td>");
    	sb.append("</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colright\" style=\"height:20px;\"> </td</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Unit Price/word:</td>");
    	sb.append("<td style=\"width:25%;\" class=\"colright\">"+order.getAssignee().getUnitPrice()+"</td>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Quantity:</td>");
    	sb.append("<td style=\"width:25%;\" class=\"colright\">"+order.getCharacterCount()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Payment Amount: </td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"3\" class=\"colcenter\">"+Double.valueOf(CommonUtil.doublewith2(order.getAmount()))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colright\" style=\"height:20px;\"></td</tr>");
    	sb.append("<tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Incentive: </td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"3\" class=\"colcenter\">0.0</td>");
    	sb.append("</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colright\" style=\"height:20px;\"></td</tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Total: </td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"3\" class=\"colcenter\">"+Double.valueOf(CommonUtil.doublewith2(order.getAmount()))+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colright\" style=\"height:20px;\"> </td</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colcenter bblue2\">Banking Info </td</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Country&amp;City: </td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"3\" class=\"colcenter\">"+bankAccount.getCity()+" &#160; " +bankAccount.getCountry()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Account Name: </td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"3\" class=\"colcenter\">"+bankAccount.getBankAccountName()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">Bank Name: </td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"3\" class=\"colcenter\">"+bankAccount.getBankName()+"<span class=\"red\">(请用中文填写支行名称)</span></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:25%;\" class=\"bold bblue\">BankAccount: </td>");
    	sb.append("<td style=\"width:75%;\" colspan=\"3\" class=\"colcenter\">"+bankAccount.getBankAccountNo()+"<span class=\"red\">(请确认账号是否正确)</span></td>");
    	sb.append("</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colright\"> </td</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colcenter\" style=\"height:20px;\">Notes </td</tr>");
    	sb.append("<tr><td colspan=\"4\" >Incentive: This is for exellent translations that exceed our expectation. The better the quality, the more amount we will give you. </td</tr>");
    	sb.append("<tr><td colspan=\"4\" ><span class=\"red\">Please double check your banking Info and confirm with us by email. Thanks </span></td</tr>");
    	sb.append("<tr><td colspan=\"4\" class=\"colright\"> </td</tr>");
    	sb.append("</tbody></table>");    	   	
    	sb.append("</body></html>");
    	
    	try {
    		ByteArrayOutputStream bos = Html2PdfUtil.convertHtml2Pdf(sb.toString(),false);
    		byte[] pdf = bos.toByteArray();
    		//response.reset();      
 			//response.setContentType("APPLICATION/OCTET-STREAM");  
    		response.setContentType("application/pdf");
 	        response.setHeader("Content-Disposition", "inline; filename=Invoice.pdf");
 	        response.setContentLength(pdf.length); 
		    OutputStream ouputStream = response.getOutputStream();  
            ouputStream.write(pdf, 0, pdf.length);  
            ouputStream.flush();  
            ouputStream.close(); 
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
    @RequestMapping("/proofedit")
    public String proofeditpdf(Model model, @ModelAttribute Order order,HttpServletResponse response) {
    	order = orderService.findById(Order.class, order.getId());
    	String clientname = LangUtil.getMessage("label.clientname", ctx);
    	
    	StringBuffer sb = new StringBuffer();
    	sb.append("<html><body>");
    	sb.append("<table class=\"table\" style=\"width:100%;clear:both;\"><tbody>");
    	sb.append("<tr><td colspan=\"6\">");
    	sb.append("<div style=\"float:left;position: absolute; top: 15%;left:2%;\"> <img src=\"http://localhost:8080/uitg/img/logo_big.png\"/></div>");
    	sb.append("<div style=\"float:right;text-align:right;\"><u><span style=\"font-size:20px;margin-top:20px;\">UITG Consulting Ltd</span></u><br/>上海坦诺商务咨询有限公司<br/><br/>");
    	sb.append("上海静安区奉贤路194号<br/>Contact No.18616765616<br/>John Xiao</div><div style=\"margin-top:20px;clear:both;\"> &#160;</div>");
    	sb.append("</td></tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Client Name:</td>");
    	sb.append("<td style=\"width:18%;\" >"+order.getClient().getCompanyName()+"</td>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Project Scope:</td>");
    	sb.append("<td style=\"width:17%;\" >P &amp; E</td>");
    	sb.append("<td style=\"width:20%;\" class=\"bold bblue\">Quotation Accepted?</td>");
    	sb.append("<td style=\"width:18%;\" >"+order.getNeedModify()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Project Name:</td>");
    	sb.append("<td style=\"width:18%;\" >"+order.getOrderDesc()+"</td>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Source Language:</td>");
    	sb.append("<td style=\"width:17%;\" >"+LangUtil.getLang(order.getSourceLanguage())+"</td>");
    	sb.append("<td style=\"width:20%;\" class=\"bold bblue\">Purchase Order Signed</td>");
    	sb.append("<td style=\"width:18%;\" ></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Client Contact:</td>");
    	sb.append("<td style=\"width:18%;\" >"+order.getClient().getFirstName()+" "+order.getClient().getFamilyName()+"</td>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Target Language:</td>");
    	sb.append("<td style=\"width:17%;\" >"+LangUtil.getLang(order.getTargetLanguage())+"</td>");
    	sb.append("<td style=\"width:20%;\" class=\"bold bblue\">Purchase Date</td>");
    	sb.append("<td style=\"width:18%;\" >"+order.getOrderDate()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Date Received:</td>");
    	sb.append("<td style=\"width:18%;\" >"+order.getOrderDate()+"</td>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Delivery Format:</td>");
    	sb.append("<td style=\"width:17%;\" >Same as Source</td>");
    	sb.append("<td style=\"width:20%;\" class=\"bold bblue\">Currency</td>");
    	sb.append("<td style=\"width:18%;\" >"+order.getCurrency()+"</td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Project Period:</td>");
    	sb.append("<td style=\"width:18%;\" >2 Biz days</td>");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue\">Payment Terms:</td>");
    	sb.append("<td style=\"width:17%;\" >30 Days</td>");
    	sb.append("<td style=\"width:20%;\" class=\"bold bblue\">Grand Total: "+order.getCurrency()+"</td>");
    	sb.append("<td style=\"width:18%;\" >"+Double.valueOf(CommonUtil.doublewith2(order.getProofread()*order.getProofreadRate()+order.getEdit()*order.getEditRate()))+"</td>");
    	sb.append("</tr>");
    	sb.append("</tbody></table>");
    	sb.append("<table class=\"table\" style=\"width:100%;margin-top:50px;\"><tbody>");
    	sb.append("<tr class=\"bblue2 bold colcenter\"><td colspan=\"7\">");
    	sb.append("Target Language :"+order.getTargetLanguage()+" Proofreading &amp; Editting Only</td></tr>");
    	sb.append("<tr >");
    	sb.append("<td style=\"width:15%;\" class=\"bold bblue colcenter\">Item</td>");
    	sb.append("<td style=\"width:18%;\" class=\"bold bblue colcenter\">Unit of Measure</td>");
    	sb.append("<td style=\"width:6%;\" class=\"bold bblue colcenter\">Quantity</td>");
    	sb.append("<td style=\"width:9%;\" class=\"bold bblue colcenter\">Rate</td>");
    	sb.append("<td style=\"width:17%;\" class=\"bold bblue colcenter\">Amount in &#160;"+order.getCurrency()+"</td>");
    	sb.append("<td style=\"width:20%;\" class=\"bold bblue colcenter\">Notes</td>");
    	sb.append("<td style=\"width:18%;\" class=\"bold bblue colcenter\">Others</td>");
    	sb.append("</tr>");
    	sb.append("<tr >");
    	sb.append("<td style=\"width:15%;\" class=\"colcenter\">Proofreading</td>");
    	sb.append("<td style=\"width:18%;\" class=\"colcenter\">hour</td>");
    	sb.append("<td style=\"width:6%;\" class=\"colcenter\">"+order.getProofread()+"</td>");
    	sb.append("<td style=\"width:9%;\" class=\"colcenter\">"+order.getProofreadRate()+"</td>");
    	sb.append("<td style=\"width:17%;\" class=\"colcenter\">"+Double.valueOf(CommonUtil.doublewith2(order.getProofread()*order.getProofreadRate()))+"</td>");
    	sb.append("<td style=\"width:20%;\" class=\"colcenter\"></td>");
    	sb.append("<td style=\"width:18%;\" class=\"colcenter\"></td>");
    	sb.append("</tr>");
    	sb.append("<tr >");
    	sb.append("<td style=\"width:15%;\" class=\"colcenter\">Editting</td>");
    	sb.append("<td style=\"width:18%;\" class=\"colcenter\">hour</td>");
    	sb.append("<td style=\"width:6%;\" class=\"colcenter\">"+order.getEdit()+"</td>");
    	sb.append("<td style=\"width:9%;\" class=\"colcenter\">"+order.getEditRate()+"</td>");
    	sb.append("<td style=\"width:17%;\" class=\"colcenter\">"+Double.valueOf(CommonUtil.doublewith2(order.getEdit()*order.getEditRate()))+"</td>");
    	sb.append("<td style=\"width:20%;\" class=\"colcenter\"></td>");
    	sb.append("<td style=\"width:18%;\" class=\"colcenter\"></td>");
    	sb.append("</tr>");
    	sb.append("<tr>");
    	sb.append("<td style=\"width:15%;\" class=\"bold colcenter\">Translation Subtotal:</td>");  	
    	sb.append("<td colspan=\"6\" class=\"colcenter\">"+Double.valueOf(CommonUtil.doublewith2(order.getProofread()*order.getProofreadRate()+order.getEdit()*order.getEditRate()))+"</td>");
    	sb.append("</tr>");
    	sb.append("</tbody></table>");  	
    	sb.append("</body></html>");
    	try {
    		ByteArrayOutputStream bos = Html2PdfUtil.convertHtml2Pdf(sb.toString(),true);
    		byte[] pdf = bos.toByteArray();
    		//response.reset();      
 			//response.setContentType("APPLICATION/OCTET-STREAM");  
    		response.setContentType("application/pdf");
 	        response.setHeader("Content-Disposition", "inline; filename=Invoice.pdf");
 	        response.setContentLength(pdf.length); 
		    OutputStream ouputStream = response.getOutputStream();  
            ouputStream.write(pdf, 0, pdf.length);  
            ouputStream.flush();  
            ouputStream.close(); 
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }
    
}
