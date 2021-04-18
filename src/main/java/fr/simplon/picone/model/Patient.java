package fr.simplon.picone.model;

import org.springframework.data.neo4j.core.schema.*;

@Node("Patient")
public class Patient{

        @Id
        @GeneratedValue
        private Long id;
        private String lastName;
        private String firstName;
        private String email;
        private String password;

        @Property("image")
        private String image;

        public Patient (Long id, String lastName, String firstName,  String email, String password, String image) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.image = image;

    }

    public Patient() {
    }

    public Patient (String lastName, String firstName, String email, String password, String image) {

        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.image = image;

    }

        public Long getId() {
                return id;
        }

        public String getLastName() {
                return lastName;
        }

        public String getFirstName() { return firstName; }

        public String getEmail() { return email;}

        public String getPassword() { return password;}

        public String getImage() { return image; }


        public void setId(Long id) {this.id = id;}

        public void setFirstName(String firstName) { this.firstName = firstName; }

        public void setLastName(String lastName) { this.lastName = lastName;}

        public void setEmail(String email) { this.email = email;}

        public void setPassword(String password) { this.password = password;}

        public void setImage(String image) { this.image = image; }

}



