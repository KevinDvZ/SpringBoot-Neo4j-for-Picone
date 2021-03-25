package fr.simplon.picone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.*;


@Node("Etablissement")
public class Establishment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String word;


    /*
    @Relationship(type="Résidant")
    private List<Patient> patients;
    */

    public Establishment() {
    }

    public Establishment(Long id, String name, String word) {
        this.id = id;
        this.name = name;
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
