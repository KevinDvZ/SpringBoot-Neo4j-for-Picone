package fr.simplon.picone.Model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.INCOMING;
import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity
public class MotSuivant {

    @Id @GeneratedValue
    private Long id;

    private String word;


    @Relationship(type="affiche", direction = INCOMING)
    private List<Mot> motPrécedent = new ArrayList<>();

    public MotSuivant() {
      }

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

    public List<Mot> getMotPrécedent() {
        return motPrécedent;
    }

    public void setMotPrécedent(List<Mot> motPrécedent) {
        this.motPrécedent = motPrécedent;
    }
}
