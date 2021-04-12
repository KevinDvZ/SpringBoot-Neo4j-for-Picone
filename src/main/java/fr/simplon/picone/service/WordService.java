package fr.simplon.picone.service;

import fr.simplon.picone.model.Word;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WordService {

    List<Word> findNodes();

    Optional<Word> findNodesById(Long id);

    List<Word> findByIdAndByRelation(Long id, String relation);

    Word addWord(Word word);

}
