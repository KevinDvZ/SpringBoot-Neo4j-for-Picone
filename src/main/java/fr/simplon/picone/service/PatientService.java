package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PatientService {

    List<Patient> findNodes();

    Optional<Patient> findNodesById(Long id);

    List<Patient> findByIdAndByRelation(Long id, String relation);
}

