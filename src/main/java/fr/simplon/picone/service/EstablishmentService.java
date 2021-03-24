package fr.simplon.picone.service;

import fr.simplon.picone.model.Establishment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EstablishmentService {

    List<Establishment> returnAllEstablishment();
    List<Establishment> returnEstablishmentByEstablishment();
    Establishment returnAddEstablishmentByEstablishment (Establishment establishment);
}
