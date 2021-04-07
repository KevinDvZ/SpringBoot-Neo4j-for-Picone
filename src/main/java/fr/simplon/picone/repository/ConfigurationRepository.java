package fr.simplon.picone.repository;

import fr.simplon.picone.model.Configuration;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface ConfigurationRepository extends Neo4jRepository<Configuration, Long> {


}