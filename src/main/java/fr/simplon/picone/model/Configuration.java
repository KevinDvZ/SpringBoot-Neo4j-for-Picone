package fr.simplon.picone.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node("Configuration")
public class Configuration {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean byDefault;
    private String name;

    @Relationship(type = "sauvegarde", direction = Relationship.Direction.OUTGOING)
    private List<Scrolling> scrolling;

    public Configuration() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Scrolling> getScrolling() {
        return scrolling;
    }

    public void setScrolling(List<Scrolling> scrolling) {
        this.scrolling = scrolling;
    }
}
