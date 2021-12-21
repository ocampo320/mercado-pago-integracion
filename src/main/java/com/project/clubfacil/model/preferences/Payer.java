package com.project.clubfacil.model.preferences;

import com.project.clubfacil.model.IdentificationTypes;

import java.util.Date;

public class Payer{
    public String name;
    public String surname;
    public String email;
    public Date date_created;
    public Phone phone;
    public IdentificationTypes identification;
    public Address address;
}