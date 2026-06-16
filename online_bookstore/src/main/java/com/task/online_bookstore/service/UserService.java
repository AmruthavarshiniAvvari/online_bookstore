package com.task.online_bookstore.service;

import com.task.online_bookstore.entity.User;
import com.task.online_bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public void registerUser(User user){

        user.setPassword(
                encoder.encode(user.getPassword()));

        user.setRole("USER");

        repository.save(user);
    }
}