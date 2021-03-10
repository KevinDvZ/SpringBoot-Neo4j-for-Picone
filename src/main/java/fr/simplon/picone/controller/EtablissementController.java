package fr.simplon.picone.controller;

import fr.simplon.picone.Model.Etablissement;
import fr.simplon.picone.Model.Patient;
import fr.simplon.picone.service.EtablissementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EtablissementController {

    @Autowired
    EtablissementService etablissementService;

    @GetMapping(value = "/etablissements", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Etablissement> returnAllEtablissements() {
        return etablissementService.returnAllEtablissement();
    }


}
