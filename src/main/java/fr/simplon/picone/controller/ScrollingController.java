package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.service.ScrollingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScrollingController {

    @Autowired
    ScrollingService scrollingService;

    @CrossOrigin(origins = "*")
    @PostMapping(value="/scrollings/new")
    public Scrolling createIsolatedScrolling (@RequestBody Scrolling scrolling){
        return scrollingService.createIsolatedScrolling(scrolling);
    }

    @CrossOrigin(origins ="*")
    @PostMapping(name="PostMappingWithParam", value = "/scrollings")
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
    public Scrolling update(@PathVariable("id") Long id, @RequestBody Scrolling scrolling) {
        return this.scrollingService.setScrollingById(id, scrolling);

    }

    @DeleteMapping("scrollings/{id}")
    public ResponseEntity deleteScrolling (@PathVariable(value = "id") Long id) {
        return scrollingService.deleteScrolling(id);
    }
}
