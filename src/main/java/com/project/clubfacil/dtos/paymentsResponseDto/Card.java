package com.project.clubfacil.dtos.paymentsResponseDto;

import java.util.Date;

public class Card{
    public Cardholder cardholder;
    public Date date_created;
    public Date date_last_updated;
    public int expiration_month;
    public int expiration_year;
    public String first_six_digits;
    public Object id;
    public String last_four_digits;
}
