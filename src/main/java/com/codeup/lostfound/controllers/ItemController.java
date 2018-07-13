package com.codeup.lostfound.controllers;

import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.models.User;
import com.codeup.lostfound.repositories.CommentRepository;
import com.codeup.lostfound.repositories.CategoryRepository;
import com.codeup.lostfound.repositories.ItemRepository;
import com.codeup.lostfound.repositories.UserRepository;
import com.codeup.lostfound.services.ItemService;
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
    public UserRepository users;
    public ItemRepository itemRepository;
    public UserRepository userRepository;
    public CategoryRepository categoryRepository;
    public CommentRepository commentRepository;
    private ItemService itemService;

    @Autowired
    public ItemController(ItemRepository itemRepository, UserRepository userRepository, CategoryRepository categoryRepository, CommentRepository commentRepository, ItemService itemService) {
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
        this.commentRepository = commentRepository;
        this.itemService = itemService;
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
        return "items/showItem";
    }

    @GetMapping("/items/create")
    public String create(Model model){

        model.addAttribute("item", new Item());
        return "items/create";
    }

    @PostMapping("/items/create")
    public String created(@ModelAttribute Item item, User user) {
        itemService.save(item);
        return "redirect:/items/" + item.getId();
    }

    @GetMapping("/items/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("item", itemRepository.findOne(id));
        return "items/edit";
    }

    @PostMapping("/items/{id}/edit")
    public String updateItem(@PathVariable int id, @ModelAttribute Item item) {
        itemService.save(item);
        return "redirect:/items/" + id;
    }

    @PostMapping("/items/{id}/delete")
    public String delete(@PathVariable int id, @ModelAttribute User user) {
        itemService.delete(id);
        return "redirect:/items";
    }

    @PostMapping("items/{id}")
    public String search(
            @RequestParam("comment") String[] stringComment, Model model) {
        List<Comment> commentObjects = new ArrayList<>();


        return "items/index";
    }