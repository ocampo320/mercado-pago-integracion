package com.project.clubfacil.controller;


import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.services.IdentificationTypesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/identificationTypes")
@CrossOrigin(origins = "*")


public class IdentificationTypesController {


    @Autowired
    IdentificationTypesServices identificationTypesServices;

    @GetMapping()
    public List<IdentificationTypes> getIdentificationTypes() {
//        String token = request.getHeader(tokenHeader);
//        String username = jwtProvider.getNombreUsuarioFromToken(token);
//        String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
//        List<ApartmentResponse> list = apartmentServices.findApartmentByFloor(id);
        return identificationTypesServices.getIdentificationTypes();
    }

}


