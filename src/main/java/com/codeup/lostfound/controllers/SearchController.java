//package com.codeup.lostfound.controllers;
//
//import com.codeup.lostfound.repositories.CategoryRepository;
//import com.codeup.lostfound.repositories.ItemRepository;
//import com.sun.tools.javac.jvm.Items;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//@Controller
//public class SearchController {
//    private  ItemRepository itemRepository;
//    private CategoryRepository categoryRepository;
//
//public SearchController (ItemRepository itemRepository){
//    this.itemRepository = itemRepository;
//
//}
//
//    @GetMapping("search")
//    public String locSearch(@RequestParam("search") String search, Model model) {
//        if(!search.equals("")) {
//            search = "%" + search + "%";
//            List<Items> localResults = itemRepository.findByAddress_1Like(search);
//            model.addAttribute("address_1", localResults);
//
//        return "search/locSearch";
//    }
//
//    @PostMapping("search")
//    public String catSearch(@RequestParam("searchCat") String searchCat, Model model){
//
//        return "search/catSearch";
//    }
//}
//
//    }
//}
//
