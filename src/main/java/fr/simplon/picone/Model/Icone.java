package fr.simplon.picone.Model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
public class Icone {

    @Id @GeneratedValue
    private Long id;
    private String word;

    @Relationship(type="affiche", direction= Relationship.INCOMING)
    private List<Icone> previousIcones;


    @Relationship(type="affiche", direction = Relationship.OUTGOING)
    private List<Icone> nextIcones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Icone> getNextIcones() {
        return nextIcones;
    }

    public void setNextIcones(List<Icone> nextIcones) {
        this.nextIcones = nextIcones;
    }
}
