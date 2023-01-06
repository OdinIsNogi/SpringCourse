package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Author;
import com.example.MyBookShopApp.data.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorController {

    public AuthorController(AuthorService authorsService) {
        this.authorsService = authorsService;
    }

    private final AuthorService authorsService;

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        Map<String, List<Author>> authors = authorsService.getAuthorsMap();
        return authors;
    }

    @GetMapping("/authors")
    public String authorsPage(){
        return "/authors/index";
    }


}
