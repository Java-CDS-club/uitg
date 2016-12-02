package com.uitg.oa.util;

import java.io.UnsupportedEncodingException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.uitg.oa.entity.User;
import com.uitg.oa.services.UserService;
import com.uitg.oa.bean.SelectLabelBean;

public class LangUtil {
	public final static String CHINESE= "zh_CN";
	public final static String ENGLISH= "en_US";
	public final static String FREELANCER= "1";
	public final static String ADMIN= "2";
	public final static String SALES= "3";
	public final static String FINANCE= "4";
	public final static String PROJECTMANAGER= "5";
	public final static String CLIENT= "6";
	
	public final static String ORDER_STATUS_QUOTE="O";
	public final static String ORDER_STATUS_TRANSLATION="T";
	public final static String ORDER_STATUS_COPYEDIT="C";
	public final static String ORDER_STATUS_SUBMIT="S";
	public final static String ORDER_STATUS_FINISH="F";
	public final static String ORDER_STATUS_PENDING="P";
	public final static String ORDER_STATUS_APPOVE="A";

	
	public static List getSupportLanguage(ApplicationContext ctx){
		List supportLang = new ArrayList ();
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) userDetails;

        Locale locale = new Locale("en", "US");
        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }
        
        
        String english = ctx.getMessage("label.en", null, locale);
	    String chinese =  ctx.getMessage("label.cn", null, locale);
	    String select = ctx.getMessage("label.pleaseselect", null, locale);
	    
	    supportLang.add(new SelectLabelBean("--"+select+"--",""));
	    supportLang.add(new SelectLabelBean (english, ENGLISH));
	    supportLang.add(new SelectLabelBean (chinese, CHINESE));
	    
	    return supportLang;
	}
	
	public static List getSrcTargetLang(ApplicationContext ctx){
		List supportLang = new ArrayList ();
	
		UserDetails userDetails =null;
		User user =null;
		if( SecurityContextHolder.getContext().getAuthentication()!=null){
			userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    user = (User) userDetails;
		}

        Locale locale = new Locale("en", "US");
        if (user!=null && "zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }
        
        
//        String english = ctx.getMessage("label.en", null, locale);
//	    String chinese =  ctx.getMessage("label.cn", null, locale);
	    String select = ctx.getMessage("label.pleaseselect", null, locale);
	    
	    supportLang.add(new SelectLabelBean("--"+select+"--",""));
//	    supportLang.add(new SelectLabelBean (english, "EN"));
//	    supportLang.add(new SelectLabelBean (chinese, "CN"));
	    
	    Locale[] list = Locale.getAvailableLocales();
        List langs = new ArrayList(list.length);
	    for (int i = 0; i < list.length; i++) {
                String str = list[i].getDisplayCountry();
                if (StringUtils.isNotEmpty(str)) {
                    str = list[i].getDisplayName(locale);	                               
                    if(!"ja_JP_JP ".equalsIgnoreCase(list[i].toString())&& !"th_TH_TH".equalsIgnoreCase(list[i].toString())){
                      langs.add(str+"-"+list[i].toString());
                    }
                }
	    }
	    Collections.sort(langs);
	    for(int i=0;i<langs.size();i++){
	    	String lang= (String)langs.get(i);
	    	StringTokenizer st = new StringTokenizer(lang, "-");
	    	String language = st.nextToken();
	    	String lanstr = st.nextToken();
	    	supportLang.add(new SelectLabelBean( language, lanstr)); 
	    }
	    return supportLang;
	}
	
	public static Map<String,String> getSrcTargetLang(){
		Map<String,String> supportLang = new HashMap<String,String> ();
	
		UserDetails userDetails =null;
		User user =null;
		if( SecurityContextHolder.getContext().getAuthentication()!=null){
			userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    user = (User) userDetails;
		}

        Locale locale = new Locale("en", "US");
        if (user!=null && "zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }
        
	    Locale[] list = Locale.getAvailableLocales();
	    for (int i = 0; i < list.length; i++) {
                String str = list[i].getDisplayCountry();
                if (StringUtils.isNotEmpty(str)) {
                    str = list[i].getDisplayName(locale);	                               
                    if(!"ja_JP_JP ".equalsIgnoreCase(list[i].toString())&& !"th_TH_TH".equalsIgnoreCase(list[i].toString())){
                      supportLang.put(list[i].toString(),str);
                    }
                }
	    }
	    
	    return supportLang;
	}
	
	public static String getLang(String lang){
		Map<String, String> langmap = getSrcTargetLang();
		String language = langmap.get(lang);
		return language;
	}
	
	public static Locale getLocale(String language){
		Locale locale=new Locale("en","US");
        if("zh_CN".equalsIgnoreCase(language)){
        	locale=new Locale("zh","CN");
        }    
        
        return locale;
	}
	
	public static String getMessage(String key,ApplicationContext ctx){
        
        UserDetails userDetails =null;
		User user =null;
		if( SecurityContextHolder.getContext().getAuthentication()!=null){
			userDetails= (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    user = (User) userDetails;
		}

        Locale locale = new Locale("en", "US");
        if (user!=null && "zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }

		return ctx.getMessage(key, null, locale);
	}
	
	public static List getStatus(ApplicationContext ctx){
		List statuslist = new ArrayList ();
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) userDetails;

        Locale locale = new Locale("en", "US");
        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }
 
        String quote = ctx.getMessage("label.quote", null, locale);
	    String translation =  ctx.getMessage("label.translation", null, locale);
	    String copyedit = ctx.getMessage("label.copyedit", null, locale);
	    String submit = ctx.getMessage("label.submit", null, locale);
	    String finish = ctx.getMessage("label.finish", null, locale);
	    String select = ctx.getMessage("label.pleaseselect", null, locale);
	    String pending = ctx.getMessage("label.pending", null, locale);
	    String approve = ctx.getMessage("label.approve", null, locale);
	    
	    statuslist.add(new SelectLabelBean("--"+select+"--",""));
	    statuslist.add(new SelectLabelBean (pending, ORDER_STATUS_PENDING));
	    statuslist.add(new SelectLabelBean (approve, ORDER_STATUS_APPOVE));
	    statuslist.add(new SelectLabelBean (quote, ORDER_STATUS_QUOTE));
	    statuslist.add(new SelectLabelBean (translation, ORDER_STATUS_TRANSLATION));
	    statuslist.add(new SelectLabelBean (copyedit, ORDER_STATUS_COPYEDIT));
	    statuslist.add(new SelectLabelBean (submit, ORDER_STATUS_SUBMIT));
	    statuslist.add(new SelectLabelBean (finish, ORDER_STATUS_FINISH));

	    
	    return statuslist;
	}
	
	public static HashMap<String,String> getStatusMap(ApplicationContext ctx){
		HashMap<String,String> statuslist = new HashMap<String,String> ();
	
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) userDetails;

        Locale locale = new Locale("en", "US");
        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }
 
        String quote = ctx.getMessage("label.quote", null, locale);
	    String translation =  ctx.getMessage("label.translation", null, locale);
	    String copyedit = ctx.getMessage("label.copyedit", null, locale);
	    String submit = ctx.getMessage("label.submit", null, locale);
	    String finish = ctx.getMessage("label.finish", null, locale);

	    String pending = ctx.getMessage("label.pending", null, locale);
	    String approve = ctx.getMessage("label.approve", null, locale);
	    
	    statuslist.put(ORDER_STATUS_PENDING,pending);
	    statuslist.put(ORDER_STATUS_APPOVE,approve);
	    statuslist.put(ORDER_STATUS_QUOTE,quote);
	    statuslist.put (ORDER_STATUS_TRANSLATION,translation);
	    statuslist.put(ORDER_STATUS_COPYEDIT,copyedit);
	    statuslist.put(ORDER_STATUS_SUBMIT,submit);
	    statuslist.put(ORDER_STATUS_FINISH,finish);

	    
	    return statuslist;
	}
	
	public static List getUserTypes(ApplicationContext ctx) {
		List statuslist = new ArrayList ();
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = (User) userDetails;

        Locale locale = new Locale("en", "US");
        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
            locale = new Locale("zh", "CN");
        }
 
        String free = ctx.getMessage("label.freelancer", null, locale);
	    String admin =  ctx.getMessage("label.admin", null, locale);
	    String sales = ctx.getMessage("label.sales", null, locale);
	    String finance = ctx.getMessage("label.finance", null, locale);
	    String projectManager = ctx.getMessage("label.projectManager", null, locale);
	    String client = ctx.getMessage("label.client", null, locale);
	    String select = ctx.getMessage("label.pleaseselect", null, locale);
	    
	    statuslist.add(new SelectLabelBean("--"+select+"--","0"));
	    statuslist.add(new SelectLabelBean (free, LangUtil.FREELANCER));
	    statuslist.add(new SelectLabelBean (admin, LangUtil.ADMIN));
	    statuslist.add(new SelectLabelBean (sales, LangUtil.SALES));
	    statuslist.add(new SelectLabelBean (finance, LangUtil.FINANCE));
	    statuslist.add(new SelectLabelBean (projectManager, LangUtil.PROJECTMANAGER));
	    statuslist.add(new SelectLabelBean (client, LangUtil.CLIENT));

	    
	    return statuslist;
		
	}
	
//	public static List getPending(ApplicationContext ctx) {
//		List pendinglist = new ArrayList ();
//		
//		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        User user = (User) userDetails;
//
//        Locale locale = new Locale("en", "US");
//        if ("zh_CN".equalsIgnoreCase(user.getLanguage())) {
//            locale = new Locale("zh", "CN");
//        }
// 
//        String pending = ctx.getMessage("label.pending", null, locale);
//	    String approve =  ctx.getMessage("label.approve", null, locale);
//	    String select = ctx.getMessage("label.pleaseselect", null, locale);
//	    
//	    pendinglist.add(new SelectLabelBean("--"+select+"--","0"));
//	    pendinglist.add(new SelectLabelBean (pending, "P"));
//	    pendinglist.add(new SelectLabelBean (approve, "A"));
//	    
//	    return pendinglist;
//		
//	}
}
