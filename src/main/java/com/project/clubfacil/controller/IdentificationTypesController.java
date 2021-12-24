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

    /**
     * Obtiene desde mercado pago la lista de tipos de documentos.
     */
    @Autowired
    IdentificationTypesServices identificationTypesServices;

    @GetMapping()
    public List<IdentificationTypes> getIdentificationTypes() {
        return identificationTypesServices.getIdentificationTypes();
    }
}


