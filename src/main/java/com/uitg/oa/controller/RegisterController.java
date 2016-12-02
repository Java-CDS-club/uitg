package com.uitg.oa.controller;

import java.security.KeyPair;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.octo.captcha.service.image.ImageCaptchaService;
import com.uitg.oa.bean.Page;
import com.uitg.oa.entity.RegistrantValue;
import com.uitg.oa.entity.User;
import com.uitg.oa.services.RegisterService;
import com.uitg.oa.util.JCryption;
import com.uitg.oa.util.LangUtil;
import com.uitg.oa.util.MD5Helper;

@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

	@Autowired
	private RegisterService registerService;
	
	@Autowired
    private ImageCaptchaService imageCaptchaService;
	
	@Autowired  
	private HttpSession session;
	 
	@RequestMapping("/new")
    public String register(Model model, @ModelAttribute RegistrantValue registrant) {
		registrant = new RegistrantValue ();
		List srclanlist = LangUtil.getSrcTargetLang(ctx);
		List tarlanlist = LangUtil.getSrcTargetLang(ctx);

		model.addAttribute("srclanlist",srclanlist);
		model.addAttribute("tarlanlist",tarlanlist);
        model.addAttribute("registrant", registrant);
        return "register";
    }
	
	@RequestMapping("/registerSub")
    public String registerSub(Model model, @Valid @ModelAttribute("registrant") RegistrantValue registrant, BindingResult errors, HttpServletRequest  request) {
		
		Boolean isResponseCorrect = imageCaptchaService.validateResponseForID(request.getSession().getId(), registrant.getVerifyCode());
		if(!isResponseCorrect){
			errors.rejectValue("verifyCode", "validation.verificationcode.invalid", "Invalid verfication Code");
		}
		
		if(!registrant.getPassword().equals(registrant.getConfirmPassword())){
			errors.reject("validation.inconsistpassword.invalid", "Inconsistent password and confirm password");
		}
		
		if(registrant.getFreelancer()){	
			if(StringUtils.isBlank(registrant.getSourceLanguage())){
				errors.reject("validation.pleaseselect。sourcelang", "source language is requried");
			}
			
			if(StringUtils.isBlank(registrant.getTargetLanguage())){
				errors.reject("validation.pleaseselect。targetlang","target language is requried");
			}
			
			if(registrant.getUnitPrice()==null){
    			errors.reject("validation.required。unitprice",  "unit price is requried");
    		}
		}else {
			if(StringUtils.isBlank(registrant.getCompanyName())){
    			errors.reject("validation.required。companyname", "company name is requried");
    		}
    		
    		if(StringUtils.isBlank(registrant.getInvoiceName())){
    			errors.reject("validation.required。invname", "invoice name is requried");
    		}
    		
    		if(StringUtils.isBlank(registrant.getInvoiceReceiver())){
    			errors.reject("validation.required。invrecevier", "invoice recevier is requried");
    		}
		}
		
		if(errors.hasErrors()){
			List srclanlist = LangUtil.getSrcTargetLang(ctx);
			List tarlanlist = LangUtil.getSrcTargetLang(ctx);

			model.addAttribute("srclanlist",srclanlist);
			model.addAttribute("tarlanlist",tarlanlist);
			return "register";
		}
		
		User user =  new User();
		user.setUsername(registrant.getUsername());
		user.setFirstName(registrant.getFirstName());
		user.setFamilyName(registrant.getFamilyName());
		user.setPrimaryEmail(registrant.getPrimaryEmail());
		if(registrant.getFreelancer()){	
			user.setSourceLanguage(registrant.getSourceLanguage());
			user.setTargetLanguage(registrant.getTargetLanguage());
			user.setUnitPrice(registrant.getUnitPrice());
		}else{
			user.setCompanyName(registrant.getCompanyName());
			user.setInvoiceName(registrant.getInvoiceName());
			user.setInvoiceReceiver(registrant.getInvoiceReceiver());
			user.setInvoiceTaxIdentifyNo(registrant.getInvoiceTaxIdentifyNo());
		}
		
		List users = registerService.findAllByExample(user);
		
		if(users!=null && users.size()>0){
			errors.reject("validation.userexist.invalid", "The username already exists");
			return "register";
		}
	
		KeyPair keypairs = (KeyPair)session.getAttribute("keys");
		JCryption jcryption = new JCryption();
		String password = registrant.getPassword();
        if(StringUtils.isNotEmpty(password)){
        	password = jcryption.decrypt(password, keypairs);
        	password = new MD5Helper().getMD5ofStr(password);
         }
        
		user.setPassword(password);
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String userno=dateformat.format(new Date());
		if(registrant.getFreelancer()){			
			user.setUserType("1");
			user.setUserno("FR"+userno);
		}else{
			SimpleDateFormat dateformat1=new SimpleDateFormat("yyyyMMddHHmmssSSS");
			user.setUserType("6");
			user.setUserno("C"+userno);
		}
		
		registerService.saveOrUpdate(user);
        return "registerSuccess";
    }

	@RequestMapping("/terms")
    public String term(Model model, @ModelAttribute RegistrantValue registrant) {
		
        return "terms";
    }
	
	@RequestMapping("/privicy")
    public String privicy(Model model, @ModelAttribute RegistrantValue registrant) {
		
        return "privicy";
    }

}
