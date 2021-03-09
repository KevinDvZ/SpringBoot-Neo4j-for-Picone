package fr.simplon.picone.repository;

import fr.simplon.picone.Model.Mot;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface MotRepository extends Neo4jRepository<Mot, Long> {


    @Query("MATCH (w:Word)-[:affiche]->(m:Word) WHERE id(w)= $id return m")
   List<Mot> trouverNoeudsEnfants(@Param("id") Long id);


    //Mot findById(Long id);
}
