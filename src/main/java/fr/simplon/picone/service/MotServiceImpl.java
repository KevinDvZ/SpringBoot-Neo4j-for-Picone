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

    @Override
    public List<Mot> findNodes() {
        return motRepository.findAll();
    }

    /*@Override
    public List<Mot> findByIdTest(Long id) {
        return motRepository.trouverNoeudsEnfants(id);
    }*/

    @Override
    public List<Mot> findByIdAndByRelation( Long id, String relation) {
        return motRepository.trouverNoeudsEnfants(id,relation);
    }

    @Override
    public Optional<Mot> findNodesById(Long id) {
        return motRepository.findById(id);
    }

}
