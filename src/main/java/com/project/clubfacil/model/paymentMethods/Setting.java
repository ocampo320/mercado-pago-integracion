package com.project.clubfacil.model.paymentMethods;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Bin bin;
    @ManyToOne(cascade = CascadeType.ALL)
    private CardNumber card_number;
    @ManyToOne(cascade = CascadeType.ALL)
    private SecurityCode security_code;

    public Setting() {

    }
}