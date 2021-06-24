package fr.simplon.picone.repository;

import fr.simplon.picone.model.UiParameter;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface UiParameterRepository extends Neo4jRepository<UiParameter, Long> {

    @Query("MATCH (m:Patient)-[r:save]->(n:UiParameter) WHERE ID(m)= $idPatient return n ")
    UiParameter findDefaultUiParamByPatientId(Long idPatient);

    @Query("MATCH (m:Patient) WHERE ID(m)= $idPatient MATCH (n:UiParameter) where ID(n)= $idUiParam CREATE  (m)-[r:save]->(n) return n ")
    UiParameter createRelationBetweenPatientUiParam(@Param ("idPatient") Long idPatient, @Param ("idUiParam")  Long idUiParam);
}