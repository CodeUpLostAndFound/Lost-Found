package com.codeup.lostfound.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/")
    public String landing(Model model) {

        return "users/login";
    }

    @GetMapping("users/register")
    public String register(Model model) {

        return "users/register";
    }

    @PostMapping("users/register")
    public String registered(Model model) {

        return "redirect:/";
    }

    @GetMapping("users/{id}")
    public String profile(@PathVariable int id, Model model) {

        return "users/profile";
    }
}
