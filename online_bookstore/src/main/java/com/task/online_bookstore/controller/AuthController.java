package com.task.online_bookstore.controller;

import com.task.online_bookstore.entity.User;
import com.task.online_bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public String registerPage(Model model){

        model.addAttribute("user",
                new User());

        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user){

        service.registerUser(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(){

        return "login";
    }
}