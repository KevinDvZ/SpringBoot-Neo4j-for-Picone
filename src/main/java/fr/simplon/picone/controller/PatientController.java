package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.service.PatientService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {

    @GetMapping(value = "/patients", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> returnAllPatient() {
        return patientService.returnAllPatient();
    }

    @GetMapping(value = "/patient/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Patient> returnPatient() {
        return patientService.returnPatientByPatient();
    }

    @PostMapping(value = "/addPatient/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient returnAddPatient (@RequestBody Patient patient){
            return patientService.returnAddPatientByPatient(patient);
    }
}