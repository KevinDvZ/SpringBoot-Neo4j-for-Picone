package fr.simplon.picone.controller;

import fr.simplon.picone.Model.Mot;
import fr.simplon.picone.service.MotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MotController{

    @Autowired
    MotService motService;

    @CrossOrigin("*")
    @GetMapping("/mots")
    public List<Mot> findNodes(){ return motService.findNodes();}

    @GetMapping(value = "/mots/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Mot> findNodesById(@PathVariable Long id){
        return motService.findNodesById(id);
    }

    @GetMapping(value = "/mots/{id}/{relation}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Mot> findByIdAndByRelation(@PathVariable Long id,@PathVariable String relation){
        return motService.findByIdAndByRelation(id, relation);
    }

}
