package edu.icet.service;

import edu.icet.dto.Staff;
import edu.icet.entity.StaffEntity;
import edu.icet.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {

    private final StaffRepository repository;
    private final ModelMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Staff registerStaff(Staff staff) {
        staff.setPassword(passwordEncoder.encode(staff.getPassword()));  // Encrypt the password
        return mapper.map(repository.save(mapper.map(staff, StaffEntity.class)), Staff.class);
    }

    @Override
    public List<Staff> getAll() {
        List<Staff> staffArrayList = new ArrayList<>();
        repository.findAll().forEach(entity -> {
            staffArrayList.add(mapper.map(entity, Staff.class));
        });
        return staffArrayList;
    }

    @Override
    public void addStaff(Staff staff) {
        repository.save(mapper.map(staff, StaffEntity.class));
    }

    @Override
    public void deleteStaffById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Staff searchStaffById(Integer id) {
        return mapper.map(repository.findById(id).orElseThrow(() -> new RuntimeException("Staff not found")), Staff.class);
    }

    @Override
    public void updateStaffById(Staff staff) {
        repository.save(mapper.map(staff, StaffEntity.class));
    }
}
