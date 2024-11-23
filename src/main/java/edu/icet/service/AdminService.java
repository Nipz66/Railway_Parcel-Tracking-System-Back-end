package edu.icet.service;

import org.springframework.stereotype.Service;

@Service
public class AdminService {

    // Predefined Admin Credentials
    private final String adminEmail = "admin@example.com";
    private final String adminPassword = "admin123"; // Plaintext password for simplicity

    // Validate Admin Credentials
    public boolean validateAdmin(String email, String password) {
        return email.equals(adminEmail) && password.equals(adminPassword);
    }
}
