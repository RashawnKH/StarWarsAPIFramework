package com.sparta.rashawn.frameworkTests;

import framework.dtos.*;
import framework.injector.Injector;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class PeopleDTOTest {

  private static PeopleDTO person;


    @BeforeAll
    @DisplayName("Setting up object")
    static void setup(){
        person = (PeopleDTO) Injector.generateDTO("https://swapi.dev/api/people/82/");
    }


    @Test
    @DisplayName("Checking if a person can be created")
    void canCreatePerson(){
        Assertions.assertTrue(person != null);
    }

    @Test
    @DisplayName("Checking if the name is saved correctly")
    void canGetName(){
        Assertions.assertEquals(person.getName(), person.getResponse().jsonPath().get("name"));
    }

    @Test
    @DisplayName("Checking if the height is correct")
    void canGetHeight(){
        Assertions.assertEquals(String.valueOf(person.getHeight()), person.getResponse().jsonPath().get("height"));
    }

    @Test
    @DisplayName("Checking can get all the films")
    void canGetFilms(){

        ArrayList<String> testList =person.getResponse().jsonPath().get("films");


        Assertions.assertEquals(person.getFilms().toString(), testList.toString());
    }

    @Test
    void canGetFilmObjects(){
        ArrayList<FilmsDTO> films = person.getFilmObjectsList();

        for (FilmsDTO filmsDTO : films){
            Assertions.assertEquals(filmsDTO.getTitle(), filmsDTO.getResponse().jsonPath().get("title"));
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
        ArrayList<String> test = person.getResponse().jsonPath().get("vehicles");

        Assertions.assertEquals(vehicles.size(), test.size());

        for (VehiclesDTO vehiclesDTO : vehicles){
            Assertions.assertEquals(vehiclesDTO.getName(), vehiclesDTO.getResponse().jsonPath().get("name"));
        }
    }

    @Test
    void canGetStarShips(){
        ArrayList<StarshipsDTO> starships = person.getStarshipsObjectsList();
        ArrayList<String> test = person.getResponse().jsonPath().get("starships");

        Assertions.assertEquals(starships.size(), test.size());
        for (StarshipsDTO starshipsDTO : starships){
            Assertions.assertEquals(starshipsDTO.getName(), starshipsDTO.getResponse().jsonPath().get("name"));
        }
    }






}
