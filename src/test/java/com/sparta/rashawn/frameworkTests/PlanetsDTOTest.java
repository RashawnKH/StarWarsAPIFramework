package com.sparta.rashawn.frameworkTests;

import framework.dtos.PlanetsDTO;
import framework.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PlanetsDTOTest {

    private static PlanetsDTO planetDTO;

    @BeforeAll
    @DisplayName("Creating a planet")
    static void setup(){
        planetDTO = (PlanetsDTO) Injector.generateDTO("https://swapi.dev/api/planets/3/");
    }


    @Test
    void canCreatePlanet(){
        Assertions.assertTrue(planetDTO!=null);

    }

    @Test
    void canGetName(){
        Assertions.assertEquals(planetDTO.getName(),planetDTO.getResponse().jsonPath().get("name"));
    }


    @Test
    void canGetRotationPeriod(){
        String rotation = planetDTO.getResponse().jsonPath().get("rotation_period");
        Assertions.assertEquals(String.valueOf(planetDTO.getRotation_period()), rotation);
    }


    @Test
    void canGetResidents(){
        ArrayList<String> residents = planetDTO.getResponse().jsonPath().get("residents");
        Assertions.assertEquals(planetDTO.getResidents().toString(),residents.toString());
    }







}
