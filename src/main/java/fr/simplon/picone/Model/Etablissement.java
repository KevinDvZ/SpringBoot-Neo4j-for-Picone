package fr.simplon.picone.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Etablissement")
public class Etablissement {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String word;


    /*
    @Relationship(type="Résidant")
    private List<Patient> patients;
    */


}
