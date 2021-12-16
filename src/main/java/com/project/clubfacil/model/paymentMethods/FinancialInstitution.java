package com.project.clubfacil.model.paymentMethods;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class FinancialInstitution {
    @Id
    public String id;
    public String description;

    public FinancialInstitution() {

    }
}

