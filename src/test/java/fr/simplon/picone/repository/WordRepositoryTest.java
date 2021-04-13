package fr.simplon.picone.repository;

import fr.simplon.picone.model.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.DataNeo4jTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.repository.query.Param;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataNeo4jTest
public class WordRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private WordRepository repository;

    @DisplayName("Find next icon by relationship")
    @Test
    public void findChildNodes(@Param("relation") String relation, @Param("id") Long id) {

        //GIVEN
        Word wordBoire = new Word(66L, "Boire","boire.png");
        entityManager.persist(wordBoire);
        //String relation = "besoin_physiologique";

        //WHEN
        List<Word> foundWord = repository.findChildNodes("besoin_physiologique", 66L);

        //THEN
        assertThat(foundWord.size()).isEqualTo(1);

    }

}


