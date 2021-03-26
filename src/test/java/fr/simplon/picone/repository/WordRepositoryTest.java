package fr.simplon.picone.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataNeo4jTest
public class WordRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WordRepository repository;

    @DisplayName("Find icon by word")
    @Test
    public void findChildNodes() {

        //GIVEN
        Word wordSlip = new Word(15, "Slip","slip.png";
        entityManager.persist(wordSlip);
        Word wordMerci = new Word(64, "Merci","merci.png");
        entityManager.persist(wordMerci);

        //WHEN

        //METTRE UNE RELATION

        //List<Word> wordSelect = repository.findChildNodes("ul");

        //THEN
        assertThat(wordSelect.size()).isEqualTo(1);

    }

}
