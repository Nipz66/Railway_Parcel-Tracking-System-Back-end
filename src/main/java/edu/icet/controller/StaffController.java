package edu.icet.controller;

import edu.icet.dto.Staff;
import edu.icet.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {



    @Autowired
    final StaffService service;

    @GetMapping("/get-all")
    public List<Staff> getStaff(){
        return service.getAll();
    }

    @PostMapping("/add-staff")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStaff(@RequestBody Staff staff){
        service.addStaff(staff);
    }

    @GetMapping("/search-by-id/{id}")
    public Staff getStaffById(@PathVariable Integer id){
        return service.searchStaffById(id);
    }


    @DeleteMapping("/delete-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteStaffById(@PathVariable Integer id){
        service.deleteStaffById(id);
    }

    @PutMapping("/update-staff")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateStaffById(@RequestBody Staff staff){
        service.updateStaffById(staff);
    }


}
