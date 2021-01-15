package com.sparta.rashawn.frameworkTests;

import framework.dtos.StarshipsDTO;
import framework.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class StarshipsDTOTest {

    private static StarshipsDTO starshipsDTO;

    @BeforeAll
    static void setup(){
        starshipsDTO = (StarshipsDTO) Injector.generateDTO("https://swapi.dev/api/starships/9/");
    }

    @Test
    void canGetStarShip(){
        Assertions.assertTrue(starshipsDTO!=null);
    }

    @Test
    void canGetMGLT(){
        Assertions.assertEquals(starshipsDTO.getMGLT(), starshipsDTO.getResponse().jsonPath().get("MGLT"));
    }


    @Test
    void canGetCargoCapacity(){
        String cargo = starshipsDTO.getResponse().jsonPath().get("cargo_capacity");
        Assertions.assertEquals(starshipsDTO.getCargo_capacity(), cargo);
    }

    @Test
    void canGetHyperDrive(){
        String hyperDrive = starshipsDTO.getResponse().jsonPath().get("hyperdrive_rating");
        Assertions.assertEquals(starshipsDTO.getHyperdrive_rating(), hyperDrive);
    }

    @Test
    void canGetPilots(){
        ArrayList<String> test = starshipsDTO.getResponse().jsonPath().get("pilots");
        Assertions.assertEquals(starshipsDTO.getPilots().toString(), test.toString());
    }

}
