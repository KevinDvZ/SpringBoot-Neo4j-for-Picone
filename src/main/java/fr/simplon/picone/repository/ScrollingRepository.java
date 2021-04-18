package fr.simplon.picone.repository;

import fr.simplon.picone.model.Scrolling;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface ScrollingRepository extends Neo4jRepository<Scrolling, Long> {

    @Query("MATCH (m:Patient)-[r:sauvegarde]->(n:Scrolling) where id(m)=$idPatient return n ")
    Scrolling findDefaultScrollingByPatientId(@Param("idPatient") Long id);

    @Query("MATCH (m:Patient) where id(m)=$idPatient MATCH (n:Scrolling) where id(n)= $idScrolling CREATE  (m)-[r:sauvegarde]->(n) return n ")
    Scrolling createRealtionBetweenPatientScrolling(@Param("idPatient") Long idPat, @Param("idScrolling") Long idScroll);
}