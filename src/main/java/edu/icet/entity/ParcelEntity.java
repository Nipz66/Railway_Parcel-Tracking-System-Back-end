package edu.icet.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "parcel")
public class ParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String senderName;
    private String senderPhoneNumber;
    private String senderGmail;
    private String senderAddress;
    private String receiverName;
    private String receiverPhoneNumber;
    private String receiverGmail;
    private String receiverAddress;
    private double weight;
    private String description;
    private String originStation;
    private String destinationStation;
    private double payment;
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

}

