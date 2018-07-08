package com.codeup.lostfound.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("login")
    public String showLoginForm(){
        return "users/Login";
    }

    @GetMapping("/logout")
    public String logout(){
        return "users/Login";
    }
}
