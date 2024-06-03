package com.library.services;

import com.library.models.Book;
import com.library.models.User;

public class LibraryService {
    private UserService userService;
    private BookService bookService;

    public LibraryService(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    public void registerUser(User user) {
        userService.registerUser(user);
        System.out.println("User registered: " + user);
    }

    public User getUserById(int id) {
        return userService.getUserById(id);
    }

    public void deleteUser(int id) {
        userService.deleteUser(id);
        System.out.println("User with ID " + id + " deleted");
    }

    public void addBook(Book book) {
        bookService.addBook(book);
        System.out.println("Book added: " + book);
    }

    public Book getBookById(int id) {
        return bookService.getBookById(id);
    }

    public void deleteBook(int id) {
        bookService.deleteBook(id);
        System.out.println("Book with ID " + id + " deleted");
    }
}
