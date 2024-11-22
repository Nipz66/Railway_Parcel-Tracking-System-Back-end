package edu.icet.controller;

import edu.icet.dto.LoginRequest;
import edu.icet.dto.Staff;
import edu.icet.security.JwtUtil;
import edu.icet.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private StaffService staffService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Authenticate the user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
        );

        User user = (User) authentication.getPrincipal();

        return jwtUtil.generateToken(user.getUsername());
    }

    @PostMapping("/register")
    public Staff register(@RequestBody Staff staff) {
        return staffService.registerStaff(staff);
    }

    @GetMapping("/get-all")
    public List<Staff> getAllStaff() {
        return staffService.getAll();
    }

    @PostMapping("/add-staff")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStaff(@RequestBody Staff staff) {
        staffService.addStaff(staff);
    }

    @GetMapping("/search-by-id/{id}")
    public Staff getStaffById(@PathVariable Integer id) {
        return staffService.searchStaffById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStaffById(@PathVariable Integer id) {
        staffService.deleteStaffById(id);
    }

    @PutMapping("/update-staff")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateStaffById(@RequestBody Staff staff) {
        staffService.updateStaffById(staff);
    }
}
