package fr.simplon.picone;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;


public class Neo4jSessionFactory {

    static Configuration configuration = new Configuration.Builder()
            .uri("bolt://niveaubonus.fr:7687")
            .build();

    static SessionFactory sessionFactory =
            new SessionFactory(configuration, "models");
    static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }

    private Neo4jSessionFactory() {}

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}