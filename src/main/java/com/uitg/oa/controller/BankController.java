package com.uitg.oa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
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

import com.uitg.oa.entity.BankAccount;
import com.uitg.oa.entity.User;
import com.uitg.oa.services.BankService;
import com.uitg.oa.services.UserService;
import com.uitg.oa.util.LangUtil;

@Controller
@RequestMapping("/bank")
public class BankController extends BaseController {
	@Autowired
	BankService bankService;
	
	@ModelAttribute
	public BankAccount getBankAccount(){
		return new BankAccount();
	}
	
	@RequestMapping("/edit")
	public String editBankInfo(Model model, @Valid BankAccount bankAccount,Errors errors ){
		 UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	 User user = (User)userDetails;
    	 
    	 bankAccount = new BankAccount();
    	 String hql =  "select bank from BankAccount bank where bank.user.id='"+user.getId()+"'";
    	 List bankAccounts = (List)bankService.findByHql(hql);
    	 if(bankAccounts.size()>0){
    	    bankAccount =(BankAccount)bankAccounts.get(0);
    	 }
         if(bankAccount==null){
        	 bankAccount = new BankAccount();
         }
         model.addAttribute("bankAccount", bankAccount);
         model.addAttribute("bankuser", user);
		return "erp/bankedit";
	}
	
	@RequestMapping("/view")
	public String getBankInfo(Model model,@Valid BankAccount bankAccount,Errors errors ){ 
		 UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
   	     User user = (User)userDetails;
   	     Integer userid= user.getId();

         if(user.getUserType()==LangUtil.FREELANCER){
        	 userid = user.getId();
         }else{
        	 userid = 1;// admin user id =1
         }
   	  
         
    	 String hql =  "select bank from BankAccount bank where bank.user.id="+userid;
    	 List bankAccounts = (List)bankService.findByHql(hql);
    	 if(bankAccounts.size()>0){
     	    bankAccount =(BankAccount)bankAccounts.get(0);
     	 }
         if(bankAccount==null){
        	 bankAccount = new BankAccount();
         }
         model.addAttribute("bankAccount", bankAccount);
         model.addAttribute("bankuser", user);
		return "erp/bankedit";
	}
	
	@RequestMapping("/viewbankinfo")
	public String getViewBankInfo(Model model,@RequestParam Integer id, @Valid BankAccount bankAccount,Errors errors ){ 
   	     Integer userid= 0;
   	     if(id!=0){
   	    	userid= id;
   	     }
         
    	 String hql =  "select bank from BankAccount bank where bank.user.id="+userid;
    	 List bankAccounts = (List)bankService.findByHql(hql);
    	 if(bankAccounts.size()>0){
     	    bankAccount =(BankAccount)bankAccounts.get(0);
     	 }
         if(bankAccount==null){
        	 bankAccount = new BankAccount();
         }
         model.addAttribute("bankAccount", bankAccount);

		return "erp/bankedit1";
	}
	
	@RequestMapping("/save")
	public String saveBankInfo(Model model, @Valid @ModelAttribute BankAccount bankAccount,Errors errors){		    		    
		    if(StringUtils.isBlank(bankAccount.getName())){
		        String name = LangUtil.getMessage("label.user.name", ctx);
				errors.reject("validation.required", new String[]{name},"Name is requried");
			}
		    
		    if(StringUtils.isBlank(bankAccount.getSurname())){
		    	String name = LangUtil.getMessage("label.familyname", ctx);
				errors.reject("validation.required",  new String[]{name},"Family name is requried");
			}
		    
		    if(StringUtils.isBlank(bankAccount.getBankAccountName())){
		    	String name = LangUtil.getMessage("label.user.bankAccountName", ctx);
				errors.reject("validation.required", new String[]{name}, "Bank Account Name is requried");
			}
		    
		    if(StringUtils.isBlank(bankAccount.getBankAccountNo())){
		    	String accountno = LangUtil.getMessage("label.user.bankAccountNo", ctx);
				errors.reject("validation.required", new String[]{accountno}, "Bank account No is requried");
				return "erp/bankedit";
			}
		    
		    if(StringUtils.isBlank(bankAccount.getBankName())){
		    	String bankname = LangUtil.getMessage("label.user.bankName", ctx);
				errors.reject("validation.required", new String[]{bankname}, "Bank Name is requried");
			}
		    
		    if(errors.hasErrors()) {
		    	return "erp/bankedit";
	        }
	        
	        if(bankAccount.getId()!=null){
			    BankAccount ba = bankService.findById(BankAccount.class, bankAccount.getId());
		        ba.setBankAccountNo(bankAccount.getBankAccountNo());
		        ba.setBankAddress(bankAccount.getBankAddress());
		        ba.setBankName(bankAccount.getBankName());
		        ba.setIbanCode(bankAccount.getIbanCode());
		        ba.setPaypalAccount(bankAccount.getPaypalAccount());
		        ba.setSwiftCode(bankAccount.getSwiftCode());
		        ba.setUpdatedBy(bankAccount.getUser());
		        ba.setBankAccountName(bankAccount.getBankAccountName());
		        
		     
		        bankService.update(ba);       
	        }else{
	        	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        	User user = (User)userDetails;
	        	bankAccount.setCreatedBy(user);
	        	bankAccount.setUser(user);
	        	bankService.save(bankAccount);  
	        }
		return "redirect:/bank/edit";
	}

}
