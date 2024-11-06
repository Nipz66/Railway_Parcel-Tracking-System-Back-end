package edu.icet.controller;

import edu.icet.dto.Parcel;
import edu.icet.service.ParcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcel")
@RequiredArgsConstructor
public class ParcelController {
    @Autowired
    final ParcelService service;
    @GetMapping("/get-parcel")
    public Parcel getParcel(){
      return new Parcel(1,"Nipun","0787548652","nipun66@gmail.com","Alawwa","Sadeep","0774433123","sadeep@gmail.com","Panadura",20,"Cocount","Alawwa","Panadura",220);
    }

    @PostMapping("/add-parcel")
    public void addParcel(@RequestBody Parcel parcel){
        service.addParcel(parcel);

    }
}
