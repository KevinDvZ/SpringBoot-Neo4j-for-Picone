package fr.simplon.picone.service;


import fr.simplon.picone.model.Scrolling;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ScrollingService {



    Scrolling findDefaultScrollingByPatientId(Long id);

    List<Scrolling> getAllScrollings();

    Optional<Scrolling> findScrollingById(Long id, Scrolling scrolling);

    ResponseEntity deleteScrolling(Long id);

    Scrolling createIsolatedScrolling(Scrolling scrolling);

    void deleteAll();

    void saveAll(List<Scrolling> testSaveScrollingMethod);

    List<Scrolling> findAll();

    Scrolling createRelationBetweenPatientScrolling(Long patientIdToAnalyze, Long scrollingToBindId);
}
