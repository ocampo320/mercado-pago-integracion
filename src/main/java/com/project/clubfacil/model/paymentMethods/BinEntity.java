package com.project.clubfacil.model.paymentMethods;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class BinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 2048)
    private String pattern;
    @Column(length = 2048)
    private String exclusion_pattern;
    @Column(length = 2048)
    private String installments_pattern;

    public BinEntity() {

    }
}
