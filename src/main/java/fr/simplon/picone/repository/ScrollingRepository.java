package fr.simplon.picone.repository;

import fr.simplon.picone.model.Scrolling;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface ScrollingRepository extends Neo4jRepository<Scrolling, Long> {

    @Query("MATCH (m:Patient)-[r:save]->(n:Scrolling) WHERE ID(m)= $idPatient return n ")
    Scrolling findDefaultScrollingByPatientId(Long idPatient);

    @Query("MATCH (m:Patient) WHERE ID(m)= $idPatient MATCH (n:Scrolling) where ID(n)= $idScrolling CREATE  (m)-[r:save]->(n) return n ")
    Scrolling createRealtionBetweenPatientScrolling(@Param ("idPatient") Long idPatient, @Param ("idScrolling")  Long idScrolling);
}