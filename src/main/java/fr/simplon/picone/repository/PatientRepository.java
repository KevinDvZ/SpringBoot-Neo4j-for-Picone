package fr.simplon.picone.repository;

import fr.simplon.picone.model.Patient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface PatientRepository extends Neo4jRepository<Patient, Long> {

    @Query ("MATCH (n:admin) CREATE (m:patient{ (n)-[r:Patient]->lastName:'', name:'', email:'', password:'', image:''}) RETURN *")

    Patient returnAddPatient (Patient patient);

    @Query ("MATCH (n:patient) return n")
    List<Patient> returnPatientByPatient();
}