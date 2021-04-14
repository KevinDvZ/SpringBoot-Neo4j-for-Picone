package fr.simplon.picone.service;


import fr.simplon.picone.model.Patient;
import fr.simplon.picone.repository.EstablishmentRepository;
import fr.simplon.picone.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EstablishmentRepository establishmentRepository;

    @Override
    public List<Patient> findAll() {
       return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findPatientById(Long id) {
        return patientRepository.findPatientById(id);
    }

    @Override
    public Patient addPatient(Patient patient, Long idEstablishment) throws InterruptedException {
        Patient response = patientRepository.save(patient);
         Thread.sleep(500);
        establishmentRepository.createPatientRelation(idEstablishment, response.getId());
        return response;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}