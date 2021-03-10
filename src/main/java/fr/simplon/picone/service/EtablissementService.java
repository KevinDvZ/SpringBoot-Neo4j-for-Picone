package fr.simplon.picone.service;

import fr.simplon.picone.Model.Etablissement;
import fr.simplon.picone.Model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EtablissementService {

    List<Etablissement> returnAllEtablissement();
    List<Patient> returnPatientsByEtablissement();
}
