package com.codeup.lostfound.controllers;

import com.codeup.lostfound.models.User;
import com.codeup.lostfound.repositories.UserRepository;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository users;
//    private PasswordEncoder passwordEncoder;


    public UserController(UserRepository users/*PasswordEncoder passwordEncoder*/){
        this.users = users;
//        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String landing(Model model) {

        return "redirect:users/login";
    }

    @GetMapping("users/login")
    public String login(Model model) {

        return "users/login";
    }

    @PostMapping("users/login")
    public String loggingIn(@ModelAttribute User user) {
//        String hash = passwordEncoder.encode(user.getPassword());
//        user.setPassword(hash);
        users.save(user);
        return "redirect:items";
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
