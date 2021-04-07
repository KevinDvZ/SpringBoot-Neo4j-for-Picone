package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.service.ScrollingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

public class ScrollingController {

    @Autowired
    ScrollingService scrollingService;

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/scrolling")
    public Scrolling getDefaultScrollingForAPatient (@RequestBody Patient patient, @RequestParam String getDefault ){
        Long idPatient = patient.getId();
        return scrollingService.findDefaultScrollingByPatientId(idPatient);
    }
}
