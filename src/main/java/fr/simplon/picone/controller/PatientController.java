package fr.simplon.picone.controller;

import fr.simplon.picone.Model.Patient;
import fr.simplon.picone.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RestController
@RequestMapping(value = "/patient")
public class PatientController {

    final PatientRepository patientRepository;

    @Autowired
    public PatientController(PatientRepository patientRepository ){
      this.patientRepository = patientRepository;
    }

    @RequestMapping (method = RequestMethod.GET)
    public Iterable<Patient> readAll() {
      return patientRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Patient create(@RequestBody Patient patient){
      return patientRepository.save(patient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Patient> read(@PathVariable Long id) {
        return patientRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Patient update(@PathVariable Long id, @RequestBody Patient update) {
        final Optional<Patient> existing = patientRepository.findById(id);
        return patientRepository.save(existing.get());
    }
}
