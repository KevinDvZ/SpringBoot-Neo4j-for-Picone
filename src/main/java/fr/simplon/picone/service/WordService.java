package fr.simplon.picone.service;

import fr.simplon.picone.model.Word;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WordService {

    List<Word> findNodes();

    List<Word> findByIdTest(Long id);

    Optional<Word> findNodesById(Long id);

}
