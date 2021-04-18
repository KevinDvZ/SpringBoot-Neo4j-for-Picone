package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Scrolling;
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
public class ScrollingServiceTest {
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
    private ScrollingService testScrollingService;


    @AfterEach
    public void clear() {
        mockPatientRepository.deleteAll();
        testScrollingService.deleteAll();
        System.out.println("Repos flushed.");
    }

    @AfterAll
    static void stopEmbeddedDatabaseServer() {
        neo4jContainer.close();
    }


    public List<Scrolling> testSaveScrollingMethod() {

        List<Scrolling> inputScrolling = new ArrayList<>();
        inputScrolling.add(new Scrolling(33L, true, true, 100L, "bec8a3"));
        inputScrolling.add(new Scrolling(34L, false, false, 250L, "829b4f"));
        inputScrolling.add(new Scrolling(35L, false, false, 850L, "a0c2ba"));

        return inputScrolling;

    }

    public Patient testSaveOnePatientMethod() {
        return new Patient("Thierry", "Beccarro", "thierrry.gerard@tvmail.com", "FR2", "haha.png");
    }

    public List<Patient> testSaveSeveralPatientMehods() {
        List<Patient> inputPatients = new ArrayList<>();
        inputPatients.add(new Patient("Thierry", "Beccarro", "thierrry.gerard@tvmail.com", "FR2", "haha.png"));

        return inputPatients;
    }


    @DisplayName("Find default scrolling for a Patient")
    @Test
    public void findDefaultScrollingByPatientIdTest() {

        //GIVEN

        mockPatientRepository.save(testSaveOnePatientMethod());
        testScrollingService.saveAll(testSaveScrollingMethod());

        //WHEN
        final Patient patientToAnalyze = mockPatientRepository.findAll().get(0);
        final Long patientIdToAnalyze = patientToAnalyze.getId();
        final Scrolling scrollingToBind = testScrollingService.findAll().get(0);
        final Long scrollingToBindId = scrollingToBind.getId();
        testScrollingService.createRelationBetweenPatientScrolling(patientIdToAnalyze, scrollingToBindId);


        final Scrolling scrollingToFind = new Scrolling(true, true, 100L, "bec8a3");
        scrollingToFind.setId(scrollingToBindId);

        //THEN
        assertThat(testScrollingService.findDefaultScrollingByPatientId(patientIdToAnalyze).getId(), equalTo(scrollingToFind.getId()));

    }

    @DisplayName("Get every Scrollings in repository")
    @Test
    public void getAllScrollings(){

       //GIVEN

       List<Scrolling> inputScrolling = testSaveScrollingMethod();

        //WHEN

        mockPatientRepository.save(testSaveOnePatientMethod());
        testScrollingService.saveAll(testSaveScrollingMethod());

        // THEN

        assertThat(inputScrolling.size(), equalTo(testScrollingService.findAll().size()));


    }

    @DisplayName("Edit Scrolling by Id")
    @Test
    public void setScrollingById(){

        //GIVEN

        Scrolling givenScrolling = new Scrolling (false, true, 500L, "#188e1c" );
        List<Scrolling> inputScrolling = testSaveScrollingMethod();
        mockPatientRepository.save(testSaveOnePatientMethod());
        testScrollingService.saveAll(inputScrolling);

        final Scrolling scrollingToChange = testScrollingService.findAll().get(0);
        final Long givenId = scrollingToChange.getId();

        //WHEN

        Scrolling response = testScrollingService.setScrollingById(givenId,givenScrolling);


        //THEN
        assertThat( response.getId(), equalTo(givenId));
        assertThat( response.getCodeCouleur(), equalTo(givenScrolling.getCodeCouleur()));


    }

    @DisplayName("Delete Scrolling by Id")
    @Test
    public void deleteScrollingById(){

        //GIVEN

        List<Scrolling> inputScrolling = testSaveScrollingMethod();
        mockPatientRepository.save(testSaveOnePatientMethod());
        testScrollingService.saveAll(inputScrolling);

        final Scrolling scrollingToDelete = testScrollingService.findAll().get(0);
        final Long givenId = scrollingToDelete.getId();

        //WHEN

        ResponseEntity response = testScrollingService.deleteScrolling(givenId);


        //THEN
        assertThat( response.getBody(), equalTo("Le noeud a ete supprime"));
        assertThat( testScrollingService.findAll().size() , equalTo(inputScrolling.size()-1));


    }

    @DisplayName("Create isolated Scrolling")
    @Test
    public void createLonelyScrolling(){

        //GIVEN

        List<Scrolling> inputScrolling = testSaveScrollingMethod();
        mockPatientRepository.save(testSaveOnePatientMethod());
        testScrollingService.saveAll(inputScrolling);
        Scrolling givenScrolling = new Scrolling (false, true, 500L, "#188e1c" );

        //WHEN
        testScrollingService.createIsolatedScrolling(givenScrolling);

        //THEN
        assertThat(testScrollingService.findAll().get(3).getCodeCouleur(), equalTo(givenScrolling.getCodeCouleur()));

    }

    /*
    @DisplayName("Link a patient with a Scrolling")
    @Test
    public void createRelationBetweenPatientScrolling(){

    }
    */

}
