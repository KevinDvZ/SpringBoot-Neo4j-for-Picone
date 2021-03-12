package fr.simplon.picone.controller;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstablishmentController {

    @Autowired
    EstablishmentService establishmentService;

    @GetMapping(value = "/etablissements", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Establishment> returnAllEtablissements() {
        return establishmentService.returnAllEtablissement();
    }

    @GetMapping(value = "/etablissements/patients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Establishment> returnPatients() {
        return establishmentService.returnPatientsByEtablissement();
    }



}
