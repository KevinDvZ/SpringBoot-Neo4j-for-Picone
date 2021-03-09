package fr.simplon.picone.service;

import fr.simplon.picone.Model.Mot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MotService {

    List<Mot> findAll();


}
