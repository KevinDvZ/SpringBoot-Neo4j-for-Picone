package fr.simplon.picone.repository;

import fr.simplon.picone.Model.Mot;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotRepository extends Neo4jRepository<Mot, Long> {

}
