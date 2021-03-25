package fr.simplon.picone.controller;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstablishmentController {

    @Autowired
    EstablishmentService establishmentService;

    @GetMapping(value = "/establishment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Establishment> returnAllEstablishment() {
        return establishmentService.returnAllEstablishment();
    }

    @GetMapping(value = "/establishment/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Establishment> returnEstablishment() {
        return establishmentService.returnEstablishmentByEstablishment();
    }
@PostMapping( value= "/addEstablishment/",produces = MediaType.APPLICATION_JSON_VALUE )
public Establishment returnAddEstablishment(@RequestBody Establishment establishment) {
    return establishmentService.returnAddEstablishmentByEstablishment(establishment);
}

    @DeleteMapping Mapping(value= "/deleteEstablishment/", produces = MediaType.APPLICATION_JSON_VALUE )
    public Establishment returnDeleteEstablishment(@RequestBody Establishment establishment) {
        return establishmentService.returnDeleteEstablishmentByEstablishment(establishment);
    }




}


