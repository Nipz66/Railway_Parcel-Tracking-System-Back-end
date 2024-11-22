package edu.icet.controller;

import edu.icet.dto.LoginRequest;
import edu.icet.dto.Staff;
import edu.icet.security.JwtUtil;
import edu.icet.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
@CrossOrigin
public class StaffController {

    private final StaffService staffService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            return jwtUtil.generateToken(user.getUsername());
        } catch (Exception e) {
            throw new RuntimeException("Invalid credentials. Please try again.");
        }
    }

    @PostMapping("/register")
    public Staff register(@RequestBody Staff staff) {
        return staffService.registerStaff(staff);
    }

    @GetMapping("/get-all")
    public List<Staff> getStaff() {
        return staffService.getAll();
    }
}
