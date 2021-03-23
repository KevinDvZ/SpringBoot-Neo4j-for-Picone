package fr.simplon.picone.controller;


import fr.simplon.picone.model.Patient;
import fr.simplon.picone.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @CrossOrigin("*")
    @GetMapping("/patient")
    public List<Patient> findNodes(){
        return patientService.findNodes();
    }

    @CrossOrigin("*")
    @GetMapping(value = "/patients/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Patient> findNodesById(@PathVariable Long id){
        return patientService.findNodesById(id);
    }

    @CrossOrigin("*")
    @GetMapping(value = "/patient/{id}/{relation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> findNodesByIdAndRelation(@PathVariable Long id, @PathVariable String relation){
        return patientService.findByIdAndByRelation(id, relation);
    }

}
