package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class PatientController {

    @Autowired
    PatientService patientService;

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/patients")
    public List<Patient> findAll() {
        return patientService.findAll();
    }

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/patients/{id}")
    public Patient findPatientById(@PathVariable(value = "id") Long id) {
        return patientService.findPatientById(id);
    }

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/add/patients")
    public Patient addPatient (@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }

    @CrossOrigin(origins ="*")
    @PutMapping(value = "/update/patients/{id}")
    public Patient updatePatient (@RequestBody Patient patient) {
        return patientService.updatePatient(patient);
    }

    @CrossOrigin(origins ="*")
    @DeleteMapping(value = "/delete/patients/{id}")
    public void deletePatient (@PathVariable(value = "id") Long id) {
        patientService.deletePatient(id);
    }
}