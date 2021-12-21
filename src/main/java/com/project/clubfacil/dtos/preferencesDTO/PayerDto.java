package com.project.clubfacil.dtos.preferencesDTO;

import com.project.clubfacil.model.IdentificationTypes;

import java.util.Date;

public class PayerDto {
    public String name;
    public String surname;
    public String email;
    public Date date_created;
    public PhoneDto phone;
    public IdentificationTypes identification;
    public AddressDto address;
}