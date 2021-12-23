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

    @OneToOne
    private Payer payer;


    //Dato para hacer el llamdo al checkout
    public String external_reference;


    //Esta es la url para pintar en el webView
    public String sandbox_init_point;

    public Preferences() {

    }
}
