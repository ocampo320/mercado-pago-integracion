package com.project.clubfacil.model;

import com.sun.istack.NotNull;
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
public class IdentificationTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBD;

    @NotNull
    String id;

    @NotNull
    String name;

    @NotNull
    String type;

    @NotNull
    int min_length;

    @NotNull
    int max_length;

    public IdentificationTypes() {

    }


}
