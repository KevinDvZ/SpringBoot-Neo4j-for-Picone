package fr.simplon.picone.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;
import java.util.Set;

@Node("Scrolling")
public class Scrolling {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean byDefault;
    private Boolean isActive;

    private Long defaultSpeed;
    private String codeCouleur ;

    @Relationship(type = "sauvegarde", direction = Relationship.Direction.INCOMING)
    private Set<Patient> patients;

    public Scrolling(Long id, Boolean byDefault, Boolean isActive, Long defaultSpeed, String codeCouleur) {
        this.id = id;
        this.byDefault = byDefault;
        this.isActive = isActive;
        this.defaultSpeed = defaultSpeed;
        this.codeCouleur = codeCouleur;
    }

    public Scrolling( Boolean byDefault, Boolean isActive, Long defaultSpeed, String codeCouleur) {
        this.byDefault = byDefault;
        this.isActive = isActive;
        this.defaultSpeed = defaultSpeed;
        this.codeCouleur = codeCouleur;
    }

    public Scrolling() {
    }

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

    public String getCodeCouleur() {
        return codeCouleur;
    }

    public void setCodeCouleur(String codeCouleur) {
        this.codeCouleur = codeCouleur;
    }
}