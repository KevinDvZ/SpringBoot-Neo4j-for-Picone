package fr.simplon.picone.repository;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.UiParameter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.neo4j.ogm.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsEqual.equalToObject;

@DataNeo4jTest
@Transactional(propagation = Propagation.NEVER)
@Testcontainers
public class UiParameterRepositoryTest {

    @Container
    public static Neo4jContainer neo4jContainer = new Neo4jContainer("neo4j")
            .withAdminPassword("test");


    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.neo4j.uri", neo4jContainer::getBoltUrl);
        registry.add("spring.neo4j.authentication.username", () -> "neo4j");
        registry.add("spring.neo4j.authentication.password", neo4jContainer::getAdminPassword);
    }


    @TestConfiguration
    static class Config{
        @Bean
        public org.neo4j.ogm.config.Configuration configuration(){
            return new Configuration.Builder()
                    .uri(neo4jContainer.getBoltUrl())
                    .credentials( null , neo4jContainer.getAdminPassword())
                    .build();

        }
    }


    @Autowired
    private PatientRepository mockPatientRepository;

    @Autowired
    private UiParameterRepository testUiParameterRepository;

    @AfterEach
    public void clear(){
        mockPatientRepository.deleteAll();
        testUiParameterRepository.deleteAll();
        System.out.println("Repos flushed.");
    }

    @AfterAll
    static void stopEmbeddedDatabaseServer() {
        neo4jContainer.close();
    }


    public List<UiParameter> testSaveUiParamsMethod() {

        List<UiParameter> inputUiParameter = new ArrayList<>();
        inputUiParameter.add(new UiParameter(33L, true, true, 100L, "bec8a3"));
        inputUiParameter.add(new UiParameter(34L, false, false, 250L, "829b4f"));
        inputUiParameter.add(new UiParameter(35L, false, false, 850L, "a0c2ba"));

        return inputUiParameter;

    }

    public Patient testSaveOnePatientMethod() {
        return new Patient ( "Thierry","Beccarro","thierrry.becarro@tvmail.com","FR2","haha.png");
    }

    public List<Patient> testSaveSeveralPatientMehods() {
        List<Patient> inputPatients = new ArrayList<>();
        inputPatients.add( new Patient ( "Thierry","Beccarro","thierrry.becarro@tvmail.com","FR2","haha.png"));

        return inputPatients;
    }



    @DisplayName("Repository : findAll()")
    @Test
    public void SDNTest() {
        //GIVEN
        testUiParameterRepository.saveAll(testSaveUiParamsMethod());
        List<UiParameter> inputDATAS = testSaveUiParamsMethod();

        //THEN
        assertThat( inputDATAS.size(), equalToObject(testUiParameterRepository.findAll().size()) );
    }

    @DisplayName("Repository : find Default UiParam for a Patient")
    @Test
    public void repoMethodDefaultUiParamTest() {
        //GIVEN

        Patient patient = testSaveOnePatientMethod();
        mockPatientRepository.save(patient);
        testUiParameterRepository.saveAll(testSaveUiParamsMethod());

        //WHEN
        final Patient patientToAnalyze = mockPatientRepository.findAll().get(0);
        final Long patientIdToAnalyze = patientToAnalyze.getId();
        final UiParameter uiParameterToBind = testUiParameterRepository.findAll().get(0);
        final Long uiParameterToBindId = uiParameterToBind.getId();
        testUiParameterRepository.createRelationBetweenPatientUiParam(patientIdToAnalyze,uiParameterToBindId );


        final UiParameter uiParameterToFind = new UiParameter( true, true, 100L, "bec8a3");

        //THEN
       assertThat( testUiParameterRepository.findDefaultUiParamByPatientId(patientIdToAnalyze).getScrollingColor(), equalTo(uiParameterToFind.getScrollingColor()) );
    }

    @DisplayName("Repository : delete a UiParameter linked to a patient")
    @Test
    public void deleteUiParamTest() {
        //GIVEN

        testUiParameterRepository.saveAll(testSaveUiParamsMethod());
        mockPatientRepository.save(testSaveOnePatientMethod());

        final Patient patientToAnalyze = mockPatientRepository.findAll().get(0);
        final Long patientIdToAnalyze = patientToAnalyze.getId();
        final UiParameter uiParameterToBind = testUiParameterRepository.findAll().get(0);
        final Long scrollingToBindId = uiParameterToBind.getId();

        testUiParameterRepository.createRelationBetweenPatientUiParam(patientIdToAnalyze,scrollingToBindId );

        // WHEN

        testUiParameterRepository.deleteById(scrollingToBindId);


        //THEN
        assertThat( testUiParameterRepository.findAll().size(), equalTo(2));
    }





}