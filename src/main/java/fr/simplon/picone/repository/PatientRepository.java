package fr.simplon.picone.repository;

import fr.simplon.picone.model.Patient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


public interface PatientRepository extends Neo4jRepository<Patient, Long> {


    @Query("MATCH (n:admin) CREATE (m:patient{ lastName:'', name:'', email:'', password:'', image:''} )<-[r:Patient]-(n) RETURN *")
    Patient addPatient(Patient patient);

    @Query("MATCH (n:patient) return n")
    Patient findPatientById(Long id);

    @Query("START u = node({id}) OPTIONAL MATCH u-[r]-() DELETE u,r")
     void deletePatient(Long id);

    @Query ("updatePatient p set p.name = :name where p.id = :id")
    @Modifying
    public Long updateName(@Param("name")String name, @Param("id") Long id);

}