package fr.simplon.picone.service;

import fr.simplon.picone.Model.Mot;
import fr.simplon.picone.repository.MotRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MotServiceImpl implements MotService{


    @Autowired
    private MotRepository motRepository;

    @Override
    public List<Mot> findAll() {
        return null;
    }

    @Override
    public Mot find(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Mot createOrUpdate(Mot mot) {
        return null;
    }
}
