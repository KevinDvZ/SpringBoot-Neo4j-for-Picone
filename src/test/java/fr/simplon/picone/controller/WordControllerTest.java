/*package fr.simplon.picone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.picone.model.Word;
import fr.simplon.picone.service.WordService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Tag("controller_word")
@WebMvcTest(controllers = WordController.class)
public class WordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordService service;

    @DisplayName("Word list")
    @Test
    public void findNodes() throws Exception {
        //GIVEN

        //WHEN
        mockMvc.perform(get("/mots"))


        //THEN le statut de la réponse http est OK.
                .andExpect(status().isOk());
    }

    @DisplayName("get one word")
    @Test
    public void findNodesById() throws Exception {

        //GIVEN
        Long idWord = 14;
        Optional<Word> word = Optional.of(new Word(14, "T-Shirt", "tShirt.png"));
        word.get().setId(idWord);
        when(service.findNodesById(idWord)).thenReturn(word);

        //WHEN
        mockMvc.perform(get("/mots/{id}", idWord))

                //Pour que les tests affiche le résultat de la requête dans le log.
                .andDo(print())

                //THEN le statut de la réponse http est OK.
                .andExpect(status().isOk())

                //THEN le type de contenu est json.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                //THEN existence d'une réponse json.
                .andExpect(jsonPath("$").exists())

                //THEN l'attribut "id" a pour valeur 14
                .andExpect(jsonPath("$.id").value("14"))

                //THEN l'attribut "word" a pour valeur "T-Shirt"
                .andExpect(jsonPath("$.word").value("T-Shirt"))

                //THEN l'attribut "imgUrl" a pour valeur "tShirt.png"
                .andExpect(jsonPath("$.imgUrl").value("tShirt.png"));

    }*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//                       A MODIFIER UNE FOIS LES REQUETES CONTROLLER EFFECTUEES
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*    @DisplayName("Add word")
    @Test
    public void addWordTest() throws Exception {

        //GIVEN
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(new Word(200,"Castex","castex.png"));

        Word wordOut = new Word(200,"Castex","castex.png");
        wordOut.setId(1);
        when(service.insert(isA(Word.class))).thenReturn(wordOut);

        //WHEN
        mockMvc.perform(post("/mots")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))

                //Pour que les tests affiche le résultat de la requête dans le log.
               .andDo(print())

                //THEN statut de la réponse http est OK.
                .andExpect(status().isOk())

                //Assert le type de contenu de réponse.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                //THEN
                .andExpect(jsonPath("$").exists())

                //Assert la valeur de l'attribut "id" dans la réponse json.
                .andExpect(jsonPath("$.id").value("200"))

                //Assert la valeur de l'attribut "word" dans la réponse json.
                .andExpect(jsonPath("$.word").value("Castex"))

                //Assert la valeur de l'attribut "imgUrl" dans la réponse json.
                .andExpect(jsonPath("$.imgUrl").value("castex.png"));
    }

    @DisplayName("Update word")
    @Test
    public void updateWordTest() throws Exception {

        //GIVEN
        Long idWord = 14;
        Word word = new Word(14,"T-Shirt","tShirt.png");
        word.setId(idWord);
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(word);

        when(service.update(isA(Long.class), isA(Word.class))).thenReturn(word);

        //WHEN
        mockMvc.perform(put("/mots/{id}", idWord)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
        )

                //THEN statut de la réponse http est OK.
                .andExpect(status().isOk())

                //Assert le type de contenu de réponse.
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))

                //THEN
                .andExpect(jsonPath("$").exists())

                //Assert la valeur de l'attribut "id" dans la réponse json.
                .andExpect(jsonPath("$.id").value("14"))

                //Assert la valeur de l'attribut "word" dans la réponse json.
                .andExpect(jsonPath("$.word").value("T-Shirt"))

                //Assert la valeur de l'attribut "imgUrl" dans la réponse json.
                .andExpect(jsonPath("$.imgUrl").value("tShirt.png"));

    }

    @DisplayName("Delete word")
    @Test
    public void deleteWord() throws Exception {

        //GIVEN
        Long idWord = 14;
        Optional<Word> word = Optional.of(new Word(14,"T-Shirt","tShirt.png"));
        word.get().setId(idWord);
        when(service.findNodesById(idWord)).thenReturn(word);
        doNothing().when(service).delete(idWord);

        //WHEN
        mockMvc.perform(delete("/mots/{id}", idWord).accept(MediaType.APPLICATION_JSON))

                //THEN delete succesfull
                .andExpect(status().is2xxSuccessful());
    }*/

//}
