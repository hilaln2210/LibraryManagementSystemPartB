package com.library.controllers;

import com.library.models.Book;
import com.library.models.User;
import com.library.services.LibraryService;

public class LibraryController {
    private LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    public void registerUser(User user) {
        libraryService.registerUser(user);
    }

    public User getUserById(int id) {
        return libraryService.getUserById(id);
    }

    public void deleteUser(int id) {
        libraryService.deleteUser(id);
    }

    public void addBook(Book book) {
        libraryService.addBook(book);
    }

    public Book getBookById(int id) {
        return libraryService.getBookById(id);
    }

    public void deleteBook(int id) {
        libraryService.deleteBook(id);
    }
}
