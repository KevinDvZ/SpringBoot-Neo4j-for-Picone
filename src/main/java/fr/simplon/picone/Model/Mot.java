package fr.simplon.picone.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.ogm.annotation.Relationship.OUTGOING;

@NodeEntity
public class Mot {

    @Id
    private Long id;

    private String word;

    @Relationship(type="affiche", direction = OUTGOING)
    //@JsonIgnoreProperties("motsSuivants")
    private List<MotSuivant> motsSuivants = new ArrayList<>();

    public Mot() {
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

    public List<MotSuivant> getMotSuivant() {
        return motsSuivants;
    }

    public void setMotSuivant(List<MotSuivant> motSuivant) {
        this.motsSuivants = motSuivant;
    }
}
