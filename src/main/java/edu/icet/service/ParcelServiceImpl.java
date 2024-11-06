package edu.icet.service;

import edu.icet.dto.Parcel;
import edu.icet.entity.ParcelEntity;
import edu.icet.repository.ParcelRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParcelServiceImpl implements ParcelService {

    private final ParcelRepository repository;
    private final ModelMapper mapper;
    @Override
    public List<Parcel> getAll() {
        List<Parcel> parcelArrayList = new ArrayList<>();
        repository.findAll().forEach(entity->{
            parcelArrayList.add(mapper.map(entity, Parcel.class));
        });
        return parcelArrayList;
    }

    @Override
    public void addParcel(Parcel parcel) {
        //ParcelEntity map = mapper.map(parcel, ParcelEntity.class);
        repository.save(mapper.map(parcel, ParcelEntity.class));
    }

    @Override
    public void deleteParcelById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Parcel searchParcelById(Integer id) {
        return mapper.map(repository.findById(id),Parcel.class);
    }

    @Override
    public void updateParcelById(Parcel parcel) {
        repository.save(mapper.map(parcel,ParcelEntity.class));
    }
}
