package com.project.clubfacil.model.paymentMethods;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)

public class PaymentMethods {

    @Id
    private String id;
    private String name;
    private String payment_type_id;
    private String status;
    private String secure_thumbnail;
    private String thumbnail;
    private String deferred_capture;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<Setting> settings;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<AdditionalInfoNeeded> additional_info_needed;


    private int min_allowed_amount;
    private int max_allowed_amount;
    private int accreditation_time;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<FinancialInstitution> financial_institutions;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    private List<ProcessingModes> processing_modes;

    public PaymentMethods() {

    }
}
