package fr.simplon.picone.Model;


import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type = "affiche")
public class Affiche {


    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    Mot mot1;

    @EndNode
    Mot mot2;

    public Affiche() {

    }
}


