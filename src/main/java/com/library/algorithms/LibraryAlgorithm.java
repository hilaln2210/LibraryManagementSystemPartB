package com.library.algorithms;

import com.library.models.User;

public class LibraryAlgorithm {
    public boolean isValidUser(User user) {
        return user.getId() > 0 && !user.getName().isEmpty() && !user.getEmail().isEmpty();
    }
}
