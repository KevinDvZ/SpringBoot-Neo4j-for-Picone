package fr.simplon.picone.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
//import org.springframework.data.neo4j.core.schema.Id;


import java.util.ArrayList;
import java.util.List;



//@Node("Word")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NodeEntity(label = "Word")
public class Mot {

    @Id
    @GeneratedValue
    private Long id;

    private String word;

   // @Relationship(type="affiche")
    //@JsonIgnoreProperties("motsSuivants")
   // private List<MotSuivant> motsSuivants = new ArrayList<>();


}
