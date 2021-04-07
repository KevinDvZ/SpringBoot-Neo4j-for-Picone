package fr.simplon.picone.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.List;

@Node("Scrolling")
public class Scrolling {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean byDefault;
    private Boolean isActive;

    private Long defaultSpeed;
    private List<String> codeCouleur ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getByDefault() {
        return byDefault;
    }

    public void setByDefault(Boolean byDefault) {
        this.byDefault = byDefault;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getDefaultSpeed() {
        return defaultSpeed;
    }

    public void setDefaultSpeed(Long defaultSpeed) {
        this.defaultSpeed = defaultSpeed;
    }

    public List<String> getCodeCouleur() {
        return codeCouleur;
    }

    public void setCodeCouleur(List<String> codeCouleur) {
        this.codeCouleur = codeCouleur;
    }
}