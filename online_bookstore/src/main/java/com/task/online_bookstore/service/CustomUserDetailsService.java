package com.task.online_bookstore.service;

import com.task.online_bookstore.entity.User;
import com.task.online_bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomUserDetailsService
        implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException {

        User user = repository.findByEmail(email);

        if(user == null){

            throw new UsernameNotFoundException(
                    "User not found");
        }

        return new org.springframework.security.core.userdetails.User(

                user.getEmail(),
                user.getPassword(),

                List.of(
                        new SimpleGrantedAuthority(
                                user.getRole()
                        )
                )
        );
    }
}