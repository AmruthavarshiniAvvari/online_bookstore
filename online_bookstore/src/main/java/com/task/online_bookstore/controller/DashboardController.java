package com.task.online_bookstore.controller;

import com.task.online_bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private BookService service;

    @GetMapping("/dashboard")
    public String dashboard(Model model){

        model.addAttribute("totalBooks",
                service.totalBooks());

        model.addAttribute("totalStock",
                service.totalStock());

        return "dashboard";
    }
}