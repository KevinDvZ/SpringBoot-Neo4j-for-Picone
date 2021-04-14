package fr.simplon.picone.controller;

import fr.simplon.picone.model.Word;
import fr.simplon.picone.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class WordController {

    @Autowired
    WordService wordService;

    //Get all icons.
    @CrossOrigin("*")
    @GetMapping("/mots")
    public List<Word> findAllIcons(){
        return wordService.findAllIcons();
    }

    //Get icon by his ID.
    @CrossOrigin("*")
    @GetMapping(value = "/mots/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Word> findNodesById(@PathVariable Long id){
        return wordService.findNodesById(id);
    }

    //Get icon(s) child by icon parent's ID and relationship.
    @CrossOrigin("*")
    @GetMapping(value = "/mots/{id}/{relation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Word> findNodesByIdAndRelation(@PathVariable Long id, @PathVariable String relation){
        return wordService.findByIdAndByRelation(id, relation);
    }

    //Add an icon.
    @CrossOrigin("*")
    @PostMapping(value = "/icon")
    public Word addIcon(@RequestBody Word word) {
        return wordService.addIcon(word);
    }

    //Add an icon and link it with another icon with a relationship.
    @CrossOrigin("*")
    @PostMapping(value = "/icon/relation")
    public Word addIconWithRelation(@RequestBody Word word, @RequestParam(required = true) Long idWord) throws InterruptedException {
        return wordService.addIconWithRelation(word, idWord);
    }

}
