package com.project.clubfacil.model.preferences;

import com.project.clubfacil.model.IdentificationTypes;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Payer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    public String name;
    public String surname;
    public String email;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "phone")
    public Phone phone;

    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "identification")
    public Identification identification;


    public Payer() {

    }
}