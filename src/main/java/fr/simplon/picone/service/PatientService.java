package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PatientService {
    List<Patient> getAllPatients();
    Patient findPatientById(Long id);
    Patient addPatient (Patient patient);
    Patient updatePatient (Patient patient);
    void deletePatient(Long id);

}

