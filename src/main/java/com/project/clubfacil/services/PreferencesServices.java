package com.project.clubfacil.services;


import com.project.clubfacil.dtos.preferencesRequestDTO.PreferencesResponseDto;
import com.project.clubfacil.dtos.preferencesRequestDTO.RootRequestDto;
import com.project.clubfacil.dtos.preferencesResponseDto.RootResponseDto;
import com.project.clubfacil.model.preferences.*;
import com.project.clubfacil.repository.preferences.*;
import org.springframework.beans.factory.annotation.Autowired;
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
        PreferencesResponseDto preferencesResponseDto=new PreferencesResponseDto();
        List<Item>itemList=new ArrayList<>();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer APP_USR-3951552830330174-121221-5adc5eb48689499ac13c310710d71299-109891437");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<RootRequestDto> request = new HttpEntity<>(rootRequestDto, headers);

        ResponseEntity<RootResponseDto> response = restTemplate.postForEntity("https://api.mercadopago.com/checkout/preferences", request, RootResponseDto.class);

        System.out.println(response.getBody().toString());


        //List<Phone> phoneList = new ArrayList<>();

       // phoneList = phonePreferenceRepository.findAll();


            phoneNew.setArea_code(response.getBody().payer.phone.area_code);
            phoneNew.setNumber(response.getBody().payer.phone.number);
            phonePreferenceRepository.save(phoneNew);
            payer.setPhone(phonePreferenceRepository.findById(phoneNew.getId()).get());

        List<Identification> identificationList = new ArrayList<>();

        identificationList = identificationRepository.findAll();

        if (identificationList.size() == 0) {
            identification.setType(response.getBody().payer.identification.type);
            identification.setNumber(response.getBody().payer.identification.number);
            identificationRepository.save(identification);
            payer.setIdentification(identificationRepository.findById(identification.getId()).get());

        } else {
            identificationRepository.findAll().forEach(identification1 -> {
                if (identification1.getNumber().equals(request.getBody().payer.identification.getNumber()) && identification1.getType().equals(request.getBody().payer.identification.getType())) {

                    System.out.println("Es la misma cedula y el mismo tipo de documento, no se puede crear");


                } else {
                    identification.setType(response.getBody().payer.identification.type);
                    identification.setNumber(response.getBody().payer.identification.number);
                    identificationRepository.save(identification);
                    payer.setIdentification(identificationRepository.findById(identification.getId()).get());

                }
            });

        }

    response.getBody().items.forEach(itemResponseDto ->{
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
