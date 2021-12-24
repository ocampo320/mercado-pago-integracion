package com.project.clubfacil.controller;

import com.project.clubfacil.dtos.PaymentMethodsDTO;
import com.project.clubfacil.model.paymentMethods.PaymentMethods;
import com.project.clubfacil.services.PaymentMethodsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paymentMethods")
@CrossOrigin(origins = "*")
public class PaymentMethodsController {


    /**
     * Obtiene los metodos de pagos desde mercado pago
     */
    @Autowired
    PaymentMethodsServices paymentMethodsServices;

    @GetMapping()
    public List<PaymentMethodsDTO> get() {
        return paymentMethodsServices.getPaymentMethodsFromApi();
    }
}
