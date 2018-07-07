package com.codeup.lostfound.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codeup.lostfound.repositories.ItemRepository;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ItemController {
    private ItemRepository itemDao;

    public ItemController(ItemRepository itemDao) {
        this.itemDao = itemDao;
    }

    @GetMapping("items")
    public String allItems(Model model) {
        System.out.println("Model: " + model);
        model.addAttribute("items",itemDao.findAll());
        return "items/index";
    }

    @GetMapping("items/{id}")
    public String oneItem(@PathVariable int id, Model model) {
        model.addAttribute("item",itemDao.findOne(id));
        return "items/showItem";
    }



}