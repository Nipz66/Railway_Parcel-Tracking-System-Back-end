package edu.icet.controller;

import edu.icet.dto.Parcel;
import edu.icet.service.ParcelService;
import jakarta.persistence.PrePersist;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/parcel")
@RequiredArgsConstructor
@CrossOrigin
public class ParcelController {
    @Autowired
    final ParcelService service;
    @GetMapping("/get-all")
    public List<Parcel> getParcel() {
        return service.getAll();
    }
        //return new Parcel(1,"Nipun","0787548652","nipun66@gmail.com","Alawwa","Sadeep","0774433123","sadeep@gmail.com","Panadura",20,"Cocount","Alawwa","Panadura",220);


    @PostMapping("/add-parcel")
    public void addParcel(@RequestBody Parcel parcel){
        service.addParcel(parcel);
    }

    @GetMapping("/search-by-id/{id}")
    public Parcel getParcelById(@PathVariable Integer id){
        return service.searchParcelById(id);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteParcelById(id);
    }

    @PutMapping("/update-parcel")
    public void updateParcel(@RequestBody Parcel parcel){
        service.updateParcelById(parcel);
    }

    @PrePersist
    protected void onCreate() {
        LocalDateTime CreatedAt = LocalDateTime.now();
    }

}
