package fr.simplon.picone.controller;

import fr.simplon.picone.model.Word;
import fr.simplon.picone.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class WordController {

    @Autowired
    WordService wordService;

    @CrossOrigin("*")
    @GetMapping("/mots")
    public List<Word> findNodes(){ return wordService.findNodes();}

    @GetMapping(value = "/mots/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Word> findNodesById(@PathVariable Long id){
        return wordService.findNodesById(id);
    }

    @GetMapping(value = "/mots/{id}/next", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Word> findNodesByIdTest(@PathVariable Long id){
        return wordService.findByIdTest(id);
    }

}
