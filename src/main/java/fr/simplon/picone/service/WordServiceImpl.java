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
    public List<Word> findAllIcons() {
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

    @Override
    public Word addIcon(Word word) {
        return wordRepository.save(word);
    }

    @Override
    public Word addIconWithRelation(Word word, Long idWord) throws InterruptedException {
        Word response = wordRepository.save(word);
        Thread.sleep(500);
        wordRepository.createIconRelation(idWord, response.getId());
        return response;
    }

    @Override
    public void deleteIconAndHisRelationship(Long id) {
        wordRepository.deleteById(id);
    }

    /*@Override
    public Word addIconWithCreatedRelation(Word word, Long idWord) throws InterruptedException{
        Word response = wordRepository.save(word);
        Thread.sleep(500);
        wordRepository.createIconRelation(idWord, response.getId());
        return response;
    }*/


}
