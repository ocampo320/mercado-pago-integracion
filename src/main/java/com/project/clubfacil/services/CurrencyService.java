package com.project.clubfacil.services;

import com.project.clubfacil.dtos.PaymentMethodsDTO;
import com.project.clubfacil.model.Currency;
import com.project.clubfacil.model.IdentificationTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class CurrencyService {

    @Autowired
    RestTemplate restTemplate;


    @Value("${my.property.url}")
    private String url;

    @Value("${my.property.authorization}")
    private String authorization;

    /***
     * Retorna la lista de tipos de currency, los tipos de monedas con las que se puede pagar
     * @return
     */

   public List<Currency> getCurrencies() {

       HttpHeaders headers = new HttpHeaders();
       headers.set("Authorization", authorization);
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       HttpEntity<Currency> entity = new HttpEntity<Currency>(headers);
        ResponseEntity<Currency[]> currencyList = restTemplate.exchange("https://api.mercadolibre.com/classified_locations/countries", HttpMethod.GET, entity, Currency[].class);
        List<Currency> currencyListNew = new ArrayList<>();

        Arrays.stream(currencyList.getBody()).forEach(currency -> {
            currencyListNew.add(Currency.builder()
                    .id(currency.getId())
                    .currency_id(currency.getCurrency_id())
                    .locale(currency.getLocale())
                    .name(currency.getName())
                    .build());
        });

        return currencyListNew;


    }
}
