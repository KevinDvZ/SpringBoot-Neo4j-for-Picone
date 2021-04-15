package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.service.ScrollingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ScrollingController {

    @Autowired
    ScrollingService scrollingService;

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/scrollings")
    public Scrolling getDefaultScrollingForAPatient (@RequestBody Patient patient, @RequestParam(required = true) String get ){
        Long idPatient = patient.getId();
        return scrollingService.findDefaultScrollingByPatientId(idPatient);
    }

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/scrollings")
    public List<Scrolling> getAllScrollings ( ){
        return scrollingService.getAllScrollings();
    }

    @PutMapping("/scrollings/{id}")
    public Optional<Scrolling> update(@PathVariable("id") Long id, @RequestBody Scrolling scrolling) {
        return this.scrollingService.findScrollingById(id, scrolling);

    }

}
