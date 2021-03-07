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

        @Relationship(type = "Contient", direction = Relationship.OUTGOING)
        private ReportRelationShip reportRelationShip;
        @Relationship(type = "Belong")
        private Entity entity;


}
