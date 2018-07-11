package com.codeup.lostfound.controllers;

import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.repositories.CategoryRepository;
import com.codeup.lostfound.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class SearchController {
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    public SearchController(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/search")
    public String search(@RequestParam("zipcode") String zipcode, @RequestParam("address") String address, Model model) {
        address =  "%" + address + "%";
        zipcode = "%" + zipcode + "%";


        List<Item> Results = itemRepository.findByZipcodeLikeAndAddressTwoLike(zipcode, address);
        model.addAttribute("items", Results);

        return "items/index";


    }




}
