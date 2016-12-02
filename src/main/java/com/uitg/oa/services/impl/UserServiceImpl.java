package com.uitg.oa.services.impl;

import com.uitg.oa.bean.Page;
import com.uitg.oa.dao.UserDAO;
import com.uitg.oa.entity.User;
import com.uitg.oa.services.UserService;
import com.uitg.oa.util.LangUtil;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

/**
 * Description Here
 *
 * @author Michael
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl implements UserService {
	 @Autowired  
	 private HttpSession session;  
	 
	 @Autowired  
	 private UserDAO userDAO;  
	 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SecurityContextHolder.getContext().getAuthentication();

        User user = new User();
        user.setUsername(username);
        user = findByExample(user);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
 
        if(LangUtil.FREELANCER.equals(user.getUserType())){
        	authorities.add(new SimpleGrantedAuthority("ROLE_FREELANCER"));
     	}else if(LangUtil.CLIENT.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
     	}else if(LangUtil.ADMIN.equals(user.getUserType())){
     	    authorities.add(new SimpleGrantedAuthority("ROLE_SYSUSER"));
 	        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
     	}else if(LangUtil.SALES.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_SALES"));
     	}else if(LangUtil.FINANCE.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_FINANCE"));
     	}else if(LangUtil.PROJECTMANAGER.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_PROJECTMANAGER"));
     	}

        user.setAuthorities(authorities);
        
        Locale locale= LangUtil.getLocale(user.getLanguage());
        		    
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME , locale);

        return user;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username,String password) throws UsernameNotFoundException {

        SecurityContextHolder.getContext().getAuthentication();

        User user = new User();
        user.setUsername(username);
        user = findByExample(user);

        if(user == null) {
            throw new UsernameNotFoundException(username);
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
 
        if(LangUtil.FREELANCER.equals(user.getUserType())){
        	authorities.add(new SimpleGrantedAuthority("ROLE_FREELANCER"));
     	}else if(LangUtil.CLIENT.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
     	}else if(LangUtil.ADMIN.equals(user.getUserType())){
     	    authorities.add(new SimpleGrantedAuthority("ROLE_SYSUSER"));
 	        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
     	}else if(LangUtil.SALES.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_SALES"));
     	}else if(LangUtil.FINANCE.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_FINANCE"));
     	}else if(LangUtil.PROJECTMANAGER.equals(user.getUserType())){
     		authorities.add(new SimpleGrantedAuthority("ROLE_PROJECTMANAGER"));
     	}

        user.setAuthorities(authorities);
        
        Locale locale= LangUtil.getLocale(user.getLanguage());
        		    
        session.setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME , locale);

        return user;
    }
    
    public Page<User> findUser(int pageIndex, int pageSize,String userType){
    	
		return userDAO.findUser(pageIndex, pageSize, userType);
    	
    }
    
    @Override
    public List<User> findUser(User user, Map<String, Object> args) {

        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        if (StringUtils.isNotBlank(user.getUsername())) {
            criteria.add(Restrictions.like("username", user.getUsername(), MatchMode.START));
        }
        
        if (StringUtils.isNotBlank(user.getCompanyName())) {
            criteria.add(Restrictions.like("companyName", user.getCompanyName(), MatchMode.START));
        }

        
        if(StringUtils.isNotBlank(user.getSourceLanguage())) {
            criteria.add(Restrictions.like("sourceLanguage", user.getSourceLanguage(), MatchMode.START));
        }
        
        if(StringUtils.isNotBlank(user.getTargetLanguage())) {
            criteria.add(Restrictions.like("targetLanguage", user.getTargetLanguage(), MatchMode.START));
        }
        
        
        criteria.add(Restrictions.eq("userType", user.getUserType()));

//        if (StringUtils.isNotBlank(username)) {
//            DetachedCriteria c = criteria.createCriteria("user", JoinType.INNER_JOIN);
//            c.add(Restrictions.ilike("username", username, MatchMode.START));
//        }
        if(args !=null && args.size()>0){
	        for (Map.Entry<String, Object> entry : args.entrySet()) {
	            if(entry.getValue() instanceof Collection) {
	            	criteria.add(Restrictions.not(Restrictions.in(entry.getKey(), (Collection)entry.getValue())));                
	            } else {
	            	criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
	            }
	        }  
        }

        return userDAO.findByCriteria(criteria);
    }
    
    @Override
    public List<User> findUser(User user) {
      return findUser(user, null);
    }
}
