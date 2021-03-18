package fr.simplon.picone.controller;

import fr.simplon.picone.model.Mood;
import fr.simplon.picone.service.MoodService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoodController {

    MoodService moodService;

    @CrossOrigin("*")
    @GetMapping("/mood")
    public List<Mood> findNodes() {
        return moodService.findNodes();
    }

}
