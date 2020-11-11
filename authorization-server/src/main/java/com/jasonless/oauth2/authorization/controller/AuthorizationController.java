package com.jasonless.oauth2.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author LiuShiZeng
 */
@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String loginPage(Model model){
        return "login";
    }

    @GetMapping("/home.html")
    public String home(){
        return "home";
    }

    @GetMapping("/")
    public String basePage(){
        return "home";
    }

    @GetMapping("/error.html")
    public String error(){
        return "error";
    }


}
