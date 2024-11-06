package edu.icet.service;

import edu.icet.dto.Parcel;
import jakarta.persistence.Id;

import java.util.List;

public interface ParcelService {

    List<Parcel> getAll();
    void addParcel(Parcel parcel);
    void deleteParcelById(Integer id);
    Parcel searchParcelById(Integer id);
    void updateParcelById(Parcel parcel);

}
