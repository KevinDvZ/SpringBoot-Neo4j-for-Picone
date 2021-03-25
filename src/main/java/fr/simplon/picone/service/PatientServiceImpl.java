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
    public List<Patient> returnAllPatient() {
       return patientRepository.findAll();
    }

    @Override
    public List<Patient> returnPatientByPatient() {
        return patientRepository.returnPatientByPatient();
    }

    @Override
    public Patient returnAddPatient(Patient patient){
        return patientRepository.save(patient);
    }

    @Override
    public Patient returnUpdatePatient (Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void returnDeletePatient(Patient patient) {
        patientRepository.delete(patient);
    }
}