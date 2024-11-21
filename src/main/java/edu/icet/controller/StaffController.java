package edu.icet.controller;

import edu.icet.dto.Staff;
import edu.icet.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffController {

    @Autowired
    final StaffService service;

    @GetMapping("/get-staff")
    public Staff getStaff(){
        return new Staff(1,"Nipun","Anupama","Alawwa","0787548652",2000-06-02,"anupamaalahakoon66@gmail.com","Alawwa","Railway Clerical");
    }

    @PostMapping("/add-staff")
    public void addStaff(@RequestBody Staff staff){
    service.addStaff(staff);
    }
}
