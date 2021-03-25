package fr.simplon.picone.repository;

import fr.simplon.picone.model.Mood;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface MoodRepository extends Neo4jRepository<Mood, Long> {
}