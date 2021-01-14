package com.sparta.rashawn.frameworkTests;

import framework.dtos.PersonDTO;
import framework.injector.Injector;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class PersonDTOTest {

  private static PersonDTO person;


    @BeforeAll
    @DisplayName("Setting up object")
    static void setup(){
        person = (PersonDTO) Injector.generateDTO("https://swapi.dev/api/people/1/");
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



}
