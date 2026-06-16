package com.task.online_bookstore.service;

import com.task.online_bookstore.entity.Book;
import com.task.online_bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public void saveBook(Book book) {
        repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }

    public List<Book> searchBooks(String keyword) {
        return repository.findByTitleContainingIgnoreCase(keyword);
    }
    public Page<Book> getBooksPaginated(int pageNo) {

        Pageable pageable = PageRequest.of(pageNo, 5);

        return repository.findAll(pageable);
    }
    public long totalBooks() {
        return repository.count();
    }

    public int totalStock() {
        return repository.getTotalStock();
    }
}