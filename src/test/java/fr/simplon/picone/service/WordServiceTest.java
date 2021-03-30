package fr.simplon.picone.service;

import fr.simplon.picone.model.Word;
import fr.simplon.picone.repository.WordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WordServiceTest {

    @Mock
    WordRepository repository;

    @InjectMocks
    WordService service = new WordServiceImpl();

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }


/*  /////A TERMINER UNE FOIS QUE LA REQUETE POST SERA CREEE//////

    @DisplayName("find all icons")
    @Test
    public void findAllTest() {
        //GIVEN
        List<Word> inputWords = new ArrayList<>();

        //////A TERMINER UNE FOIS QUE LA REQUETE POST SERA CREEE//////
        inputWords.add(new Word("Gaston","mybio",5));
        inputWords.add(new Word("Marguerite","Il était une fois",3));
        inputWords.add(new Word("Marie","la petite maison",3));
        when(repository.findAll()).thenReturn(inputWords);

        //WHEN
        List<Word> outputWords = service.findAll("");

        //THEN
        assertThat(outputWords.size()).isEqualTo(3);

    }
    */

/*  //////A TERMINER UNE FOIS QU'UNE REQUETE GET BY NAME SERA CREEE//////

    @DisplayName("find all icons by name")
    @Test
    public void findAllIconsByNameTest() {

        //GIVEN
        List<Word> inputWords = new ArrayList<>();
        final String str = "Ma";
        inputWords.add(new Word("Marguerite","Il était une fois",3));
        inputWords.add(new Word("Marie","la petite maison",3));
        //////A TERMINER UNE FOIS QU'UNE REQUETE GET BY NAME SERA CREEE//////
        when(repository.findByNameContaining(str)).thenReturn(inputArtists);

        //WHEN
        List<Word> outputWords = service.findAll(str);

        //THEN
        assertThat(outputWords.size()).isEqualTo(2);

    }*/


    @DisplayName("find icon by id")
    @Test
    public void findByIdTest() {

        //GIVEN
        long idWord = 157;
        List<Word> inputWord = new ArrayList<>();
        String relation = "besoin_vestimentaire";
        inputWord.add(new Word(156L, "Chapeau", "chapeau.png"));
        inputWord.add(new Word(157L, "Gants", "gants.png"));
        inputWord.add(new Word(158L, "Bonnet", "bonnet.png"));
        when(repository.findChildNodes(relation, idWord)).thenReturn(inputWord);

        //WHEN
        List<Word> outputWord = service.findByIdAndByRelation(idWord,relation);


        //THEN
        assertThat(outputWord).hasSize(3);
        Word word = outputWord.get(1);
        assertThat(word.getWord()).isEqualTo("Gants");

    }


/*
    //////A TERMINER UNE FOIS QUE LA REQUETE POST SERA CREEE//////

    @DisplayName("insert icon")
    @Test
    public void insertTest() {

        //GIVEN
        Long idWord = 200;
        Word inputWord = new Word(200,"Castex","castex.png");
        Word outputWord = new Word(200,"Castex","castex.png");
        outputWord.setId(idWord);
        when(repository.save(inputWord)).thenReturn(outputWord);

        //WHEN
        outputWord = service.insert(inputWord);

        //THEN
        assertThat(outputWord.getId()).isEqualTo(idWord);
        assertThat(outputWord.getWord()).isEqualTo("Castex");

    }*/

/*
    //////A TERMINER UNE FOIS QUE LA REQUETE PUT SERA CREEE//////

    @DisplayName("update icon")
    @Test
    public void updateTest() {

        //GIVEN
        Long idWord = 14;
        Word word = new Word(14,"T-Shirt","tShirt.png");
        word.setId(idWord);
        when(repository.findById(idWord)).thenReturn(Optional.of(word));
        when(repository.save(word)).thenReturn(word);

        //WHEN
        //////A TERMINER UNE FOIS QUE LA REQUETE PUT SERA CREEE//////
        Word outputWord = service.update(idWord, word);

        //THEN
        assertThat(outputWord.getId()).isEqualTo(idWord);
        assertThat(outputWord.getWord()).isEqualTo("T-Shirt");

    }*/

}
