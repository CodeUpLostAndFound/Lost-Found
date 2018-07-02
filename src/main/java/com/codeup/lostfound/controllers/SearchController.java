package com.codeup.lostfound.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SearchController {

    @GetMapping("search")
    public String locSearch(Model model) {

        return "search/locSearch";
    }

    @PostMapping("search")
    public String catSearch() {

        return "search/catSearch";
    }
}
