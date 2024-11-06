package edu.icet.service;

import edu.icet.dto.Parcel;
import edu.icet.entity.ParcelEntity;
import edu.icet.repository.ParcelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Parcel> getAll() {
        return null;
    }

    @Override
    public void addParcel(Parcel parcel) {
        //ParcelEntity map = mapper.map(parcel, ParcelEntity.class);
        repository.save(mapper.map(parcel, ParcelEntity.class));
    }

    @Override
    public void deleteParcelById(Integer id) {

    }

    @Override
    public Parcel searchParcelById(Integer id) {
        return null;
    }

    @Override
    public void updateParcelById(Parcel parcel) {

    }
}
