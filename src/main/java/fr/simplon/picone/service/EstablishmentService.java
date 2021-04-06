package fr.simplon.picone.service;

import fr.simplon.picone.model.Establishment;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Service
public interface EstablishmentService {




    List<Establishment> returnAllEstablishment();
    Establishment findEstablishmentById(Long id);
    Establishment returnAddEstablishmentByEstablishment (Establishment establishment);
    void deleteEstablishment (long id) ;
    Establishment returnUpdateEstablishmentByEstablishment (Establishment establishment);

}
