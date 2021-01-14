package com.sparta.rashawn.frameworkTests;

import framework.dtos.StarWarsDTO;
import framework.injector.Injector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonDTOTest {

    @Test
    @DisplayName("Checking if a person can be created")
    void canCreatePerson(){
        StarWarsDTO person = Injector.generateDTO("https://swapi.dev/api/people/1/");

        System.out.println(person.toString());
    }




}
