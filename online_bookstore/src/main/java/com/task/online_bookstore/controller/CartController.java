package com.task.online_bookstore.controller;

import com.task.online_bookstore.entity.Book;
import com.task.online_bookstore.entity.Cart;
import com.task.online_bookstore.service.BookService;
import com.task.online_bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private BookService bookService;

    @GetMapping("/cart")
    public String viewCart(Model model){

        model.addAttribute("cartItems",
                cartService.getCartItems());

        return "cart";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable Long id){

        Book book = bookService.getBookById(id);

        Cart cart = new Cart();

        cart.setBookTitle(book.getTitle());
        cart.setPrice(book.getPrice());
        cart.setQuantity(1);

        cartService.addToCart(cart);

        return "redirect:/cart";
    }

    @GetMapping("/removeCart/{id}")
    public String removeCart(@PathVariable Long id){

        cartService.removeItem(id);

        return "redirect:/cart";
    }
}