package com.task.online_bookstore.repository;

import com.task.online_bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String keyword);
    @Query("SELECT SUM(b.stock) FROM Book b")
    Integer getTotalStock();
}