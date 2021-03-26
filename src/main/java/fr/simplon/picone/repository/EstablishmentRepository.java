package fr.simplon.picone.repository;

import fr.simplon.picone.model.Establishment;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstablishmentRepository extends Neo4jRepository<Establishment, Long> {

    @Query("MATCH (n:admin) CREATE (m:establishment{ name:'', password:'', address:'', postalCode:'', city:'',phone:'')<-[r:Establissment]-(n) RETURN *")
    Establishment returnAddEstablishmentByEstablishment(Establishment establishment);

    @Query("MATCH (n:establishment) return n")
    List<Establishment> returnEstablishmentByEstablishment();

    @Query("START u = node({id}) OPTIONAL MATCH u-[r]-() DELETE u,r")
    public void deleteEstablishment(Long id);

    @Query("update Establishment p set p.name = :name where p.id = :id")
    @Modifying
    public Long updateName(@Param("name")String name, @Param("id") Long id);






}