package fr.simplon.picone.model;



import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.*;


@Node ("Establishment")
public class Establishment {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String password;
    private String address;
    private String postalCode;
    private String city;
    private String phone;
    private String word;

   /* @RelatedTo(direction=Direction.BOTH, type="liste")
    private Set<Patient> patients;

    @Relationship(type="liste")
    private List<Establishment> establishments;
    */

    public Establishment() {
    }

    public Establishment(Long id, String name, String email,String password,String address, String postalCode,
    String city, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password=password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
