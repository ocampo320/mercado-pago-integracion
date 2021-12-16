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
public class Bin{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String pattern;
    private String exclusion_pattern;
    private String installments_pattern;

    public Bin() {

    }
}
