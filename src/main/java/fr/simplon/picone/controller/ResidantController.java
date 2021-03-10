package fr.simplon.picone.controller;

import fr.simplon.picone.Model.Patient;
import fr.simplon.picone.Model.Residant;
import fr.simplon.picone.repository.ResidantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/residant")

public class ResidantController {
    private ResidantRepository residantRepository;

    @Autowired
    public ResidantController (ResidantRepository residantRepository){
        this.residantRepository = residantRepository;
    }

    @RequestMapping (method = RequestMethod.GET)
    public Iterable<Residant> readAll() {
        return residantRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Residant create(@RequestBody Residant residant){
        return residantRepository.save(residant);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Residant> read(@PathVariable Long id) {
        return residantRepository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        residantRepository.deleteById(id);
    }
    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Residant update(@PathVariable Long id, @RequestBody Residant update) {
        final Optional<Residant> existing = residantRepository.findById(id);

        return residantRepository.save(existing.get());
    }
}
