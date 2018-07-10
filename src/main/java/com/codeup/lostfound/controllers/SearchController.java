package com.codeup.lostfound.controllers;

import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.repositories.CategoryRepository;
import com.codeup.lostfound.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    public SearchController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;

    }

    @GetMapping("search")
    public String zipSearch(@RequestParam("search") String zipcode, Model model) {
//            search = "%" + search + "%";
        zipcode = "%" + zipcode + "%";
        List<Item> zipResults = itemRepository.findByZipcodeLike(zipcode);
        model.addAttribute("items", zipResults);

        return "items/index";
    }

    @PostMapping("search")
    public String catSearch(@RequestParam("searchCat") String searchCat, Model model) {

        return "search/catSearch";
    }
}