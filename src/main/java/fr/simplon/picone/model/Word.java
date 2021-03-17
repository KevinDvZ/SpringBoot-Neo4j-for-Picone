package fr.simplon.picone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.neo4j.core.schema.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Word")
public class Word {

    @Id
    @GeneratedValue
    private Long id;

    
    private String word;

    @Property("img_url")
    private String imgUrl;

    /*
    @Relationship(type="affiche")
   private List<Mot> motsSuivants = new ArrayList<>();
*/


}
