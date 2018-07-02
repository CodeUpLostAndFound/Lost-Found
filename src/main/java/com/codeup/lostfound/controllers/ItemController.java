package com.codeup.lostfound.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codeup.lostfound.repositories.ItemRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {
    private ItemRepository itemDao;

    @GetMapping("items")
    public String allItems(Model model) {

        return "items/index";
    }

    @GetMapping("items/{id}")
    public String oneItem(@PathVariable int id, Model model) {

        return "items/showItem";
    }



}