package fr.simplon.picone.repository;

import fr.simplon.picone.model.Admin;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AdminRepository extends Neo4jRepository<Admin, Long> {


    @Query("MATCH (w:Admin)-[r]->(m:Patient) WHERE id(w)= $id  AND type(r)= $relation return m")
    List<Admin> findChildNodes(@Param("relation") String relation, @Param("id") Long id);

    @Query("MATCH (n:Admin), (e:establishment) WHERE n.firstName = {0}.firstName AND e.name = {1} CREATE n-[:add_AN]->e return n,a,e")
    Admin addAdmin (Admin admin);

    @Query("MATCH (n:Admin) WHERE id(n)='' delete n")
    void delete(Long id);

}