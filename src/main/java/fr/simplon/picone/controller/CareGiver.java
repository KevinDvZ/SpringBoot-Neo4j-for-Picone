/*package fr.simplon.picone.controller;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.repository.EstablishmentRepository;
import fr.simplon.picone.service.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class CareGiver {


    @CrossOrigin(origins = "*")
    @RestController
    public class CareGiverController {

        @Autowired
        CareGiverService careGiverService;
        @Autowired
        CareGiverRepository careGiverRepository;

        @CrossOrigin(origins ="*")
        @GetMapping(value = "/careGivers", produces = MediaType.APPLICATION_JSON_VALUE)
        public List<CareGiver> returnAllCareGiver() {
            return careGiverService.returnAllCareGiver();
        }

        @CrossOrigin(origins ="*")
        @GetMapping(value = "/careGivers/{id}")
        public CareGiver findCareGiverById(@PathVariable(value = "id") Long id) {
            return careGiverService.findCareGiverById(id);
        }

        @CrossOrigin(origins ="*")
        @PostMapping(value = "/careGivers", produces = MediaType.APPLICATION_JSON_VALUE)
        public CareGiver returnAddCareGiver(@RequestBody CareGiver careGiver) {
            return careGiverService.returnAddCareGiverByCareGiver(careGiver);
        }
        @CrossOrigin(origins ="*")
        @DeleteMapping(value = "/careGivers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public void returnDeleteCareGiver(@PathVariable(value = "id") long id) {
            careGiverService.deleteCareGiver(id);
        }
        @CrossOrigin(origins ="*")
        @PutMapping(value ="/careGivers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        public CareGiver UpdateCareGiver(@RequestBody CareGiver careGiver) {
            return careGiverService.returnUpdateCareGiverByCareGiver(careGiver);

        }
        //create relationship a
        @CrossOrigin(origins ="*")
        @PostMapping(value = "/careGivers/{id1}/patients/{id2}")
        public CareGiver AddPatientInCareGiver(@PathVariable(value = "id1") Long idCareGiver ,@PathVariable(value = "id2") Long idPatient){
            return careGiverRepository.createPatientRelation(idCareGiver, idPatient);
        }



    }
}
*/


