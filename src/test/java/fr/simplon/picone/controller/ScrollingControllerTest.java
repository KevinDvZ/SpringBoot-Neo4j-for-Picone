package fr.simplon.picone.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.picone.model.Scrolling;
import fr.simplon.picone.service.ScrollingService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.neo4j.AutoConfigureDataNeo4j;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JsonContent;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureDataNeo4j /* The @AutoConfigureDataNeo4j annotation is used instead of @DataNeo4jTest because both
                           @DataNeo4jTest and @WebMvcTest set @BootstrapWith annotation and having two @BootstrapWith
                           annotations in a test class is not supported. */
@ExtendWith(SpringExtension.class)
@WebMvcTest(ScrollingController.class)
public class ScrollingControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScrollingService service;


    @DisplayName("Scrolling list")
    @Test
    public void getAllScrollingsTest() throws Exception {

        //GIVEN

        //WHEN
        mockMvc.perform(get("/scrollings"))


                //THEN le statut de la réponse http est OK.
                .andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));

    }

    @DisplayName("get Default Scrolling for user")
    @Test
    public void getDefaultScrollingByBody() throws Exception {
        //GIVEN

        ObjectMapper mapper = new ObjectMapper();
        // body request
        String json = mapper.writeValueAsString(new Scrolling(33L, true,true, 100L,"bec8a3"));
       // request param
        String get = "";

        // simule le comportement de l'id en BDD Neo4j
        Scrolling scrollingOut =new Scrolling(true,true, 100L,"bec8a3");
        scrollingOut.setId(33L);
        when(service.findDefaultScrollingByPatientId(isA(Long.class))).thenReturn(scrollingOut);

        //WHEN

        mockMvc.perform(post("/scrollings").param("get",get).content(json).contentType(MediaType.APPLICATION_JSON))

        //THEN le statut de la réponse http est OK.
        .andExpect(status().isOk())
                // retour en Json
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));



    }


}
