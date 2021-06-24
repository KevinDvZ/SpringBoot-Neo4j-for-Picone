package fr.simplon.picone.repository;

import fr.simplon.picone.model.Scrolling;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.hamcrest.MatcherAssert.assertThat;


@DataNeo4jTest
@Testcontainers
public class ScrollingRepositoryTest {

    @Container
    public static Neo4jContainer neo4jContainer = new Neo4jContainer("neo4j")
            .withAdminPassword(null);


    @DynamicPropertySource
    static void neo4jProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.data.neo4j.uri", neo4jContainer::getBoltUrl);
    }


    @Autowired
    private ScrollingRepository exampleRepository;

    public List<Scrolling> testSaveMethod() {

        List<Scrolling> inputScrolling = new ArrayList<>();
        inputScrolling.add(new Scrolling(33L, true, true, 100L, "bec8a3"));
        inputScrolling.add(new Scrolling(34L, false, false, 250L, "829b4f"));
        inputScrolling.add(new Scrolling(35L, false, false, 850L, "a0c2ba"));

        return inputScrolling;

    }


    @Test
    void testSomethingUsingBolt() {

        // Retrieve the Bolt URL from the container
        String boltUrl = neo4jContainer.getBoltUrl();
        try (
                Driver driver = GraphDatabase.driver(boltUrl, AuthTokens.none());
                Session session = driver.session()
        ) {
            long one = session.run("RETURN 1", Collections.emptyMap()).next().get(0).asLong();
            assertThat(this.one).isEqualTo(1L);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}