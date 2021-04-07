package fr.simplon.picone.repository;

import fr.simplon.picone.model.Scrolling;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScrollingRepository extends Neo4jRepository<Scrolling, Long> {

    @Query("MATCH (m:Patient)-[:sauvegarde]->(n:Scrolling) where n.byDefault=true AND id(m)= $id return n")
    Scrolling findDefaultScrollingByPatientId(@Param("id") Long id);
}