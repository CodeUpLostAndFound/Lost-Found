package com.codeup.lostfound.controllers;

import com.codeup.lostfound.models.Category;
import com.codeup.lostfound.models.Item;
import com.codeup.lostfound.repositories.CategoryRepository;
import com.codeup.lostfound.repositories.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    private ItemRepository itemRepository;
    private CategoryRepository categoryRepository;

    public SearchController(ItemRepository itemRepository, CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;

    }

    @GetMapping("/search-form")
    public String showSearchForm() {

        return "search/locSearch";

    }


    @GetMapping("/search")
    public String search(@RequestParam("zipcode") String zipcode, @RequestParam("address") String address, Model model) {
        address =  "%" + address + "%";
        zipcode = "%" + zipcode + "%";


        List<Item> Results = itemRepository.findByZipcodeLikeAndAddressTwoLike(zipcode, address);
        model.addAttribute("items", Results);

        return "items/index";


    }



    @GetMapping("/searchcategory")
    public String search(
            @RequestParam("cat") String[] stringCategories, Model model) {
        List<Category> categoryObjects = new ArrayList<>();

        System.out.println("Got categories:");
        for (String stringCategory : stringCategories) {
            System.out.println("  - " + stringCategory);
        }

        System.out.println("Finding Category objects...");
        for (String category : stringCategories) {
            Category c = categoryRepository.findByName(category);
            System.out.printf("For string: %s, found Category object: %s", category, c);
            categoryObjects.add(c);
        }

        // now we have a list of objects with type Category

        List<Item> searchResults = itemRepository.findByCategoriesIn(categoryObjects);
        model.addAttribute("items", searchResults);
        return "items/index";
    }


}







