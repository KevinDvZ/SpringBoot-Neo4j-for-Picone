package fr.simplon.picone.controller;

import fr.simplon.picone.Model.Patient;
import fr.simplon.picone.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.neo4j.ogm.exception.core.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

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
    public Patient read(@PathVariable Long id) {
        return patientRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }

    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Patient update(@PathVariable Long id, @RequestBody Patient update) {
        final Patient existing = patientRepository.findById(id).orElseThrow(NotFoundException::new);
        existing.updateFrom(update);
        return patientRepository.save(existing);
    }
}
