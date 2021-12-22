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
    public Date date_created;
    @OneToOne
    public Phone phone;

    @OneToOne
    public IdentificationTypes identification;

    @OneToOne
    public Address address;

    public Payer() {

    }
}