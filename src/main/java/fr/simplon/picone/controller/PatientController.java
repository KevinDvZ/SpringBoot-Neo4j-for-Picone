package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin("*)")
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping(value = "/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping(value = "/patients/{id}")
    public String findPatientById(@PathVariable(value = "id") Long id) {
        return patientService.findPatientById(id).getEmail();
    }

    @PostMapping(value = "/addPatient/")
    public Patient addPatient (@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @PutMapping(value = "/updatePatient/{id}")
    public Patient updatePatient (@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @DeleteMapping(value = "/deletePatient/{id}")
    public void deletePatient (@PathVariable(value = "id") Long id) {
        patientService.deletePatient(id);
    }
}