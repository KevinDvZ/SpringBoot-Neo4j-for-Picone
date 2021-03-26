package fr.simplon.picone.controller;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.service.EstablishmentService;
import fr.simplon.picone.service.EstablishmentServiceImpl;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.MonoExtensionsKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstablishmentController {

    @Autowired
    EstablishmentServiceImpl establishmentImpl;

    @GetMapping(value = "/establishment", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Establishment> returnAllEstablishment() {
        return establishmentImpl.returnAllEstablishment();
    }

    @GetMapping(value = "/establishment/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Establishment> returnEstablishment() {
        return establishmentImpl.returnEstablishmentByEstablishment();
    }

    @PostMapping(value = "/addEstablishment", produces = MediaType.APPLICATION_JSON_VALUE)
    public Establishment returnAddEstablishment(@RequestBody Establishment establishment) {
        return establishmentImpl.returnAddEstablishmentByEstablishment(establishment);
    }

    @DeleteMapping(value = "/deleteEstablishment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void returnDeleteEstablishment(@PathVariable(value = "id") long id) {
        establishmentImpl.deleteEstablishment(id);
    }

    @PutMapping(value ="/updateEstablishment/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Establishment UpdateEstablishment(@RequestBody Establishment establishment) {
        return establishmentImpl.returnUpdateEstablishmentByEstablishment(establishment);

}
    }






