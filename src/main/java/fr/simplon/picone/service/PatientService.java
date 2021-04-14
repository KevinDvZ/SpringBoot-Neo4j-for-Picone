package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface PatientService {
    List<Patient> findAll();
    Optional <Patient> findPatientById(Long id);
    Patient addPatient (Patient patient, Long idEstablishment) throws InterruptedException;
    Patient updatePatient(Patient patient);
    void deletePatient(Long id);

}

