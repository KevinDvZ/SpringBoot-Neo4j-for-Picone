package fr.simplon.picone.model;



import org.springframework.data.neo4j.core.schema.*;

import java.util.Set;


@Node ("Establishment")
public class Establishment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    private String address;
    private String postalCode;
    private String city;
    private String phone;
    private String word;

    @Relationship(type = "liste", direction = Relationship.Direction.OUTGOING)
    private Set<Patient> patients;


    public Establishment() {
    }

    public Establishment(Long id, String name, String email,String address, String postalCode,
    String city, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;

        this.address=address;
        this.postalCode=postalCode;
        this.city=city;
        this.phone=phone;

    }


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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
