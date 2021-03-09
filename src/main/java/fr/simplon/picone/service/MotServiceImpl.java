package fr.simplon.picone.service;

import fr.simplon.picone.Model.Mot;
import fr.simplon.picone.repository.MotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotServiceImpl implements MotService{


    @Autowired
    private MotRepository motRepository;

    @Override
    public List<Mot> findAll() {
        return motRepository.findAll();
    }

}
