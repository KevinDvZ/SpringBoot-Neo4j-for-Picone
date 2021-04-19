//package fr.simplon.picone.login.repository;
//
//import fr.simplon.picone.login.model.AppUser;
//import org.springframework.data.neo4j.repository.Neo4jRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//public interface AppUserRepository extends Neo4jRepository <AppUser, Long> {
//
//    Optional <AppUser> findByUsername(String name);
//
//    List <AppUser> findByUsernameStartingWith(String name);
//
//    List <AppUser> findByEmailStartingWith(String email);
//
//    boolean existsByUsername(String name);
//}
