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

    public SearchController(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("search")
    public String search(@RequestParam("zipcode", "address", "cat") String zipcode, String address, List category Model model) {
        address =  "%" + address + "%";
        zipcode = "%" + zipcode + "%";
        category = "%" + category + "%";

        List<Item> Results = itemRepository.findByZipcodeLike(zipcode).findByaddressLike(address);
        List<Item>catResults = categoryRepository.findBycatLike(category);
        model.addAttribute("items", Results, catResults);

//        public String addressSearch(@RequestParam("address") String address, Model model) {
////            a = "%" + search + "%";
//            address = "%" + address + "%";
//            List<Item> addressResults = itemRepository.findByaddressLike(address);
//            model.addAttribute("items", addressResults);
//
//            public String catSearch(@RequestParam("cat") String cat, Model model) {
////            a = "%" + search + "%";
//                cat = "%" + cat + "%";
//                List<Item>catResults = categoryRepository.findBycatLike(cat);
//                model.addAttribute("items", catResults);
//
//                public String zipAndAddress(@RequestParam("zipAddress") String cat, Model model) {
//                    zipAddress =
//                }
//                List<Item> zipcodeAndAddress = itemRepository.findByZipcodeAndAddress(String zipcode, String address);
//                model.addAttribute('items', zipcodeAndAddress)

        return "items/index";


    }


}
