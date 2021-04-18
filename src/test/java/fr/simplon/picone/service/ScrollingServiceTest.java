package fr.simplon.picone.service;

import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.repository.PatientRepository;
import fr.simplon.picone.repository.ScrollingRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.neo4j.ogm.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

@DataNeo4jTest
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
    private ScrollingRepository testScrollingRepository;

    @Qualifier("ScrollingService")
    @Autowired
    private ScrollingService testScrollingService;

    @Qualifier("ScrollingServiceImpl")
    @Autowired
    private ScrollingService testScrollingServiceImpl;

    @AfterEach
    public void clear() {
        mockPatientRepository.deleteAll();
        testScrollingService.deleteAll();
        System.out.println("Repos flushed.");
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

        Patient patient = testSaveOnePatientMethod();
        mockPatientRepository.save(patient);
        testScrollingRepository.saveAll(testSaveScrollingMethod());

        //WHEN
        final Patient patientToAnalyze = mockPatientRepository.findAll().get(0);
        final Long patientIdToAnalyze = patientToAnalyze.getId();
        final Scrolling scrollingToBind = testScrollingRepository.findAll().get(0);
        final Long scrollingToBindId = scrollingToBind.getId();
        testScrollingRepository.createRelationBetweenPatientScrolling(patientIdToAnalyze,scrollingToBindId );


        final Scrolling scrollingToFind = new Scrolling( true, true, 100L, "bec8a3");
        scrollingToFind.setId(scrollingToBindId);

        //THEN
        assertThat( testScrollingService.findDefaultScrollingByPatientId(patientIdToAnalyze), equalTo(scrollingToFind) );

    }
}
