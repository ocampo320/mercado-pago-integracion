package com.project.clubfacil.dtos.preferencesResponseDto;

import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.model.preferences.Address;
import com.project.clubfacil.model.preferences.Phone;

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
