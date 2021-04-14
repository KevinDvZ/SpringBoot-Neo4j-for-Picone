package fr.simplon.picone.repository;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Word;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface WordRepository extends Neo4jRepository<Word, Long> {


    @Query("MATCH (w:Word)-[r]->(m:Word) WHERE id(w)= $id  AND type(r)= $relation return m")
    List<Word> findChildNodes(@Param("relation") String relation, @Param("id") Long id);

    @Query("CREATE (m:Word{ word: :wordParam.word, img_url: :wordParam.imgUrl} )")
    Word addIcon(@Param("wordParam")Word word);

    //PROBLEME NOM RELATION =>
    @Query("MATCH (n) WHERE id(n)=$id1 MATCH (m) WHERE id(m)=$id2 CREATE (n)-[r:besoins_physiologiques]->(m)")
    Word createIconRelation(Long id1, Long id2);

}
