package com.task.online_bookstore.controller;

import com.task.online_bookstore.entity.Book;
import com.task.online_bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/books")
    public String getAllBooks(@RequestParam(defaultValue = "0") int page,
                              Model model) {

        var bookPage = service.getBooksPaginated(page);

        model.addAttribute("books", bookPage.getContent());

        model.addAttribute("currentPage", page);

        model.addAttribute("totalPages",
                bookPage.getTotalPages());

        return "books";
    }

    @GetMapping("/addBook")
    public String addBookPage(Model model) {
        model.addAttribute("book", new Book());
        return "addBook";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        service.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        model.addAttribute("book", service.getBookById(id));
        return "editBook";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return "redirect:/books";
    }
    @GetMapping("/search")
    public String searchBooks(@RequestParam("keyword") String keyword,
                              Model model) {

        model.addAttribute("books",
                service.searchBooks(keyword));

        model.addAttribute("currentPage", 0);

        model.addAttribute("totalPages", 1);

        return "books";
    }
}