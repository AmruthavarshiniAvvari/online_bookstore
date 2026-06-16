package com.task.online_bookstore.repository;

import com.task.online_bookstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository
        extends JpaRepository<User,Long> {

    User findByEmail(String email);
}