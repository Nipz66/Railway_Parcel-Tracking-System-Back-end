package edu.icet.controller;

import edu.icet.service.AdminService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public String login(@RequestBody AdminLoginRequest loginRequest) {
        // Validate admin credentials
        if (adminService.validateAdmin(loginRequest.getEmail(), loginRequest.getPassword())) {
            return "Login successful!"; // Return a success message
        }
        throw new RuntimeException("Invalid email or password."); // Throw error for invalid credentials
    }
}

// DTO for Admin Login Request
class AdminLoginRequest {
    private String email;
    private String password;

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
