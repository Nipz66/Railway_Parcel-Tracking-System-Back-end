package edu.icet.service;

import edu.icet.dto.Staff;

import java.util.List;

public interface StaffService {

    List<Staff>getAll();
    void addStaff(Staff staff);
    void deleteStaffById(Integer id);
    Staff searchStaffById(Integer id);
    void updateStaffById(Staff staff);
}
