package fr.simplon.picone.service;


import fr.simplon.picone.model.Scrolling;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ScrollingService {

    Scrolling findDefaultScrollingByPatientId(Long id);

    List<Scrolling> getAllScrollings();

    Optional<Scrolling> findScrollingById(Long id, Scrolling scrolling);

        ResponseEntity deleteScrolling(Long id);

    Scrolling createIsolatedScrolling(Scrolling scrolling);
}
