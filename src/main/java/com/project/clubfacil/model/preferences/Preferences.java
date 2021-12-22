package com.project.clubfacil.model.preferences;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)

public class Preferences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private List<Item> items=new ArrayList<>();

    @OneToOne
    private Payer payer;

    public Preferences() {

    }
}
