package com.sparta.rashawn.exampletests;

import framework.connectionmanager.ConnectionManager;
import framework.dtos.*;
import framework.injector.Injector;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;


public class ExampleTests {


    private static PeopleDTO person;
    private static  ConnectionManager connectionManager;

    private static Response response;

    @BeforeAll
    @DisplayName("Setting up connection and personDTO")
    static void setup() {
        response = RestAssured.get("https://swapi.dev/api/people/1/");


        connectionManager = new ConnectionManager();
        person = (PeopleDTO) Injector.generateDTO("https://swapi.dev/api/people/1/");
    }

    @Test
    @DisplayName("Converting date without framework")
    void checkDateWithoutFramework(){
        String date = response.getHeader("date");
        String from_format = "E, dd MMM yyyy HH:mm:ss z";

        DateTimeFormatter from_formatter = DateTimeFormatter.ofPattern(from_format);
        LocalDate dateFromServer = LocalDate.parse(date, from_formatter);

        Assertions.assertEquals(dateFromServer, LocalDate.now());
    }

    @Test
    @DisplayName("Testing the date is converted correctly")
    void checkConvertedDate(){
        Assertions.assertEquals(connectionManager.convertServerDateToLocalDate(person.getResponse()), LocalDate.now());
    }

    @Test
    @DisplayName("Testing can get headers from DTO")
    void canGetDTOConnection(){
        HashMap<String, String> headers = connectionManager.getHeaders(person.getResponse());
        Assertions.assertEquals(headers.get("connection"), "keep-alive");
    }

    @Test
    @DisplayName("Testing status code with framework")
    void checkStatusCode(){
        Assertions.assertEquals(connectionManager.getStatusCode(person.getResponse()), 200);
    }

    @Test
    @DisplayName("Testing all headers")
    void canGetAllHeaders(){
        HashMap<String, String> headers = connectionManager.getHeaders(person.getResponse());
        HashMap<String, String> filmHeaders = connectionManager.getHeaders(person.getFilmObjectsList().get(0).getResponse());


        Assertions.assertTrue(headers.get("vary")!=null);
        Assertions.assertEquals(filmHeaders.get("connection"), "keep-alive");

    }

    @Test
    @DisplayName("Testing header without framework")
    void testingHeaders() {
        response.getHeader("connection").equals("[keep-alive]");
    }

    @Test
    @DisplayName("Testing variables without framework")
    void testingVariables(){
        String name = response.jsonPath().getString("name");

        String height = response.jsonPath().getString("height");

        int heightNumber = Integer.valueOf(height);

        String eye_colour = response.jsonPath().getString("eye_color");




        assertThat("Luke Skywalker", Matchers.equalTo(name));

        assertThat("172", Matchers.equalTo(height));

        Assertions.assertTrue(heightNumber > 100);

        assertThat("blue", Matchers.equalTo(eye_colour));
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

        Assertions.assertTrue(films.get(2)!=null);
    }

    @Test
    void canGetSpeciesObjects(){
        Assertions.assertEquals(person.getSpeciesObjectsList().size(), 0);
    }


    @Test
    void canGetVehicles(){
        ArrayList<VehiclesDTO> vehicles = person.getVehiclesObjectsList();
        Assertions.assertEquals(vehicles.get(1).getName(),"Imperial Speeder Bike" );

    }

    @Test
    void canGetStarShips(){
        ArrayList<StarshipsDTO> starships = person.getStarshipsObjectsList();
        ArrayList<String> test = person.getJSON().get("starships");

        Assertions.assertEquals(starships.size(), test.size());

        Assertions.assertEquals(starships.get(0).getName(),"X-wing");

    }

    @Test
    void canGetHomeWorld(){
        PlanetsDTO homeWorld = person.getHomeWorldObject();
        Assertions.assertEquals(homeWorld.getClimate(), "arid");
    }


}
