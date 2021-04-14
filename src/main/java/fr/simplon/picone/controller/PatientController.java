package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
    public Optional <Patient> findPatientById(@PathVariable(value = "id") Long id) {
        return patientService.findPatientById(id);
    }

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/patients")
    public Patient addPatient (@RequestBody Patient patient, @RequestParam(required = true) Long idEstablishment ) throws InterruptedException {
        return patientService.addPatient(patient, idEstablishment);
    }

   /* @CrossOrigin(origins ="*")
    @PutMapping(value = "/patients/{id}")
    public Patient updatePatient (@RequestBody Patient patient, @PathVariable(value = "id") Long id) {
        return patientService.updatePatient(patient, id);
    }*/

    @CrossOrigin(value = "", allowedHeaders = "")
    @PutMapping(value = "/patients/{id}")
    public @ResponseBody
    Patient updatePatient(@RequestBody Patient patient, @PathVariable(value = "id") Long id)throws Exception{
     Optional<Patient> e =patientService.findPatientById(id);
    if (e.isPresent()){
        Patient currentPatient= e.get();
        String firstName = patient.getFirstName();

        if (firstName != null){
            currentPatient.setFirstName(firstName);
        }
        String lastName = patient.getLastName();
        if (lastName != null){
            currentPatient.setLastName(lastName);
        }
        String email = patient.getEmail();
        if (email != null){
            currentPatient.setEmail(email);
        }
        String password = patient.getPassword();
        if (password != null){
            currentPatient.setPassword(password);
        }
        patientService.updatePatient(currentPatient);
        return currentPatient;
    } else {
        return null;}
    }

    @CrossOrigin(origins ="*")
    @DeleteMapping(value = "/patients/{id}")
    public void deletePatient (@PathVariable(value = "id") Long id) {
        patientService.deletePatient(id);
    }


}