package com.sparta.rashawn.frameworkTests;

import framework.dtos.FilmsDTO;
import framework.injector.Injector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class FilmsDTOTest {

    private static FilmsDTO filmsDTO;

    @BeforeAll
    @DisplayName("Setting up FilmDTO object")
    static void setup(){
          filmsDTO = (FilmsDTO) Injector.generateDTO("https://swapi.dev/api/films/2/");
    }

    @Test
    void canCreateFilm(){
        Assertions.assertTrue(filmsDTO!=null);

    }

    @Test
    void canGetCharacters(){
        ArrayList<String> test = filmsDTO.getResponse().jsonPath().get("characters");

        Assertions.assertEquals(filmsDTO.getCharacters().toString(), test.toString());
    }

    @Test
    void canGetCreated(){
        Assertions.assertEquals(filmsDTO.getCreated(), filmsDTO.getResponse().jsonPath().get("created"));
    }

    @Test
    void canGetEpisodeID(){
        int ep_id = filmsDTO.getResponse().jsonPath().get("episode_id");
        Assertions.assertEquals(filmsDTO.getEpisode_id(),ep_id);
    }






}
