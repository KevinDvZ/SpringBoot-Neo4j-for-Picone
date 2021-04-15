package fr.simplon.picone.repository;
import fr.simplon.picone.model.Scrolling;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@AutoConfigureDataNeo4j
public class ScrollingRepositoryTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ScrollingRepository scrollingRepository;


    @DisplayName("find default scrolling by patient Id")
    @Test
    public void  findDefaultScrollingByPatientIdTest() {
        //GIVEN
        long idScrolling = 34;
        List<Scrolling> inputScrolling = new ArrayList<>();
        inputScrolling.add(new Scrolling(33L, true, true, 100L, "bec8a3"));
        inputScrolling.add(new Scrolling(34L, false, false, 250L, "829b4f"));
        inputScrolling.add(new Scrolling(35L, false, false, 850L, "a0c2ba"));

        //WHEN
        List<Scrolling> scrollingEntities = entityManager.persist(inputScrolling);

        //THEN
        assertNotNull(scrollingEntities);


    }
}
