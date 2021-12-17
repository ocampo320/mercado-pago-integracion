package com.project.clubfacil.model.paymentMethods;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class SecurityCode{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String mode;
    private int length;
    private String card_location;

    public SecurityCode() {

    }
}