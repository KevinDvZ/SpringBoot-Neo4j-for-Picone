package fr.simplon.picone.service;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.repository.EstablishmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentServiceImpl implements EstablishmentService {

    @Autowired
    EstablishmentRepository establishmentRepository;

    @Override
    public List<Establishment> returnAllEtablissement() {
       return establishmentRepository.findAll();
    }

    @Override
    public List<Establishment> returnPatientsByEtablissement() {
        return establishmentRepository.returnPatientByEtablissement();

    }
}
