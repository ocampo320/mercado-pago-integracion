package com.project.clubfacil.dtos;

import com.project.clubfacil.model.paymentMethods.FinancialInstitution;
import com.project.clubfacil.model.paymentMethods.Setting;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@Builder(toBuilder = true)


public class PaymentMethodsDTO {
    public String id;
    public String name;
    public String payment_type_id;
    public String status;
    public String secure_thumbnail;
    public String thumbnail;
    public String deferred_capture;
    public List<Setting> settings;
    public List<String> additional_info_needed;
    public int min_allowed_amount;
    public int max_allowed_amount;
    public int accreditation_time;
    public List<FinancialInstitution> financial_institutions;
    public List<String> processing_modes;
}

