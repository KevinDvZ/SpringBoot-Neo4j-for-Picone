package fr.simplon.picone.repository;

import fr.simplon.picone.model.Admin;
import fr.simplon.picone.model.Patient;
import fr.simplon.picone.model.Word;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface PatientRepository extends Neo4jRepository<Patient, Long> {


    @Query("CREATE (m:Patient{ lastName: :patientParam.lastName, firstName: :patientParam.firstName, email: :patientParam.email, password: :patientParam.password, image: :patientParam.image} )")
    Patient addPatient(@Param("patientParam")Patient patient);

    @Query("MATCH (n:Patient) where id(n)=$id return n")
    Patient findPatientById(Long id);

    @Query("START n = node({id}) OPTIONAL MATCH n-[r]-() DELETE n,r")
     void deletePatient(Long id);

    @Query ("updatePatient n set n.lastName = :lastName where n.id = :id")
    @Modifying
    public Long updateLastName(@Param("lastName")String lastName, @Param("id") Long id);

    //@Query("MATCH (w:Establishment)-[r]->(m:Patient) WHERE id(w)= $id  AND type(r)= $relation return m")
    //List<Admin> findChildNodes(@Param("relation") String relation, @Param("id") Long id);

}
