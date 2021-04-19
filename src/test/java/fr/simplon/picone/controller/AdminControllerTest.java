package fr.simplon.picone.controller;


import fr.simplon.picone.model.Admin;
import fr.simplon.picone.service.AdminService;
import fr.simplon.picone.service.AdminServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Tag("controller_admin")
@AutoConfigureDataNeo4j
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = AdminController.class)
public class AdminControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AdminServiceImpl adminService;

   @DisplayName("Find Admins")
   @Test
    public void findAdmins() throws Exception{
    //GIVEN

    //WHEN
       mockMvc.perform(get("/home/admins"))

       //THEN le status de la réponse
       .andExpect(status().isOk());
   }

   @DisplayName("Find Admin By Id")
   @Test
   public void findAdminById()throws Exception{
   long idAdmin = 1L;
    Optional<Admin> admin = Optional.of(new Admin(50L,"Jean", "Pierre","JeanP@jp.com","123","123"));
    admin.get().setId(idAdmin);
    when(adminService.findNodesById(idAdmin)).thenReturn(admin);

    //WHEN
    mockMvc.perform(get("/home/admin/{id}", idAdmin))
            .andDo(print()) //affiche le résultat de la requete dans le print

    //THEN le statut de la réponse http est OK
        .andExpect(status().isOk())

    //THEN le type de contenu est json
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

            //THEN existence d'une réponse json
       .andExpect(jsonPath("$").exists())

            //THEN l'attribut 'id' a pour valeur 1
       .andExpect(jsonPath("$.id").value("1"))

            //THEN l'attribut 'firstName' a pour valeur 'Jean'
       .andExpect(jsonPath("$.firstName").value("Jean"))

            //THEN l'attribut 'lastName' a pour valeur 'Pierre'
       .andExpect(jsonPath("$.lastName").value("Pierre"))

            //THEN l'attribut 'email' a pour valeur 'JeanP@jp.com'
       .andExpect(jsonPath("$.email").value("JeanP@jp.com"))

            //THEN l'attribut 'password' a pour valeur '123'
       .andExpect(jsonPath("$.password").value("123"))

            //THEN l'attribut 'confirmPassword' a pour valeur '123'
       .andExpect(jsonPath("$.confirmPassword").value("123"));

//            //THEN l'attribut 'fanNumber' a pour valeur 50
//       .andExpect(jsonPath("$.fanNumber").value("50"));

   }

   @DisplayName("Find idAdmin par relation")
   @Test
    public void findAdminByRelation() throws Exception {
       //WHEN

   }
}