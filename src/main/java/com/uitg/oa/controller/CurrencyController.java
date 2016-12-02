package com.uitg.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uitg.oa.entity.CurrencyCode;
import com.uitg.oa.services.UserService;
import com.uitg.oa.util.LangUtil;

@Controller
@RequestMapping("/currency")
public class CurrencyController extends BaseController {
	@Autowired
    protected UserService userService;	
	public CurrencyController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/list")
    public String getList(Model model,@ModelAttribute CurrencyCode curr,Errors errors) {
        List currlist = userService.findAll(CurrencyCode.class);
        model.addAttribute("currlist", currlist);
        return "erp/currencylist"; 
    }
	
	@RequestMapping("/create")
    public String create(Model model,@ModelAttribute CurrencyCode curr,Errors errors) {
		curr = new CurrencyCode();
		model.addAttribute("curr", curr);
        return "erp/currency"; 
    }
	
	@RequestMapping("/edit")
    public String edit(Model model,@ModelAttribute CurrencyCode curr,Errors errors) {
		curr = userService.findById(CurrencyCode.class, curr.getId());
//		List srclanlist = LangUtil.getSrcTargetLang(ctx);
//		List tarlanlist = LangUtil.getSrcTargetLang(ctx);
//		model.addAttribute("srclanlist",srclanlist);
//		model.addAttribute("tarlanlist",tarlanlist);
		model.addAttribute("curr", curr);
     
        return "erp/currency"; 
    }
	
	@RequestMapping("/save")
    public String save(Model model,@ModelAttribute CurrencyCode curr,Errors errors) {
		if(curr.getCurrdesc()==null){
	    	String desc = LangUtil.getMessage("label.desc", ctx);
			errors.reject("validation.required", new String[]{desc}, "description is requried");
		}
		
		if(curr.getCurr()==null){
	    	String currency = LangUtil.getMessage("label.currency", ctx);
			errors.reject("validation.required", new String[]{currency}, "currency is requried");
		}
		
		if(errors.hasErrors()) {
			//curr = new CurrencyCode();
			model.addAttribute("curr", curr);
			return "erp/currency"; 
		}
		
		if(curr.getId()!=null){
			CurrencyCode currency = userService.findById(CurrencyCode.class, curr.getId());
			currency.setCurrdesc(curr.getCurrdesc());
			currency.setCurr(curr.getCurr());
			userService.update(curr);
		}else{
			userService.save(curr);
		}
     
        return "erp/erphome"; 
    }

}
