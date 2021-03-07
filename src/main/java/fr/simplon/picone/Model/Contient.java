package fr.simplon.picone.Model;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Contient {

        @Id
        @GeneratedValue
        private Long id;
        private String title;
        private String description;

        @Relationship(type = "Contient", direction = Relationship.INCOMING)
        private ReportRelationShip reportRelationShip;
        @Relationship(type = "Contient")
        private Entity entity;


}
