package edu.icet.repository;

import edu.icet.dto.Staff;
import edu.icet.entity.StaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<StaffEntity,Integer> {
}
