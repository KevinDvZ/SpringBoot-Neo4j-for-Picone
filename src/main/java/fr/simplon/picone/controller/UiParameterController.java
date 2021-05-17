package fr.simplon.picone.controller;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.UiParameter;
import fr.simplon.picone.service.UiParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UiParameterController {

    @Autowired
    UiParameterService uiParameterService;


    @PostMapping(value="/uiparams/new")
    public UiParameter createIsolatedUiParam (@RequestBody UiParameter uiParameter){
        return uiParameterService.createIsolatedUiParameter(uiParameter);
    }


    @PostMapping(name="PostMappingWithParam", value = "/uiparam")
    public UiParameter getDefaultUiParameterForAPatient (@RequestBody Patient patient, @RequestParam(required = true) String get ){
        Long idPatient = patient.getId();
        return uiParameterService.findDefaultUiParameterByPatientId(idPatient);
    }

    @PostMapping(name="LinkUiParamToAPatient", value = "/uiparams")
    public UiParameter linkUiParameterToAPatient (@RequestBody Patient patient, @RequestParam(required = true) Long idParam ){
        Long idPatient = patient.getId();
        return uiParameterService.createRelationBetweenPatientAndUiParam(idPatient, idParam);
    }

    @GetMapping(value = "/uiparams")
    public List<UiParameter> getAllUiParameters ( ){
        return uiParameterService.getAllUiParameters();
    }


    @PutMapping("/uiparams/{id}")
    public UiParameter update(@PathVariable("id") Long id, @RequestBody UiParameter uiParameter) {
        return this.uiParameterService.setUiParameterById(id, uiParameter);

    }


    @DeleteMapping("/uiparams/{id}")
    public ResponseEntity deleteUiParameterById (@PathVariable(value = "id") Long id) {
        return uiParameterService.deleteParameterById(id);
    }
}
