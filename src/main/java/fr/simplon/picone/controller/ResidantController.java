package fr.simplon.picone.controller;

import fr.simplon.picone.Model.Patient;
import fr.simplon.picone.Model.Residant;
import fr.simplon.picone.repository.ResidantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/residant")

public class ResidantController {
    private ResidantRepository residantRepository;

    @Autowired
    public ResidantController (ResidantController){
        this.residantRepository = residantRepository;
    }



    @RequestMapping(method = RequestMethod.POST)
    public Patient create(@RequestBody Residant residant){
        return residantRepository.save(residant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Residant read(@PathVariable Long id) {
        return residantRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        residantRepository.deleteById(id);
    }
    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Residant update(@PathVariable Long id, @RequestBody Residant update) {
        final Residant existing = residantRepository.findById(id).orElseThrow(NotFoundException::new);
        existing.updateFrom(update);
        return residantRepository.save(existing);
    }
}
