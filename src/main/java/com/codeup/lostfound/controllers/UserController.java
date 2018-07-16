package com.codeup.lostfound.controllers;


import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.models.User;
import com.codeup.lostfound.repositories.ItemRepository;
import com.codeup.lostfound.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private UserRepository users;
    private PasswordEncoder passwordEncoder;
    private ItemRepository itemRepository;

    public UserController(UserRepository users,ItemRepository itemRepository , PasswordEncoder passwordEncoder) {
        this.users = users;
        this.itemRepository = itemRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String landing(Model model) {
        return "redirect:/login";
    }

    @GetMapping("/users/register")
    public String register(Model model) {

        model.addAttribute("user", new User());
        return "users/register";
    }

    @PostMapping("/users/register")
    public String registered(@ModelAttribute User user) {
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        users.save(user);
        return "redirect:/login";
    }

    @GetMapping("/users/{id}")
    public String profile(@PathVariable int id, Model model) {
        List<Item> items= itemRepository.findByUserId(id);
        User user = users.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("items", items);
        return "users/profile";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }


}
