package fr.simplon.picone.service;

import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.repository.ScrollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrollingServiceImpl implements ScrollingService{


    @Autowired
    private ScrollingRepository scrollingRepository;


    @Override
    public Scrolling findDefaultScrollingByPatientId(Long id) {
        return scrollingRepository.findDefaultScrollingByPatientId(id);
    }
}
