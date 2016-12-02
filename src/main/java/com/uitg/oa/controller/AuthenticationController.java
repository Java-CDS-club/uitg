package com.uitg.oa.controller;

import com.uitg.oa.bean.Context;
import com.uitg.oa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Description Here
 *
 * @author Michael
 */
@Controller
public class AuthenticationController {

    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Context getContext() {
        return new Context();
    }

    @Autowired
    private Context context;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        if( SecurityContextHolder.getContext().getAuthentication() != null) {
            return "redirect:/";
        }

        return "login";
    }

////    @RequestMapping(value = "/security_check", method = {GET, POST})
//    public String handleLogin(String username, String password) {
//
//        try {
////            userService.login(username, password);
//
//            context.setTab("mgmt");
//
//            return "redirect:/";
//        } catch(AuthenticationException e) {
//            return "redirect:/login";
//        }
//    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
