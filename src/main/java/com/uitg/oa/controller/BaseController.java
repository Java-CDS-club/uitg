package com.uitg.oa.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.uitg.oa.bean.SelectLabelBean;
import com.uitg.oa.entity.CurrencyCode;
import com.uitg.oa.entity.IndustryCode;
import com.uitg.oa.entity.User;
import com.uitg.oa.services.UserService;

/**
 * Description Here
 *
 * @author Michael
 */
public abstract class BaseController {
	@Autowired
	public ApplicationContext ctx;
	
	@Autowired
    protected UserService userService;
	
    public int getPageSize() {
        return 20;
    }
    
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }
    
    public  List  getClientType(){
		List clientType = new ArrayList ();
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) userDetails;

        Locale locale = new Locale("en", "US");
        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }

//      String vip = ctx.getMessage("label.vip", null, locale);
//	    String important =  ctx.getMessage("label.important", null, locale);
//	    String big = ctx.getMessage("label.big", null, locale);
//	    String small =  ctx.getMessage("label.small", null, locale);
	   // String select = ctx.getMessage("label.pleaseselect", null, locale);
        String contract  = ctx.getMessage("label.contract", null, locale);
        String active  = ctx.getMessage("label.active", null, locale);
        String potential   = ctx.getMessage("label.potential", null, locale);

	    //clientType.add(new SelectLabelBean("--"+select+"--",""));
	    clientType.add(new SelectLabelBean (contract, "C"));
	    clientType.add(new SelectLabelBean (active, "A"));
	    clientType.add(new SelectLabelBean (potential, "P"));
//	    clientType.add(new SelectLabelBean (vip, "VIP"));
//	    clientType.add(new SelectLabelBean (important, "IMPORTANT"));
//	    clientType.add(new SelectLabelBean (big, "BIG"));
//	    clientType.add(new SelectLabelBean (small, "SMALL"));
	    
	    
        return clientType;
    }
    
    public  List  getCurrency(){
		List currlist = new ArrayList ();

        List currs = userService.findAll(CurrencyCode.class);
        
        for(int i=0;i<currs.size();i++){
        	CurrencyCode c = (CurrencyCode)currs.get(i);
            currlist.add(new SelectLabelBean(c.getCurr(),c.getCurr()));
        }
	    
        return currlist;
    }
    
    public  List  getFreelanceType(){
		List freelances = new ArrayList ();
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) userDetails;

        Locale locale = new Locale("en", "US");
        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }


        String active  = ctx.getMessage("label.active", null, locale);
        String passive   = ctx.getMessage("label.passive", null, locale);

        freelances.add(new SelectLabelBean (active, "A"));
        freelances.add(new SelectLabelBean (passive, "P"));

	    
        return freelances;
    }
    
    public  List  getFreelanceQuality(){
		List freelances = new ArrayList ();
	

        freelances.add(new SelectLabelBean ("A", "A"));
        freelances.add(new SelectLabelBean ("B", "B"));
        freelances.add(new SelectLabelBean ("C", "C"));
	    
        return freelances;
    }
    
    public  List  getIndustry(){
    	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) userDetails;

        Locale locale = new Locale("en", "US");
        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }
		List industrylist = new ArrayList ();

        List inds = userService.findAll(IndustryCode.class);
        String select = ctx.getMessage("label.pleaseselect", null, locale);
        industrylist.add(new SelectLabelBean("--"+select+"--",""));
        for(int i=0;i<inds.size();i++){
        	IndustryCode c = (IndustryCode)inds.get(i);
        	industrylist.add(new SelectLabelBean(c.getCode(),c.getCode()));
        }
	    
        return industrylist;
    }
}
