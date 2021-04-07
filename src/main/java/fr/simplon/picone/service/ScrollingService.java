package fr.simplon.picone.service;


import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Scrolling;
import org.springframework.stereotype.Service;

@Service
public interface ScrollingService {

    Scrolling findDefaultScrollingByPatientId(Long id);
}
