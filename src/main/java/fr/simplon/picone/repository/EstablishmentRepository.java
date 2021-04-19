package fr.simplon.picone.repository;

import fr.simplon.picone.model.Establishment;
import fr.simplon.picone.model.Patient;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EstablishmentRepository extends Neo4jRepository<Establishment, Long> {


    //@Query(" CREATE (m:establishment{ name: :, address:'', postalCode:'', city:'',phone:'')<-[r:Establissment]-(n) RETURN *")
    //Establishment returnAddEstablishmentByEstablishment(Establishment establishment);

    @Query("CREATE (m:establishment { name: :establishmentParam.name, address: :establishmentParam.address, city: :establishmentParam.city, city, phone: :establishmentParam.phone, phone} )")
    Establishment returnAddEstablishmentByEstablishment(@Param("establishmentParam")Establishment establishment);

  // @Query("MATCH (n:establishment) return n")
   //List<Establishment> returnEstablishmentByEstablishment();

    @Query("START u = node({id}) OPTIONAL MATCH u-[r]-() DELETE u,r")
    public void deleteEstablishment(Long id);

    @Query("update Establishment p set p.name = :name where p.id = :id")
    @Modifying
    public Long updateName(@Param("name")String name, @Param("id") Long id);

    @Query("MATCH (n:Establishment) WHERE id(n)=$id return n")
    Establishment findEstablishmentById(Long id);

    //create relationship listew

    @Query("MATCH (n) WHERE id(n)=$id1 MATCH (m) WHERE id(m)=$id2 CREATE (n)-[r:liste]->(m)" )
    public Establishment createPatientRelation (Long id1, Long id2);



}