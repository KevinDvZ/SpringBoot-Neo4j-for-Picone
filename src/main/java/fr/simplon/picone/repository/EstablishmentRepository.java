package fr.simplon.picone.repository;

import fr.simplon.picone.model.Establishment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface EstablishmentRepository extends Neo4jRepository<Establishment, Long> {

    @Query("MATCH (n:Etablissement)-[:Résidant]->(m:Patient) RETURN n")
    List<Establishment> returnPatientByEtablissement();


}
