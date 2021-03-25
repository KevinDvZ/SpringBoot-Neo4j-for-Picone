package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface PatientService {
    List<Patient> returnAllPatient();
    List<Patient> returnPatientByPatient();
    Patient returnAddPatient (Patient patient);
    Patient returnUpdatePatient (Patient patient);
    void returnDeletePatient(Patient patient);

}

