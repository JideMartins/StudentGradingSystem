package org.student.GradingSystem;


import java.util.HashMap;
import java.util.Map;

/**
 * The AuthManager class handles authentication for instructors.
 * It validates the credentials entered by instructors against a predefined set of credentials.
 */
public class AuthManager {
    private static final Map<String, String> credentials = new HashMap<>();

    // Static block to initialize the credentials map
    static {
        credentials.put("instructor1", "password123");
        credentials.put("instructor2", "securePass456");
    }

    /**
     * Authenticates an instructor's credentials.
     * Checks if the username exists in the credentials map and if the corresponding password matches.
     *
     * @param username The username entered by the instructor.
     * @param password The password entered by the instructor.
     * @return true if the credentials are valid, false otherwise.
     */
    public static boolean authenticate(String username, String password) {
        return credentials.containsKey(username) && credentials.get(username).equals(password);
    }
}

