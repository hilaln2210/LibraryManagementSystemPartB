package com.library;

import com.library.dao.impl.UserFileDao;
import com.library.dao.impl.BookFileDao;
import com.library.models.User;
import com.library.models.Book;
import com.library.services.*;

public class Main {
    public static void main(String[] args) {
        UserFileDao userFileDao = new UserFileDao("users.txt");
        BookFileDao bookFileDao = new BookFileDao("books.txt");

        UserService userService = new UserService(userFileDao);
        BookService bookService = new BookService(bookFileDao);
        NotificationService notificationService = new NotificationServiceImpl();

        LibraryService libraryService = new LibraryService(userService, bookService);

        // Register a user
        User user = new User(1, "John Doe", "john@example.com");
        libraryService.registerUser(user);

        // Get and display user by ID
        User retrievedUser = libraryService.getUserById(1);
        System.out.println("Retrieved user: " + retrievedUser);

        // Add a book
        Book book = new Book(1, "978-3-16-148410-0", "A Great Book", "Jane Doe");
        libraryService.addBook(book);

        // Get and display book by ID
        Book retrievedBook = libraryService.getBookById(1);
        System.out.println("Retrieved book: " + retrievedBook);

        // Delete user and book
        libraryService.deleteUser(1);
        libraryService.deleteBook(1);
    }
}
