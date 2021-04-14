package fr.simplon.picone.controller;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.model.Patient;
import fr.simplon.picone.repository.EstablishmentRepository;
import fr.simplon.picone.repository.PatientRepository;
import fr.simplon.picone.service.EstablishmentService;
import fr.simplon.picone.service.EstablishmentServiceImpl;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.Mono;
import org.neo4j.driver.internal.shaded.reactor.core.publisher.MonoExtensionsKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class EstablishmentController {
   
    @Autowired
    EstablishmentServiceImpl establishmentImpl;
    @Autowired
    EstablishmentRepository establishmentRepository;

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/establishments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Establishment> returnAllEstablishment() {
        return establishmentImpl.returnAllEstablishment();
    }

    @CrossOrigin(origins ="*")
    @GetMapping(value = "/establishments/{id}")
    public Establishment findEstablishmentById(@PathVariable(value = "id") Long id) {
        return establishmentImpl.findEstablishmentById(id);
    }

    @CrossOrigin(origins ="*")
    @PostMapping(value = "/establishments", produces = MediaType.APPLICATION_JSON_VALUE)
    public Establishment returnAddEstablishment(@RequestBody Establishment establishment) {
        return establishmentImpl.returnAddEstablishmentByEstablishment(establishment);
    }
    @CrossOrigin(origins ="*")
    @DeleteMapping(value = "/establishments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void returnDeleteEstablishment(@PathVariable(value = "id") long id) {
        establishmentImpl.deleteEstablishment(id);
    }
    @CrossOrigin(origins ="*")
    @PutMapping(value ="/establishments/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Establishment UpdateEstablishment(@RequestBody Establishment establishment) {
        return establishmentImpl.returnUpdateEstablishmentByEstablishment(establishment);

}
//create relationship liste
    @CrossOrigin(origins ="*")
    @PostMapping(value = "/establishments/{id1}/patients/{id2}")
    public Establishment AddPatientInEstablishment(@PathVariable(value = "id1") Long idEstablishment ,@PathVariable(value = "id2") Long idPatient){
      return establishmentRepository.createPatientRelation(idEstablishment, idPatient);
    }



    }






