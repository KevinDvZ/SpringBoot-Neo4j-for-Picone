package fr.simplon.picone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
//@EnableNeo4jRepositories(basePackages = "fr.simplon.picone")
public class PiconeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PiconeApplication.class, args);
	}

}
