package com.project.clubfacil.services;


import com.project.clubfacil.dtos.preferencesRequestDTO.RootRequestDto;
import com.project.clubfacil.dtos.preferencesResponseDto.RootResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
@Transactional
public class PreferencesServices {

    @Autowired
    RestTemplate restTemplate;

    public RootResponseDto createPreferences(RootRequestDto rootRequestDto) {
        /**
         * '{
         *           "items": [
         *               {
         *               "title": "Dummy Item",
         *               "description": "Multicolor Item",
         *               "quantity": 1,
         *               "currency_id": "ARS",
         *               "unit_price": 10.0
         *               }
         *           ],
         *           "payer": {
         *               "email": "payer@email.com"
         *           }
         *     }'
         */

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer APP_USR-3951552830330174-121221-5adc5eb48689499ac13c310710d71299-109891437");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));


        HttpEntity<RootRequestDto> request = new HttpEntity<>(rootRequestDto, headers);


        ResponseEntity<RootResponseDto> response = restTemplate.postForEntity("https://api.mercadopago.com/checkout/preferences", request, RootResponseDto.class);


        System.out.println(response.getBody().toString());

        return response.getBody();

    }

}
