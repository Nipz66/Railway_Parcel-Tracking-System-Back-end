package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Staff {
    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String dob;
    private String email;
    private String station;
    private String role;
    private String password;

}
