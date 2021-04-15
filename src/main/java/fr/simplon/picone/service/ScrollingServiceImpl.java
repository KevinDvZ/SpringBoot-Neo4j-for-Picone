package fr.simplon.picone.service;

import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.repository.ScrollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScrollingServiceImpl implements ScrollingService{


    @Autowired
    private ScrollingRepository scrollingRepository;


    @Override
    public Scrolling findDefaultScrollingByPatientId(Long id) {
        return scrollingRepository.findDefaultScrollingByPatientId(id);
    }

    @Override
    public List<Scrolling> getAllScrollings() {
        return scrollingRepository.findAll();
    }

    @Override
    public Optional<Scrolling> findScrollingById(Long id, Scrolling scrolling) {

        Optional<Scrolling> monScro = scrollingRepository.findById(id)
                .map(p -> {
                    p.setByDefault(scrolling.getByDefault());
                    p.setCodeCouleur(scrolling.getCodeCouleur());
                    p.setDefaultSpeed(scrolling.getDefaultSpeed());
                    p.setActive(scrolling.getActive());
                    return p;
                });

        monScro.map(this.scrollingRepository::save);
        return scrollingRepository.findById(id);
    }
}
