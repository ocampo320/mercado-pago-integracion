package com.project.clubfacil.dtos.preferencesResponseDto;

import java.util.Date;

public class PayerResponseDto {
    public PhoneResponseDto phone;
    public AddressResponseDto address;
    public String email;
    public IdentificationResponseDto identification;
    public String name;
    public String surname;
    public Date date_created;
    public Object last_purchase;
}
