package com.project.clubfacil;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.repository.IdentificationTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class ClubFacilApplication {

    @Autowired
    IdentificationTypesRepository identificationTypesRepository;

    public static void main(String[] args) {
        System.out.printf("Se inicio la app");

        SpringApplication.run(ClubFacilApplication.class, args);

    }
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return args -> {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization","Bearer APP_USR-3951552830330174-121221-5adc5eb48689499ac13c310710d71299-109891437");
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<IdentificationTypes> entity = new HttpEntity<IdentificationTypes>(headers);

            ResponseEntity<IdentificationTypes[]> response3 = restTemplate.exchange("https://api.mercadopago.com/v1/identification_types", HttpMethod.GET, entity, IdentificationTypes[].class);
            if(response3.getStatusCode().equals(HttpStatus.OK))
            {
                Arrays.stream(response3.getBody()).forEach(identificationTypes -> {
                    IdentificationTypes identificationTypesNew=new IdentificationTypes();
                    identificationTypesNew.setType(identificationTypes.getType());
                    identificationTypesNew.setMax_length(identificationTypes.getMax_length());
                    identificationTypesNew.setMin_length(identificationTypes.getMin_length());
                    identificationTypesNew.setName(identificationTypes.getName());
                    identificationTypesNew.setId(identificationTypes.getId());
                    identificationTypesRepository.save(identificationTypesNew);
                    System.out.println(identificationTypes.getName());
                });

            }


        };
    }

}
