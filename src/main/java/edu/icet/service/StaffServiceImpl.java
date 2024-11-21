package edu.icet.service;

import edu.icet.dto.Staff;
import edu.icet.entity.StaffEntity;
import edu.icet.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService{

    private final StaffRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Staff> getAll() {
        return null;
    }

    @Override
    public void addStaff(Staff staff) {
    repository.save(mapper.map(staff, StaffEntity.class));
    }

    @Override
    public void deleteStaffById(Integer id) {

    }

    @Override
    public Staff searchStaffById(Integer id) {
        return null;
    }

    @Override
    public void updateStaffById(Staff staff) {

    }
}
