package com.sparta.rashawn.frameworkTests;

import framework.dtos.SpeciesDTO;
import framework.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SpeciesDTOTest {

    private static SpeciesDTO speciesDTO;

    @BeforeAll
    static void setup(){
        speciesDTO = (SpeciesDTO) Injector.generateDTO("https://swapi.dev/api/species/2/");
    }

    @Test
    void canGetSpecies(){
        Assertions.assertTrue(speciesDTO!=null);

    }

    @Test
    void canGetAverageHeight(){
        Assertions.assertEquals(speciesDTO.getAverage_height(), speciesDTO.getResponse().jsonPath().get("average_height"));

    }

    @Test
    void canGetAverageLifespan(){
        Assertions.assertEquals(speciesDTO.getAverage_lifespan(), speciesDTO.getResponse().jsonPath().get("average_lifespan"));

    }

    @Test
    void canGetPeople(){
        ArrayList<String> test = speciesDTO.getResponse().jsonPath().get("people");


        Assertions.assertEquals(speciesDTO.getPeople().toString(),test.toString());
    }

}
