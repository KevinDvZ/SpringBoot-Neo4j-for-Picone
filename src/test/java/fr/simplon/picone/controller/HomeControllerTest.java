package fr.simplon.picone.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.neo4j.core.Neo4jTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Tag("home_controller")
@WebMvcTest(controllers = HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Home test")
    @Test
    public void helloWorldTest() throws Exception {

        //GIVEN
        //Neo4jTemplate template = new Neo4jTemplate(graphDatabase);

        //WHEN
        mockMvc.perform(get("/"))

        //THEN le statut de la réponse http est OK.
        .andExpect(status().isOk());
    }
}
