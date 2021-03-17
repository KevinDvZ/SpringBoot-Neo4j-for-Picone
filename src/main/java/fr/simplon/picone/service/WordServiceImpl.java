package fr.simplon.picone.service;

import fr.simplon.picone.model.Word;
import fr.simplon.picone.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {


    @Autowired
    private WordRepository wordRepository;

    @Override
    public List<Word> findNodes() {
        return wordRepository.findAll();
    }

    @Override
    public Optional<Word> findNodesById(Long id) {
        return wordRepository.findById(id);
    }

    @Override
    public List<Word> findByIdAndByRelation( Long id, String relation) {
        return wordRepository.findChildNodes(relation, id);
    }

}
