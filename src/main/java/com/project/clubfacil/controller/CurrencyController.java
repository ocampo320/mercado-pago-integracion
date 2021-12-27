package com.project.clubfacil.controller;

import com.project.clubfacil.model.Currency;
import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
@CrossOrigin(origins = "*")
public class CurrencyController {

@Autowired
CurrencyService currencyService;


    @GetMapping()
    public List<Currency> getCurrency() {

        return currencyService.getCurrencies();
    }
}
