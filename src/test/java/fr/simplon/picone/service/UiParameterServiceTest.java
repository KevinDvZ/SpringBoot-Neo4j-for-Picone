package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.UiParameter;
import fr.simplon.picone.repository.PatientRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.neo4j.ogm.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
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

@SpringBootTest
//@DataNeo4jTest
@Transactional(propagation = Propagation.NEVER)
@Testcontainers
public class UiParameterServiceTest {
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
    static class Config {
        @Bean
        public Configuration configuration() {
            return new Configuration.Builder()
                    .uri(neo4jContainer.getBoltUrl())
                    .credentials(null, neo4jContainer.getAdminPassword())
                    .build();

        }
    }


    @Autowired
    private PatientRepository mockPatientRepository;

    @Autowired
    private UiParameterService testUiParameterService;


    @AfterEach
    public void clear() {
        mockPatientRepository.deleteAll();
        testUiParameterService.deleteAll();
        System.out.println("Repos flushed.");
    }

    @AfterAll
    static void stopEmbeddedDatabaseServer() {
        neo4jContainer.close();
    }


    public List<UiParameter> testSaveUiParameterMethod() {

        List<UiParameter> inputUiParameter = new ArrayList<>();
        inputUiParameter.add(new UiParameter(33L, true, true, 100L, "bec8a3"));
        inputUiParameter.add(new UiParameter(34L, false, false, 250L, "829b4f"));
        inputUiParameter.add(new UiParameter(35L, false, false, 850L, "a0c2ba"));

        return inputUiParameter;

    }

    public Patient testSaveOnePatientMethod() {
        return new Patient("Thierry", "Beccarro", "thierrry.gerard@tvmail.com", "FR2", "haha.png");
    }

    public List<Patient> testSaveSeveralPatientMehods() {
        List<Patient> inputPatients = new ArrayList<>();
        inputPatients.add(new Patient("Thierry", "Beccarro", "thierrry.gerard@tvmail.com", "FR2", "haha.png"));

        return inputPatients;
    }


    @DisplayName("Find default UiParam for a Patient")
    @Test
    public void findDefaultUiParamByPatientIdTest() {

        //GIVEN

        mockPatientRepository.save(testSaveOnePatientMethod());
        testUiParameterService.saveAll(testSaveUiParameterMethod());

        //WHEN
        final Patient patientToAnalyze = mockPatientRepository.findAll().get(0);
        final Long patientIdToAnalyze = patientToAnalyze.getId();
        final UiParameter uiParameterToBind = testUiParameterService.findAll().get(0);
        final Long uiParameterToBindId = uiParameterToBind.getId();
        testUiParameterService.createRelationBetweenPatientAndUiParam(patientIdToAnalyze, uiParameterToBindId);


        final UiParameter uiParameterToFind = new UiParameter(true, true, 100L, "bec8a3");
        uiParameterToFind.setId(uiParameterToBindId);

        //THEN
        assertThat(testUiParameterService.findDefaultUiParameterByPatientId(patientIdToAnalyze).getId(), equalTo(uiParameterToFind.getId()));

    }

    @DisplayName("Get every Ui Param in repository")
    @Test
    public void getAllUiParam(){

       //GIVEN

       List<UiParameter> inputUiParameter = testSaveUiParameterMethod();

        //WHEN

        mockPatientRepository.save(testSaveOnePatientMethod());
        testUiParameterService.saveAll(testSaveUiParameterMethod());

        // THEN

        assertThat(inputUiParameter.size(), equalTo(testUiParameterService.findAll().size()));


    }

    @DisplayName("Edit UiParam by Id")
    @Test
    public void setUiParamById(){

        //GIVEN

        UiParameter givenUiParameter = new UiParameter(false, true, 500L, "#188e1c" );
        List<UiParameter> inputUiParameter = testSaveUiParameterMethod();
        mockPatientRepository.save(testSaveOnePatientMethod());
        testUiParameterService.saveAll(inputUiParameter);

        final UiParameter uiParameterToChange = testUiParameterService.findAll().get(0);
        final Long givenId = uiParameterToChange.getId();

        //WHEN

        UiParameter response = testUiParameterService.setUiParameterById(givenId, givenUiParameter);


        //THEN
        assertThat( response.getId(), equalTo(givenId));
        assertThat( response.getScrollingColor(), equalTo(givenUiParameter.getScrollingColor()));


    }

    @DisplayName("Delete Ui Param by Id")
    @Test
    public void deleteUiParamById(){

        //GIVEN

        List<UiParameter> inputUiParameter = testSaveUiParameterMethod();
        mockPatientRepository.save(testSaveOnePatientMethod());
        testUiParameterService.saveAll(inputUiParameter);

        final UiParameter uiParameterToDelete = testUiParameterService.findAll().get(0);
        final Long givenId = uiParameterToDelete.getId();

        //WHEN

        ResponseEntity response = testUiParameterService.deleteParameterById(givenId);


        //THEN
        assertThat( response.getBody(), equalTo("Le noeud a ete supprime"));
        assertThat( testUiParameterService.findAll().size() , equalTo(inputUiParameter.size()-1));


    }

    @DisplayName("Create isolated Ui Parameter")
    @Test
    public void createLonelyUiParam(){

        //GIVEN

        List<UiParameter> inputUiParameter = testSaveUiParameterMethod();
        mockPatientRepository.save(testSaveOnePatientMethod());
        testUiParameterService.saveAll(inputUiParameter);
        UiParameter givenUiParameter = new UiParameter(false, true, 500L, "#188e1c" );

        //WHEN
        testUiParameterService.createIsolatedUiParameter(givenUiParameter);

        //THEN
        assertThat(testUiParameterService.findAll().get(3).getScrollingColor(), equalTo(givenUiParameter.getScrollingColor()));

    }

    /*
    @DisplayName("Link a patient with a Ui Parameter")
    @Test
    public void createRelationBetweenPatientScrolling(){

    }
    */

}
