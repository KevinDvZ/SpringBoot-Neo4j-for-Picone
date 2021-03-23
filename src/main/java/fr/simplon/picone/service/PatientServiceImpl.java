package fr.simplon.picone.service;


import fr.simplon.picone.model.Patient;
import fr.simplon.picone.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {


    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> findNodes() {
        return patientRepository.findAll();
    }

    @Override
    public Optional<Patient> findNodesById(Long id) {
        return patientRepository.findById(id);
    }

    @Override
    public List<Patient> findByIdAndByRelation( Long id, String relation) {
        return patientRepository.findChildNodes(relation, id);
    }

}
