package com.project.clubfacil.model.preferences;


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
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String street_name;
    private int street_number;
    private String zip_code;

    public Address() {

    }
}