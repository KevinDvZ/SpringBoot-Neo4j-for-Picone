package fr.simplon.picone.service;


import fr.simplon.picone.model.UiParameter;
import fr.simplon.picone.repository.UiParameterRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UiParameterService {



    UiParameter findDefaultUiParameterByPatientId(Long id);

    List<UiParameter> getAllUiParameters();

    UiParameter setUiParameterById(Long id, UiParameter uiParameter);

    ResponseEntity deleteParameterById(Long id);

    UiParameter createIsolatedUiParameter(UiParameter uiParameter);

    void deleteAll();

    void saveAll(List<UiParameter> testSaveUiParameterMethod);

    List<UiParameter> findAll();

    UiParameter createRelationBetweenPatientAndUiParam(Long patientIdToAnalyze, Long UiParamToBindId);

    UiParameterRepository getInjectedBean();
}
