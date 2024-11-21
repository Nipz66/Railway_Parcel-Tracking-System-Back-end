package edu.icet.service;

import edu.icet.dto.Staff;
import edu.icet.entity.StaffEntity;
import edu.icet.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService{

    private final StaffRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<Staff> getAll() {
        List<Staff> staffArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
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
       return mapper.map(repository.findById(id),Staff.class);
    }

    @Override
    public void updateStaffById(Staff staff) {
        repository.save(mapper.map(staff,StaffEntity.class));
    }
}
