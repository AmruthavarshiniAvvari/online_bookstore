package com.task.online_bookstore.service;

import com.task.online_bookstore.entity.Cart;
import com.task.online_bookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository repository;

    public void addToCart(Cart cart){
        repository.save(cart);
    }

    public List<Cart> getCartItems(){
        return repository.findAll();
    }

    public void removeItem(Long id){
        repository.deleteById(id);
    }
}