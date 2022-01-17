package com.project.clubfacil.services;

import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.repository.IdentificationTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class IdentificationTypesServices {


    @Autowired
    IdentificationTypesRepository identificationTypesRepository;


    @Autowired
    RestTemplate restTemplate;



    @Value("${my.property.url}")
    private String url;

    @Value("${my.property.authorization}")
    private   String authorization;

    /***
     * Retorna la lista de tipos de documentos de la base de datos, luego de hacer el consumo al api de mercado pago
     * @return
     */
    public List<IdentificationTypes> getIdentificationTypes() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",authorization);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<IdentificationTypes> entity = new HttpEntity<IdentificationTypes>(headers);
        ResponseEntity<IdentificationTypes[]> identificationTypesList = restTemplate.exchange(url+"identification_types", HttpMethod.GET, entity, IdentificationTypes[].class);

        if (identificationTypesList.getStatusCode().equals(HttpStatus.OK)) {
            Arrays.stream(identificationTypesList.getBody()).forEach(identificationTypes -> {
                IdentificationTypes identificationTypesNew = new IdentificationTypes();
                identificationTypesNew.setType(identificationTypes.getType());
                identificationTypesNew.setMax_length(identificationTypes.getMax_length());
                identificationTypesNew.setMin_length(identificationTypes.getMin_length());
                identificationTypesNew.setName(identificationTypes.getName());
                identificationTypesNew.setId(identificationTypes.getId());
                identificationTypesRepository.save(identificationTypesNew);
                System.out.println(identificationTypes.getName());
            });
        }


        return identificationTypesRepository.findAll();
    }







}
