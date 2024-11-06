package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Parcel {
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


}
