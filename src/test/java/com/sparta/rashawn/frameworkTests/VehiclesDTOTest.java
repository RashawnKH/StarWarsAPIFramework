package com.sparta.rashawn.frameworkTests;

import framework.dtos.VehiclesDTO;
import framework.injector.Injector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class VehiclesDTOTest {
    private static VehiclesDTO vehiclesDTO;

    @BeforeAll
    static void setup(){
        vehiclesDTO = (VehiclesDTO) Injector.generateDTO("http://swapi.dev/api/vehicles/14/");
    }


    @Test
    void canGetCargoCap(){
        Assertions.assertEquals(vehiclesDTO.getCargo_capacity(), vehiclesDTO.getResponse().jsonPath().get("cargo_capacity"));
    }

    @Test
    void canGetVehicle(){
        Assertions.assertTrue(vehiclesDTO!=null);
    }

    @Test
    void canGetCost(){
        Assertions.assertEquals(vehiclesDTO.getCost_in_credits(), vehiclesDTO.getResponse().jsonPath().get("cost_in_credits"));

    }

    @Test
    void canGetPilots(){
        ArrayList<String> test = vehiclesDTO.getResponse().jsonPath().get("pilots");
        Assertions.assertEquals(vehiclesDTO.getPilots().toString(), test.toString());
    }

}
