package com.project.clubfacil.dtos.paymentsResponseDto;

public class TransactionDetails{
    public Object acquirer_reference;
    public Object external_resource_url;
    public Object financial_institution;
    public int installment_amount;
    public int net_received_amount;
    public int overpaid_amount;
    public Object payable_deferral_period;
    public Object payment_method_reference_id;
    public int total_paid_amount;
}