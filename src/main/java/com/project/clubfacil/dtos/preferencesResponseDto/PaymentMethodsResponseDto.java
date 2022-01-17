package com.project.clubfacil.dtos.preferencesResponseDto;

import java.util.List;

public class PaymentMethodsResponseDto {
    public Object default_card_id;
    public Object default_payment_method_id;
    public List<ExcludedPaymentMethodResponseDto> excluded_payment_methods;
    public List<ExcludedPaymentTypeResponseDto> excluded_payment_types;
    public Object installments;
    public Object default_installments;
}
