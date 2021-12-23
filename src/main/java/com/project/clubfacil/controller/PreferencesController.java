package com.project.clubfacil.controller;


import com.project.clubfacil.dtos.preferencesRequestDTO.PreferencesResponseDto;
import com.project.clubfacil.dtos.preferencesRequestDTO.RootRequestDto;
import com.project.clubfacil.dtos.preferencesResponseDto.RootResponseDto;
import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.services.IdentificationTypesServices;
import com.project.clubfacil.services.PreferencesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preferences")
@CrossOrigin(origins = "*")
public class PreferencesController {


    @Autowired
    PreferencesServices preferencesServices;

    @PostMapping()
    public PreferencesResponseDto createPreferences(@RequestBody RootRequestDto rootRequestDto) {
//        String token = request.getHeader(tokenHeader);
//        String username = jwtProvider.getNombreUsuarioFromToken(token);
//        String nombreUsuario = jwtProvider.getNombreUsuarioFromToken(token);
//        List<ApartmentResponse> list = apartmentServices.findApartmentByFloor(id);
        return preferencesServices.createPreferences(rootRequestDto);
    }

}
