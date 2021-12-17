package com.project.clubfacil.model.paymentMethods;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


    @OneToMany
    private List<Setting> settings=new ArrayList<>();

@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
@JoinTable(name = "paymentMethods_AdditionalInfoNeeded", joinColumns = @JoinColumn(name = "paymentMethods_id"),
        inverseJoinColumns = @JoinColumn(name = "additionalInfoNeeded_id"))
    private List<AdditionalInfoNeeded> additional_info_needed=new ArrayList<>();


    private int min_allowed_amount;
    private int max_allowed_amount;
    private int accreditation_time;



    @OneToMany
    private List<FinancialInstitution> financial_institutions=new ArrayList<>();


    @OneToMany
    private List<ProcessingModes> processing_modes=new ArrayList<>();;

    public PaymentMethods() {

    }
}
