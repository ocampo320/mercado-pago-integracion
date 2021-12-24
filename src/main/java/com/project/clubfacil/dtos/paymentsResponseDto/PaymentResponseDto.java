package com.project.clubfacil.dtos.paymentsResponseDto;

import java.util.Date;
import java.util.List;

public class PaymentResponseDto {
    public List<Object> acquirer_reconciliation;
    public AdditionalInfo additional_info;
    public Object authorization_code;
    public boolean binary_mode;
    public Object brand_id;
    public Object call_for_authorize_id;
    public boolean captured;
    public Card card;
    public List<Object> charges_details;
    public int collector_id;
    public Object corporation_id;
    public Object counter_currency;
    public int coupon_amount;
    public String currency_id;
    public Date date_approved;
    public Date date_created;
    public Date date_last_updated;
    public Date date_of_expiration;
    public Object deduction_schema;
    public String description;
    public Object differential_pricing_id;
    public Object external_reference;
    public List<FeeDetail> fee_details;
    public int id;
    public int installments;
    public Object integrator_id;
    public String issuer_id;
    public boolean live_mode;
    public Object marketplace_owner;
    public Object merchant_account_id;
    public Object merchant_number;
   // public Metadata metadata;
    public Date money_release_date;
    public Object money_release_schema;
    public int net_amount;
    public Object notification_url;
    public String operation_type;
    public Order order;
    public Payer payer;
    public String payment_method_id;
    public String payment_type_id;
    public Object platform_id;
  //  public PointOfInteraction point_of_interaction;
    public Object pos_id;
    public String processing_mode;
    public List<Object> refunds;
    public int shipping_amount;
    public Object sponsor_id;
    public String statement_descriptor;
    public String status;
    public String status_detail;
    public Object store_id;
    public List<Tax> taxes;
    public int taxes_amount;
    public int transaction_amount;
    public int transaction_amount_refunded;
    public TransactionDetails transaction_details;
}
