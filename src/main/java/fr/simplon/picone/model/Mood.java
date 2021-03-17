package fr.simplon.picone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Mood")
public class Mood {

    @Id
    @GeneratedValue
    private Long id;

    private String word;

    @Property("img_url")
    private String imgUrl;

}
