package fr.simplon.picone.repository;

import fr.simplon.picone.model.Patient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;


public interface PatientRepository extends Neo4jRepository<Patient, Long> {


    @Query("CREATE (m:Patient{ lastName: :patientParam.lastName, firstName: :patientParam.firstName, email: :patientParam.email, password: :patientParam.password, image: :patientParam.image} )")
    Patient addPatient(@Param("patientParam")Patient patient);

    @Query("MATCH (n:Patient) where id(n)=$id return n")
    Optional<Patient> findPatientById(Long id);

    @Query("START n = node({id}) OPTIONAL MATCH n-[r]-() DELETE n,r")
     void deletePatient(Long id);

    @Query ("MATCH( n:Patient) WHERE id(n)=' ' SET n.firstName RETURN n")
    Patient updatePatient(@Param("id") Long id);

}
