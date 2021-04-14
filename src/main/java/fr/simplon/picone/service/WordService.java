package fr.simplon.picone.service;

import fr.simplon.picone.model.Word;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface WordService {

    List<Word> findAllIcons();

    Optional<Word> findNodesById(Long id);

    List<Word> findByIdAndByRelation(Long id, String relation);

    Word addIcon(Word word, Long idWord) throws InterruptedException;

    //Word addIconWithRelation(Word word, Long idWord) throws InterruptedException;

    //Word addIcon(Word word);

    //Word createIconRelation(Long id1, Long id2);

}
