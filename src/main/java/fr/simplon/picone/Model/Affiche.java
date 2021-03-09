package fr.simplon.picone.Model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "affiche")
@AllArgsConstructor
@NoArgsConstructor
public class Affiche {


    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    Mot mot1;

    @EndNode
    Mot mot2;


}


