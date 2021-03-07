package fr.simplon.picone.Model;

public class Affiche {


    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;

    @Relationship(type = "Affiche", direction = Relationship.INCOMING)
    private ReportRelationShip reportRelationShip;
    @Relationship(type = "Belong")
    private Entity entity;


}

}
