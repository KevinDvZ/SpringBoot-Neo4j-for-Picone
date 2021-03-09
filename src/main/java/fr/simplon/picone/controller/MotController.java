package fr.simplon.picone.controller;

import fr.simplon.picone.Model.Mot;
import fr.simplon.picone.service.MotService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MotController{

    MotService motService;

    @CrossOrigin("*")
    @GetMapping("/mots")
    public List<Mot> findAll(){ return motService.findAll();}


}
