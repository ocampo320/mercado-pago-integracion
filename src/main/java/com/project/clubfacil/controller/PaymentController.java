package com.project.clubfacil.controller;

import com.project.clubfacil.dtos.paymentsResponseDto.PaymentResponse;
import com.project.clubfacil.services.PaymentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    PaymentServices paymentServices;

    @GetMapping("/{paymentId}")
    public ResponseEntity<PaymentResponse> getIdentificationTypes(@PathVariable("paymentId") String paymentId, HttpServletRequest request) {
        PaymentResponse paymentResponse = new PaymentResponse();
//        String token = request.getHeader(tokenHeader);
//        String username = jwtProvider.getNombreUsuarioFromToken(token);
//        String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
//        List<ApartmentResponse> list = apartmentServices.findApartmentByFloor(id);
        paymentResponse = paymentServices.getPayment(paymentId);
        return new ResponseEntity(paymentResponse, HttpStatus.OK);
    }
}

