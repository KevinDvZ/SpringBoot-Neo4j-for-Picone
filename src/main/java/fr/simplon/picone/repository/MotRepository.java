package fr.simplon.picone.repository;

import fr.simplon.picone.Model.Mot;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

public interface MotRepository extends Neo4jRepository<Mot, Long> {

}
