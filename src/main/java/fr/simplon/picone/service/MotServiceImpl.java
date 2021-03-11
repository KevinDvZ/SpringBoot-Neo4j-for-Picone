package fr.simplon.picone.service;

import fr.simplon.picone.Model.Mot;
import fr.simplon.picone.repository.MotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotServiceImpl implements MotService{


    @Autowired
    private MotRepository motRepository;

    // concaténer https://niveaubonus.fr/picone/src/icones/
    // variable d'environnement ? ${NEO4J_PASSWORD}

    @Override
    public List<Mot> findNodes() {

        List<Mot> listeMots = motRepository.findAll();
        System.out.println(listeMots);
        return listeMots;

    }

    @Override
    public Optional<Mot> findNodesById(Long id) {
        return motRepository.findById(id);
    }

    @Override
    public List<Mot> findByIdAndByRelation( Long id, String relation) {
        return motRepository.trouverNoeudsEnfants(id,relation);
    }


}
