package fr.simplon.picone.service;

import fr.simplon.picone.Model.Etablissement;
import fr.simplon.picone.Model.Patient;
import fr.simplon.picone.repository.EtablissementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtablissementServiceImpl implements EtablissementService{

    @Autowired
    EtablissementRepository etablissementRepository;

    @Override
    public List<Etablissement> returnAllEtablissement() {
       return etablissementRepository.findAll();
    }

    @Override
    public List<Patient> returnPatientsByEtablissement() {
        return etablissementRepository.returnPatientByEtablissement();

    }
}
