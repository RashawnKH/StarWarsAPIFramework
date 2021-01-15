package com.sparta.rashawn.frameworkTests;

import framework.connectionmanager.ConnectionManager;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.HashMap;

public class ConnectionManagerTests {
    ConnectionManager connectionManager;

    @Test
    @BeforeEach
    void setup(){
        connectionManager = new ConnectionManager();
        connectionManager.connect("https://swapi.dev/api/people/1/");
        Assertions.assertEquals(connectionManager.getStatusCode(connectionManager.getResponse()), 200);

    }

    @Test
    @DisplayName("Testing the date is converted correctly")
    void checkConvertedDate(){

        Assertions.assertEquals(connectionManager.convertServerDateToLocalDate(connectionManager.getResponse()), LocalDate.now());

    }

    @Test
    @DisplayName("Testing you can get the response")
    void canGetResponse(){
        Response response = RestAssured.get("https://swapi.dev/api/people/1/");
        connectionManager.setResponse(response);
        Assertions.assertEquals(response, connectionManager.getResponse());
    }

    @Test
    @DisplayName("Testing you can get the correct headers")
    void canGetHeaders(){
        HashMap<String,String> headers = connectionManager.getHeaders(connectionManager.getResponse());
        for (String string: headers.keySet()) {
            Assertions.assertEquals(headers.get(string), connectionManager.getResponse().getHeader(string));
        }
    }



}
