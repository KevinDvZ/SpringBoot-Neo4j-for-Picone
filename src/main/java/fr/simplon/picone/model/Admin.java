package fr.simplon.picone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class Admin{

        @Id
        @GeneratedValue
        private Long id;

        private String name;
        private String email;
        private String password;


        /*@Relationship(type="ajoute")
        private List<Admin> admins ;*/
        }



