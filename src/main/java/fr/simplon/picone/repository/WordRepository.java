package fr.simplon.picone.repository;

import fr.simplon.picone.model.Word;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface WordRepository extends Neo4jRepository<Word, Long> {


    @Query("MATCH (w:Word)-[r]->(m:Word) WHERE id(w)= $id  AND type(r)= $relation return m")
    List<Word> findChildNodes(@Param("relation") String relation, @Param("id") Long id);

}
