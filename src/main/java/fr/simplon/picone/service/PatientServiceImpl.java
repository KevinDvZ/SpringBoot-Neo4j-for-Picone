package fr.simplon.picone.service;


import fr.simplon.picone.model.Patient;
import fr.simplon.picone.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getAllPatients() {
       return patientRepository.findAll();
    }

    @Override
    public Patient findPatientById(Long id) {
        return patientRepository.findPatientById(id);
    }

    @Override
    public Patient addPatient(Patient patient){
        return patientRepository.save(patient);
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