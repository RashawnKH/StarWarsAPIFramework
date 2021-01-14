package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;

public class PersonDTO extends StarWarsDTO{

    private String name;
    private int height;
    private int mass;
    private String hair_colour;
    private String eye_colour;
    private String birth_year;
    private String gender;
    private String homeWorld;
    private ArrayList<String> films;
    private ArrayList<String> species;
    private ArrayList<String> vehicles;
    private ArrayList<String> starShips;
    private String created;
    private String edited;
    private String url;
    private Response response;



    public PersonDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);
        setupVariables();
    }

    public Response getResponse() {
        return response;
    }

    private void setupVariables(){
        name = response.jsonPath().getString("name");
        height = Integer.valueOf(response.jsonPath().get("height"));
        mass = Integer.valueOf(response.jsonPath().get("mass"));
        hair_colour = response.jsonPath().getString("hair_color");
        eye_colour = response.jsonPath().getString("eye_color");
        birth_year = response.jsonPath().getString("birth_year");
        gender = response.jsonPath().getString("gender");
        homeWorld = response.jsonPath().getString("homeworld");
        films = response.jsonPath().get("films");
        species = response.jsonPath().get("species");
        vehicles = response.jsonPath().get("vehicles");
        starShips = response.jsonPath().get("starships");
        created = response.jsonPath().getString("created");
        edited = response.jsonPath().getString("edited");
        url = response.jsonPath().getString("url");
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
    }

    public int getMass() {
        return mass;
    }

    public String getHair_colour() {
        return hair_colour;
    }

    public String getEye_colour() {
        return eye_colour;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeWorld() {
        return homeWorld;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public ArrayList<String> getVehicles() {


        return vehicles;
    }

    public ArrayList<String> getStarShips() {
        return starShips;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public String getUrl() {
        return url;
    }


}
