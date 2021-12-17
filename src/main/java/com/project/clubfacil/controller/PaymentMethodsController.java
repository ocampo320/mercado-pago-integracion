package com.project.clubfacil.controller;

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


    @Autowired
    PaymentMethodsServices paymentMethodsServices;

    @GetMapping()
    public List<PaymentMethods> get
            () {
//        String token = request.getHeader(tokenHeader);
//        String username = jwtProvider.getNombreUsuarioFromToken(token);
//        String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
//        List<ApartmentResponse> list = apartmentServices.findApartmentByFloor(id);
        return paymentMethodsServices.getPaymentMethodsFromApi();
    }
}
