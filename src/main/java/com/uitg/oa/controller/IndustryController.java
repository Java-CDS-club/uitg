package com.uitg.oa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uitg.oa.entity.IndustryCode;
import com.uitg.oa.entity.IndustryCode;
import com.uitg.oa.services.UserService;
import com.uitg.oa.util.LangUtil;

@Controller
@RequestMapping("/industry")
public class IndustryController extends BaseController {
	@Autowired
    protected UserService userService;	
	public IndustryController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping("/list")
    public String getList(Model model,@ModelAttribute IndustryCode industry,Errors errors) {
        List industrylist = userService.findAll(IndustryCode.class);
        model.addAttribute("industrylist", industrylist);
        return "erp/industrylist"; 
    }
	
	@RequestMapping("/create")
    public String create(Model model,@ModelAttribute IndustryCode industry,Errors errors) {
		industry = new IndustryCode();
		model.addAttribute("industry", industry);
        return "erp/industry"; 
    }
	
	@RequestMapping("/edit")
    public String edit(Model model,@ModelAttribute IndustryCode industry,Errors errors) {
		industry = userService.findById(IndustryCode.class, industry.getId());
//		List srclanlist = LangUtil.getSrcTargetLang(ctx);
//		List tarlanlist = LangUtil.getSrcTargetLang(ctx);
//		model.addAttribute("srclanlist",srclanlist);
//		model.addAttribute("tarlanlist",tarlanlist);
		model.addAttribute("industry", industry);
     
        return "erp/industry"; 
    }
	
	@RequestMapping("/save")
    public String save(Model model,@ModelAttribute IndustryCode industry,Errors errors) {
		if(industry.getIndustrydesc()==null){
	    	String desc = LangUtil.getMessage("label.desc", ctx);
			errors.reject("validation.required", new String[]{desc}, "description is requried");
		}
		
		if(industry.getCode()==null){
	    	String code = LangUtil.getMessage("label.industry", ctx);
			errors.reject("validation.required", new String[]{code}, "industry is requried");
		}
		
		if(errors.hasErrors()) {
			//curr = new IndustryCode();
			model.addAttribute("industry", industry);
			return "erp/industry"; 
		}
		
		if(industry.getId()!=null){
			IndustryCode industryc = userService.findById(IndustryCode.class, industry.getId());
			industryc.setIndustrydesc(industry.getIndustrydesc());
			industryc.setCode(industry.getCode());
			userService.update(industry);
		}else{
			userService.save(industry);
		}
     
        return "erp/erphome"; 
    }

}
