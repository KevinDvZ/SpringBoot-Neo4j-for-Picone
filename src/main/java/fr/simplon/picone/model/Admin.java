package fr.simplon.picone.model;



import org.springframework.data.neo4j.core.schema.*;




public class Admin{
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getPassword() {
                return password;
        }

        public void setPassword(String password) {
                this.password = password;
        }

        @Id
        @GeneratedValue
        private Long id;

        private String name;
        private String email;
        private String password;


        /*@Relationship(type="ajoute")
        private List<Admin> admins ;*/
        }



