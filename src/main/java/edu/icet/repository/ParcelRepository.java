package edu.icet.repository;

import edu.icet.entity.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends JpaRepository<ParcelEntity,Integer>{

}
