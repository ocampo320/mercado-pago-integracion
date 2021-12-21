package com.project.clubfacil.dtos.preferencesResponseDto;

import com.project.clubfacil.model.preferences.Item;

import java.util.Date;
import java.util.List;

public class RootResponseDto {
    public String additional_info;
    public String auto_return;
    public BackUrlsResponseDto back_urls;
    public boolean binary_mode;
    public String client_id;
    public int collector_id;
    public Object coupon_code;
    public Object coupon_labels;
    public Date date_created;
    public Object date_of_expiration;
    public Object expiration_date_from;
    public Object expiration_date_to;
    public boolean expires;
    public String external_reference;
    public String id;
    public String init_point;
    public Object internal_metadata;
    public List<ItemResponseDto> items;
    public String marketplace;
    public int marketplace_fee;
    public MetadataResponseDto metadata;
    public Object notification_url;
    public String operation_type;
    public PayerResponseDto payer;
    public PaymentMethodsResponseDto payment_methods;
    public Object processing_modes;
    public Object product_id;
    public RedirectUrlsResponseDto redirect_urls;
    public String sandbox_init_point;
    public String site_id;
    public ShipmentsResponseDto shipments;
    public Object total_amount;
    public Object last_updated;
}
