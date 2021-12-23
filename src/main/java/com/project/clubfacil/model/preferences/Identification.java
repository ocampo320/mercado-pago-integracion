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
@NoArgsConstructor
@Builder(toBuilder = true)
public class Identification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String type;
    String number;

}
