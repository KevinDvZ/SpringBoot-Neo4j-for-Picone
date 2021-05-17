package fr.simplon.picone.service;

import fr.simplon.picone.model.UiParameter;
import fr.simplon.picone.repository.UiParameterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UiParameterServiceImpl implements UiParameterService {

    private UiParameterRepository uiParameterRepository;

    @Autowired
    public void setInjectedBean(UiParameterRepository uiParameterRepository) {
        this.uiParameterRepository = uiParameterRepository;
    }

    public UiParameterRepository getInjectedBean() {
        return this.uiParameterRepository;
    }

    @Override
    public UiParameter findDefaultUiParameterByPatientId(Long id) {
        return uiParameterRepository.findDefaultUiParamByPatientId(id);
    }

    @Override
    public List<UiParameter> getAllUiParameters() {
        return uiParameterRepository.findAll();
    }

    @Override
    public UiParameter setUiParameterById(Long id, UiParameter uiParameter) {

        Optional<UiParameter> monScro = uiParameterRepository.findById(id)
                .map(p -> {
                    p.setByDefault(uiParameter.getByDefault());
                    p.setScrollingColor(uiParameter.getScrollingColor());
                    p.setScrollingSpeed(uiParameter.getScrollingSpeed());
                    p.setScrollingIsActive(uiParameter.getScrollingIsActive());
                    return p;
                });

        monScro.map(this.uiParameterRepository::save);
         Optional<UiParameter> optionalEntity = uiParameterRepository.findById(id);
         UiParameter uiParameterRes = optionalEntity.get();
         return uiParameterRes;
    }

    @Override
    public ResponseEntity deleteParameterById(Long id) {
        if(!uiParameterRepository.existsById(id)){
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Le noeud a supprimer n'existe pas. ");
        } else {
            int sum = 0;
            uiParameterRepository.deleteById(id);
            while (uiParameterRepository.existsById(id) && sum < 5) {
                try {
                    Thread.sleep(1000);
                    sum++;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!uiParameterRepository.existsById(id)) {
                return ResponseEntity.status(HttpStatus.OK)
                        .body("Le noeud a ete supprime");
            } else {
                return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT)
                        .body("La connexion avec le serveur n'a pas pu être établie correctement.");
            }
        }



    }

    @Override
    public UiParameter createIsolatedUiParameter(UiParameter uiParameter) {
        return uiParameterRepository.save(uiParameter);
    }

    @Override
    public void deleteAll() {
        uiParameterRepository.deleteAll();
    }

    @Override
    public void saveAll(List<UiParameter> listUiParameter) {
        uiParameterRepository.saveAll(listUiParameter);
    }

    @Override
    public List<UiParameter> findAll() {
        return uiParameterRepository.findAll();
    }

    @Override
    public UiParameter createRelationBetweenPatientAndUiParam(Long patientIdToAnalyze, Long UiParamToBindId) {
        return uiParameterRepository.createRelationBetweenPatientUiParam(patientIdToAnalyze, UiParamToBindId);
    }
}