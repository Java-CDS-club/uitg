package com.uitg.oa.services;

import java.util.List;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.uitg.oa.bean.Page;
import com.uitg.oa.entity.User;

/**
 * Description Here
 *
 * @author Michael
 */
public interface UserService extends BaseService, UserDetailsService {
	
	UserDetails loadUserByUsername(String username, String password) throws UsernameNotFoundException;

	public Page<User> findUser(int pageIndex, int pageSize,String userType);

	public List<User> findUser(User user);

    public List<User> findUser(User user,Map<String, Object> args) ;
}
