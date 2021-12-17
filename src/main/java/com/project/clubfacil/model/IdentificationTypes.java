package com.project.clubfacil.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class IdentificationTypes {


    @Id
    @NotNull
    private String id;

    @NotNull
    private  String name;

    @NotNull
    private  String type;

    @NotNull
    private  int min_length;

    @NotNull
    private int max_length;

    public IdentificationTypes() {

    }


}
