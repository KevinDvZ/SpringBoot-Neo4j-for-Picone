package fr.simplon.picone.service;

import fr.simplon.picone.model.Establishment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstablishmentService {

    List<Establishment> returnAllEtablissement();
    List<Establishment> returnPatientsByEtablissement();
}
