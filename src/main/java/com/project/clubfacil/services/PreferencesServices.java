package com.project.clubfacil.services;


import com.project.clubfacil.dtos.preferencesRequestDTO.PreferencesResponseDto;
import com.project.clubfacil.dtos.preferencesRequestDTO.RootRequestDto;
import com.project.clubfacil.dtos.preferencesResponseDto.RootResponseDto;
import com.project.clubfacil.model.preferences.*;
import com.project.clubfacil.repository.preferences.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class PreferencesServices {

    @Value("${my.property.authorization}")
    private String authorization;

    @Value("${my.property.url}")
    private String url;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PhonePreferenceRepository phonePreferenceRepository;

    @Autowired
    PayerPreferenceRepository payerPreferenceRepository;


    @Autowired
    IdetentificationPreferencesRepository identificationRepository;

    @Autowired
    ItemPreferenceRepository itemPreferenceRepository;

    @Autowired
    PreferencesRepository preferencesRepository;


    public PreferencesResponseDto createPreferences(RootRequestDto rootRequestDto) {

        Preferences preferences = new Preferences();

        Payer payer = new Payer();
        Phone phoneNew = new Phone();
        Identification identification = new Identification();
        PreferencesResponseDto preferencesResponseDto = new PreferencesResponseDto();
        List<Item> itemList = new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", authorization);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<RootRequestDto> request = new HttpEntity<>(rootRequestDto, headers);

        ResponseEntity<RootResponseDto> response = restTemplate.postForEntity(url+"checkout/preferences", request, RootResponseDto.class);

        System.out.println(response.getBody().toString());


        //List<Phone> phoneList = new ArrayList<>();

        // phoneList = phonePreferenceRepository.findAll();


        phoneNew.setArea_code(response.getBody().payer.phone.area_code);
        phoneNew.setNumber(response.getBody().payer.phone.number);
        phonePreferenceRepository.save(phoneNew);
        payer.setPhone(phonePreferenceRepository.findById(phoneNew.getId()).get());

//        List<Identification> identificationList = new ArrayList<>();
//
//        identificationList = identificationRepository.findAll();


        identification.setType(response.getBody().payer.identification.type);
        identification.setNumber(response.getBody().payer.identification.number);
        identificationRepository.save(identification);
        payer.setIdentification(identificationRepository.findById(identification.getId()).get());


        response.getBody().items.forEach(itemResponseDto -> {
            Item item = new Item();
            item.setCurrency_id(itemResponseDto.currency_id);
            item.setDescription(itemResponseDto.description);
            item.setTitle(itemResponseDto.title);
            item.setQuantity(itemResponseDto.quantity);
            item.setUnit_price(itemResponseDto.unit_price);
            itemList.add(item);

            preferencesResponseDto.setItems(itemList);
            itemPreferenceRepository.save(item);
        });

        payer.setEmail(response.getBody().payer.email);
        payer.setName(response.getBody().payer.name);
        payer.setSurname(response.getBody().payer.surname);
        payer.setDateCreated(response.getBody().date_created);
        preferencesResponseDto.setPayer(payer);

        payerPreferenceRepository.save(payer);
        preferences.setPayer(payerPreferenceRepository.getById(payer.getId()));
        preferences.setExternal_reference(response.getBody().external_reference);
        preferences.setSandbox_init_point(response.getBody().sandbox_init_point);
        preferencesResponseDto.setUrlInit(response.getBody().sandbox_init_point);


        preferencesRepository.save(preferences);


        return preferencesResponseDto;

    }


}
