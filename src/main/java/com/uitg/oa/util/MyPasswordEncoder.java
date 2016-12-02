package com.uitg.oa.util;

import java.security.KeyPair;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.PasswordEncoder;

public class MyPasswordEncoder implements PasswordEncoder{
	@Autowired  
    private HttpSession session;
	
	public MyPasswordEncoder() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String encodePassword(String password, Object salt) {
		// TODO Auto-generated method stub
		password = new MD5Helper().getMD5ofStr(password);
		return password;
	}

	@Override
	public boolean isPasswordValid(String encodePassword, String password, Object salt) {
		KeyPair keypairs = (KeyPair)session.getAttribute("keys");
		JCryption jcryption = new JCryption();
		password = jcryption.decrypt(password, keypairs);
		if(encodePassword.equals(encodePassword(password,salt))){
			return true;
		}
		return false;
	}

}
