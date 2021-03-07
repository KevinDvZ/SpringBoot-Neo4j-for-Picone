package fr.simplon.picone.repository;

import fr.simplon.picone.Model.Icone;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface DebutConversationRepository extends Neo4jRepository <Icone, Long> {

}
