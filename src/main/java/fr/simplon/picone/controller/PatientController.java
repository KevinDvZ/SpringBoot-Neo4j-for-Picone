package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

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
        return patientService.returnAddPatient(patient);
    }

    @PutMapping(value = "/updatePatient/", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient returnUpdatePatient (@RequestBody Patient patient) {
        return patientService.returnUpdatePatient(patient);
    }

    @DeleteMapping(value = "/deletePatient/", produces = MediaType.APPLICATION_JSON_VALUE)
    public void returnDeletePatient (@RequestBody Patient patient){
        patientService.returnDeletePatient(patient);
    }
}