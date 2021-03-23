package fr.simplon.picone.repository;

import fr.simplon.picone.model.Patient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface PatientRepository extends Neo4jRepository<Patient, Long> {


    @Query("MATCH (w:Establishment)-[r]->(m:Patient) WHERE id(w)= $id  AND type(r)= $relation return m")
    List<Patient> findChildNodes(@Param("relation") String relation, @Param("id") Long id);

}