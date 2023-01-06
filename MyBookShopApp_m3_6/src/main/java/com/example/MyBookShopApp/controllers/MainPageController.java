package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
//@RequestMapping("/bookshop")
public class MainPageController {

    private final BookService bookService;
    private final GenreService genreService;


    @Autowired
    public MainPageController(BookService bookService, GenreService genreService) {
        this.bookService = bookService;
        this.genreService = genreService;
    }


    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return bookService.getBooksData();
    }

    @ModelAttribute("bookTags")
    public List<Genre> bookTags() {
        return genreService.getGenreData();
    }

    @GetMapping("/")
    public String mainPage() {
        return "index";
    }




//    @GetMapping("/main")
//    public String mainPage(Model model) {
//        model.addAttribute("bookData", bookService.getBooksData());
//        model.addAttribute("searchPlaceholder","new search placeholder");
//        model.addAttribute("serverTime", new Date());
//        model.addAttribute("placeholderTextPart2","SERVER");
//        model.addAttribute("messageTemplate","searchbar.placeholder2");
//        return "index";
//    }

//    @GetMapping("/genres")
//    public String genres(Model model) {
//        model.addAttribute("bookGenres", genreService.getGenreData());
//        return "genres";
//    }
//
//    @GetMapping("/authors")
//    public String authors(Model model) {
//        model.addAttribute("authorData", authorService.getAuthorData());
//        return "authors";
//    }
}
