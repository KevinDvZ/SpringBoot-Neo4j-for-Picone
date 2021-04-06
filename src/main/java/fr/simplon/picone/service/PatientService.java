package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PatientService {
    List<Patient> findAll();
    Patient findPatientById(Long id);
    Patient addPatient (Patient patient, Long idEstablishment) throws InterruptedException;
    Patient updatePatient (Patient patient);
    void deletePatient(Long id);

}

