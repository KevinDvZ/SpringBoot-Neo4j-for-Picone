package fr.simplon.picone.service;

import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.repository.ScrollingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScrollingServiceImpl implements ScrollingService {


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

    @Override
    public ResponseEntity deleteScrolling(Long id) {
        if(!scrollingRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Le noeud a supprimer n'existe pas. ");
        } else {
            int sum = 0;
            scrollingRepository.deleteById(id);
            while (scrollingRepository.existsById(id) && sum < 5) {
                try {
                    Thread.sleep(1000);
                    sum++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!scrollingRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Le noeud a ete supprime");
            } else {
                return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                        .body("La connexion avec le serveur n'a pas pu être établie correctement.");
            }
        }



    }

    @Override
    public Scrolling createIsolatedScrolling(Scrolling scrolling) {
        return scrollingRepository.save(scrolling);
    }
}