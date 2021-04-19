//package fr.simplon.picone.login.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.data.neo4j.core.schema.GeneratedValue;
//import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.Node;
//
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Pattern;
//import java.time.LocalDateTime;
//import java.util.HashSet;
//import java.util.Set;
//
//@Node("User")
//public class AppUser {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//
//    @NotEmpty
//    private String name;
//
//    @JsonIgnore
//    private String password;
//
//    @NotEmpty
//    @Pattern(regexp = "^(\\w||\\.)+@\\w+\\.\\w+$")
//    private String email;
//
//    private LocalDateTime createdDate;
//    private Boolean active = false;
//
//    private Set<Authority> authorities = new HashSet<>();
//
//    public AppUser(Long id, String name, String password, String email) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//        this.email = email;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public Boolean getActive() {
//        return active;
//    }
//
//    public void setActive(Boolean active) {
//        this.active = active;
//    }
//
//    public Set<Authority> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(Set<Authority> authorities) {
//        this.authorities = authorities;
//    }
//}
