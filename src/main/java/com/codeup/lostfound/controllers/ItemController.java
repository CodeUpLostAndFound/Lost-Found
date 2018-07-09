package com.codeup.lostfound.controllers;

import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.repositories.CategoryRepository;
import com.codeup.lostfound.repositories.ItemRepository;
import com.codeup.lostfound.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ItemController {

    public ItemRepository itemRepository;
    public UserRepository userRepository;
    public CategoryRepository categoryRepository;

    @Autowired
    public ItemController(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }


    @GetMapping("/items")
    public String allItems(Model model) {
        List<Item> items= itemRepository.findAll();
        model.addAttribute("items", items);
        return "items/index";
    }

    @GetMapping("items/{id}")
    public String oneItem(@PathVariable int id, Model model) {
        Item item = (Item) itemRepository.findOne(id);
        model.addAttribute("item", item);
        return "items/index";
    }

    @GetMapping("items/create")
    public String create(Model model){
        model.addAttribute("item", new Item());
        return "items/create";
    }

    @PostMapping("items/create")
    public String registered(@ModelAttribute Item item) {
        item.save(item);
        return "items";
    }
}