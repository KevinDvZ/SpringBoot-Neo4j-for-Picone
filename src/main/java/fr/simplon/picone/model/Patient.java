package fr.simplon.picone.model;

import org.springframework.data.neo4j.core.schema.*;

@Node("Patient")
public class Patient{

        @Id
        @GeneratedValue
        private Long id;
        private String lastName;
        private String name;
        private String email;
        private String password;

        @Property("image")
        private String image;

        public Patient (Long id, String lastName, String name,  String email, String password, String image) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.email = email;
        this.password = password;
        this.image = image;

    }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
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

        public String getImage() {
                return image;
        }

        public void setImage(String image) {
                this.image = image;
        }

}



