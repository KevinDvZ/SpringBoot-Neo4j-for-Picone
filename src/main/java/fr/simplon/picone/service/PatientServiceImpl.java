package fr.simplon.picone.service;


import fr.simplon.picone.model.Patient;
import fr.simplon.picone.repository.EstablishmentRepository;
import fr.simplon.picone.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Patient findPatientById(Long id) {
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
    public Patient updatePatient (Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}