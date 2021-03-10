package fr.simplon.picone.Model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;
import lombok.Getter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;



    @Getter

    @JsonIdentityInfo(generator = JSOGGenerator.class)
    @NodeEntity(label= "Residant")
    public class Residant {
    @Id
        private Long id;

        private String name;

        @Relationship(type = "Etablissement", direction = Relationship.INCOMING)
        private Etablissement etablissement;

        @Relationship(type = "Patient", direction = Relationship.OUTGOING)
        private Patient patient;
    }


