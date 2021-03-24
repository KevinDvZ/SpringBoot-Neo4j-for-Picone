package fr.simplon.picone.repository;

import fr.simplon.picone.model.Establishment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface EstablishmentRepository extends Neo4jRepository<Establishment, Long> {

    @Query ("MATCH (n:admin) CREATE (m:establishment{ name:'', password:'', address:'', postalCode:'', city:'',phone:'')<-[r:Etablissment]-(n) RETURN *")

    Establishment returnAddEstablishmentByEstablishment (Establishment establishment);

    @Query ("MATCH (n:establishment) return n")
    List<Establishment> returnEstablishmentByEstablishment();


}
