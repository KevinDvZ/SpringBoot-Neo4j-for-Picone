package fr.simplon.picone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Patient{

        @Id
        @GeneratedValue
        private Long id;

        private String lastName;
        private String name;
        private String email;
        private String password;
        private String image;

        private String word;

        /*@Relationship(type="liste")
        private List<Patient> patients ;*/
        }



