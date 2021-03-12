package fr.simplon.picone.repository;

import fr.simplon.picone.Model.Etablissement;
import fr.simplon.picone.Model.Patient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface EtablissementRepository extends Neo4jRepository<Etablissement, Long> {

    @Query("MATCH (n:Etablissement)-[:Résidant]->(m:Patient) RETURN n")
    List<Etablissement> returnPatientByEtablissement();


}
