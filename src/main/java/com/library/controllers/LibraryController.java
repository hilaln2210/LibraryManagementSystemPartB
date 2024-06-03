package com.library.controllers;

import com.library.models.User;
import com.library.services.UserService;

public class LibraryController {
    private UserService userService;

    public LibraryController(UserService userService) {
        this.userService = userService;
    }

    public void registerUser(User user) {
        userService.registerUser(user);
        System.out.println("User registered: " + user);
    }

    public void deleteUser(int id) {
        userService.deleteUser(id);
        System.out.println("User with ID " + id + " deleted");
    }
}
