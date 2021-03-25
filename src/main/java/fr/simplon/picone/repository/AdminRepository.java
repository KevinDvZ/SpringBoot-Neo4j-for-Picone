package fr.simplon.picone.repository;

import fr.simplon.picone.model.Admin;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface AdminRepository extends Neo4jRepository<Admin, Long> {


    @Query("MATCH (w:Admin)-[r]->(m:Patient) WHERE id(w)= $id  AND type(r)= $relation return m")
    List<Admin> findChildNodes(@Param("relation") String relation, @Param("id") Long id);

}