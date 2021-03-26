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





    /*@Query("MATCH m:Establishment { name:'', password:'', address:'', postalCode:'', city:'',phone:''})
            SET m.name:''= name('') and m.password:''and m.address:''and m.postalCode:''and m.city:''and m.phone:''

    public void putEstablishment(@Param("id") Long id);


}  MATCH (p:Person {name: 'Jennifer'})
        SET p.birthdate = date('1980-01-01')
        RETURN p*/
}