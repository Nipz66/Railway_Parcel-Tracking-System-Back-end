package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String firstName;
    private String lastName;
    private String address;
    private String phoneNumber;
    private Integer dob;
    private String email;
    private String station;
    private String role;

}
