package com.sparta.rashawn;

import framework.connectionmanager.ConnectionManager;
import framework.dtos.*;
import framework.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;

public class ExampleTests {


    private static PeopleDTO person;
    private static  ConnectionManager connectionManager;

    @BeforeAll
    @DisplayName("Setting up connection and personDTO")
    static void setup(){
        connectionManager = new ConnectionManager();
        connectionManager.connect("https://swapi.dev/api/people/1/");

        person = (PeopleDTO) Injector.generateDTO("https://swapi.dev/api/people/1/");
    }



    @Test
    @DisplayName("Testing the date is converted correctly")
    void checkConvertedDate(){
        Assertions.assertEquals(connectionManager.convertServerDateToLocalDate(), LocalDate.now());
    }

    @Test
    @DisplayName("Testing you can get the correct headers")
    void canGetHeaders(){
        HashMap<String,String> headers = connectionManager.getHeaders();
        for (String string: headers.keySet()) {
            Assertions.assertEquals(headers.get(string), connectionManager.getResponse().getHeader(string));
        }
    }

    @Test
    void checkIsFirstLetterUpperCase(){
        Assertions.assertTrue(person.isFirstLetterUppercase(person.getName()));
    }

    @Test
    void checkEachName(){
        Assertions.assertEquals(person.checkIfEachNameIsUppercase(), 2);
    }

    @Test
    void checkTotalAmountOfNames(){
        Assertions.assertEquals(person.getTotalAmountOfNames(), 2);
    }

    @Test
    void checkNonNullName(){
        Assertions.assertFalse(person.isEmptyOrNull(person.getName()));
    }

    @Test
    void checkHeightIsGreaterThan100(){
        Assertions.assertTrue(person.getHeightAsInt() > 100);
    }

    @Test
    void checkIfHeightIsNegative(){
        Assertions.assertFalse(person.isHeightNegative());
    }

    @Test
    void checkIfHeightOnlyContainsNumber(){
        Assertions.assertTrue(person.doesHeightOnlyContainNumbers());
    }


    @Test
    void checkIfMassIsNegative(){
        Assertions.assertFalse(person.isMassNegative());
    }

    @Test
    void checkIfMassContainsNumbers(){
        Assertions.assertTrue(person.doesMassOnlyContainNumbers());
    }

    @Test
    void checkIfMassIsGreaterThanZero(){
        Assertions.assertTrue(person.getMassAsInt() > 0);
    }


    @Test
    void canGetFilmObjects(){
        ArrayList<FilmsDTO> films = person.getFilmObjectsList();

        for (FilmsDTO filmsDTO : films){
            Assertions.assertTrue(filmsDTO!=null);
        }

    }

    @Test
    void canGetSpeciesObjects(){
        ArrayList<SpeciesDTO> species= person.getSpeciesObjectsList();
        ArrayList<String> test = person.getResponse().jsonPath().get("species");

        Assertions.assertEquals(species.size(), test.size());
    }


    @Test
    void canGetVehicles(){
        ArrayList<VehiclesDTO> vehicles = person.getVehiclesObjectsList();

        Assertions.assertEquals(vehicles.size(), 2);

        for (VehiclesDTO vehiclesDTO : vehicles){
            Assertions.assertEquals(vehiclesDTO.getName(), vehiclesDTO.getResponse().jsonPath().get("name"));
        }
    }

    @Test
    void canGetStarShips(){
        ArrayList<StarshipsDTO> starships = person.getStarshipsObjectsList();
        ArrayList<String> test = person.getResponse().jsonPath().get("starships");

        Assertions.assertEquals(starships.size(), test.size());

        Assertions.assertEquals(starships.get(0).getName(),"X-wing");

    }

    @Test
    void canGetHomeWorld(){
        PlanetsDTO homeWorld = person.getHomeWorldObject();
        Assertions.assertEquals(homeWorld.getClimate(), "arid");
    }















}
