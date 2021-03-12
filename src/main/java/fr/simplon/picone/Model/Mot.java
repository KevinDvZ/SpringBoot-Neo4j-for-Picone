package fr.simplon.picone.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;



import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Node("Word")
public class Mot {

    @Id
    @GeneratedValue
    private Long id;

    
    private String word;


    /*
    @Relationship(type="affiche")
   private List<Mot> motsSuivants = new ArrayList<>();
*/


}
