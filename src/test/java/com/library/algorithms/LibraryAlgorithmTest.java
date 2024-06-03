package com.library.algorithms;

import com.library.models.User;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryAlgorithmTest {
    @Test
    public void testIsValidUser() {
        LibraryAlgorithm algorithm = new LibraryAlgorithm();

        User validUser = new User(1, "John Doe", "john@example.com");
        assertTrue(algorithm.isValidUser(validUser));

        User invalidUser = new User(0, "", "");
        assertFalse(algorithm.isValidUser(invalidUser));
    }
}
