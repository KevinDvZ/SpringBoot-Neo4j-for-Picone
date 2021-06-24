package fr.simplon.picone.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node("UiParameter")
public class UiParameter {

    @Id
    @GeneratedValue
    private Long id;

    private Boolean byDefault;

    private Boolean scrollingIsActive;
    private Long scrollingSpeed;
    private String scrollingColor;


    public UiParameter(Long id, Boolean byDefault, Boolean scrollingIsActive, Long scrollingSpeed, String scrollingColor) {
        this.id = id;
        this.byDefault = byDefault;
        this.scrollingIsActive = scrollingIsActive;
        this.scrollingSpeed = scrollingSpeed;
        this.scrollingColor = scrollingColor;
    }

    public UiParameter(Boolean byDefault, Boolean scrollingIsActive, Long scrollingSpeed, String scrollingColor) {
        this.byDefault = byDefault;
        this.scrollingIsActive = scrollingIsActive;
        this.scrollingSpeed = scrollingSpeed;
        this.scrollingColor = scrollingColor;
    }

    public UiParameter() {
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

    public Boolean getScrollingIsActive() {
        return scrollingIsActive;
    }

    public void setScrollingIsActive(Boolean scrollingIsActive) {
        this.scrollingIsActive = scrollingIsActive;
    }

    public Long getScrollingSpeed() {
        return scrollingSpeed;
    }

    public void setScrollingSpeed(Long scrollingSpeed) {
        this.scrollingSpeed = scrollingSpeed;
    }

    public String getScrollingColor() {
        return scrollingColor;
    }

    public void setScrollingColor(String scrollingColor) {
        this.scrollingColor = scrollingColor;
    }
}