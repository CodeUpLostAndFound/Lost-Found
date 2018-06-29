package com.codeup.lostfound.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ItemController {

    @GetMapping("/")
    public String allItems(Model model) {

        return "items/index";
    }

}
