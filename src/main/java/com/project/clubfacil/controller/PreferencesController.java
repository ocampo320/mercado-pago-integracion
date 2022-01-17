package com.project.clubfacil.controller;


import com.project.clubfacil.dtos.preferencesRequestDTO.PreferencesResponseDto;
import com.project.clubfacil.dtos.preferencesRequestDTO.RootRequestDto;
import com.project.clubfacil.dtos.preferencesResponseDto.RootResponseDto;
import com.project.clubfacil.model.IdentificationTypes;
import com.project.clubfacil.services.IdentificationTypesServices;
import com.project.clubfacil.services.PreferencesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preferences")
@CrossOrigin(origins = "*")
public class PreferencesController {

    /**
     * Se crea la preferencia, la cual retorna el objeto con los datos para mostrar la venta de pago
     */

    @Autowired
    PreferencesServices preferencesServices;

    @PostMapping()
    public ResponseEntity<PreferencesResponseDto> createPreferences(@RequestBody RootRequestDto rootRequestDto) {
        PreferencesResponseDto preferencesResponseDto=new PreferencesResponseDto();
        preferencesResponseDto=preferencesServices.createPreferences(rootRequestDto);
        return new ResponseEntity(preferencesResponseDto, HttpStatus.OK);
    }

}
