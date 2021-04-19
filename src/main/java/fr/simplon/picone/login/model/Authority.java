//package fr.simplon.picone.login.model;
//
//import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
//import org.neo4j.ogm.annotation.typeconversion.EnumString;
//import org.springframework.data.neo4j.core.schema.GeneratedValue;
//import org.springframework.data.neo4j.core.schema.Id;
//import org.springframework.data.neo4j.core.schema.Node;
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.management.relation.Role;
//import javax.persistence.Enumerated;
//
//
//@Node("Authority")
//public class Authority implements GrantedAuthority {
//
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//   @Enumerated
//    private Role authority;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    @Override
//    public String getAuthority() {
//        return authority.getRoleName();
//    }
//
////    public void setAuthority(Role authority) {
////        this.authority = authority;
////    }
//}
