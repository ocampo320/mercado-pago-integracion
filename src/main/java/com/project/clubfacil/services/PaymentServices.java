package com.project.clubfacil.services;

import com.project.clubfacil.dtos.paymentsResponseDto.PaymentResponse;
import com.project.clubfacil.dtos.paymentsResponseDto.PaymentResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Service
@Transactional
public class PaymentServices {
    @Value("${my.property.authorization}")
    private   String authorization;


    @Value("${my.property.url}")
    private   String url;
    @Autowired
    RestTemplate restTemplate;


    public PaymentResponse getPayment(String code) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url+"v1/payments/")
                .path(code);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", authorization);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<?> request = new HttpEntity<>(headers);
        UriComponents uriComponents = builder.build().encode();

        System.out.println(uriComponents);

        ResponseEntity<PaymentResponseDto> response = restTemplate.exchange(uriComponents.toString(), HttpMethod.GET, request, PaymentResponseDto.class);

        PaymentResponse paymentResponse = new PaymentResponse();

        paymentResponse.setStatus(response.getBody().status);
        paymentResponse.setDescriptionProduct(response.getBody().description);
        paymentResponse.setTransactionAmount(response.getBody().transaction_amount);

        return paymentResponse;

    }


}
