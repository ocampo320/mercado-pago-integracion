package com.project.clubfacil.dtos.preferencesRequestDTO;

import com.project.clubfacil.model.IdentificationTypes;

import java.util.Date;

public class PayerRequestDto {
    public String name;
    public String surname;
    public String email;
    public Date date_created;
    public PhoneRequestDto phone;
    public IdentificationTypes identification;
    public AddressRequestDto address;
}