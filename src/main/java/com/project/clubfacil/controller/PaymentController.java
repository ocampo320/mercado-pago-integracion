package com.project.clubfacil.controller;

import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.services.IdentificationTypesServices;
import com.project.clubfacil.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    PaymentServices paymentServices;

    @GetMapping("/{paymentId}")
    public void getIdentificationTypes(@PathVariable("paymentId") String paymentId) {
//        String token = request.getHeader(tokenHeader);
//        String username = jwtProvider.getNombreUsuarioFromToken(token);
//        String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
//        List<ApartmentResponse> list = apartmentServices.findApartmentByFloor(id);
         paymentServices.getPayment( paymentId);
    }
}

