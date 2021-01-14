package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class SpeciesDTO implements StarWarsDTO{
    private double average_height;
    private int average_lifespan;
    private String classification;
    private String created;
    private String designation;
    private String edited;
    private String eye_colors;
    private String hair_colors;
    private String homeworld;
    private String name;
    private ArrayList<String> people;
    private ArrayList<String> films;
    private String skin_colors;
    private String url;
    private Response response;



    public SpeciesDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);
        setupVariables();
    }

    public void setupVariables(){

        average_height = Double.valueOf(response.jsonPath().get("average_height"));
        average_lifespan = Integer.valueOf(response.jsonPath().get("average_lifespan"));
        classification = response.jsonPath().get("classification");
        created = response.jsonPath().get("created");
        designation = response.jsonPath().get("designation");
        edited = response.jsonPath().get("edited");
        eye_colors = response.jsonPath().get("eye_colors");
        hair_colors = response.jsonPath().get("hair_colors");
        homeworld = response.jsonPath().get("homeworld");
        name = response.jsonPath().get("name");
        people = response.jsonPath().get("people");
        films = response.jsonPath().get("films");
        skin_colors = response.jsonPath().get("skin_colors");
        url = response.jsonPath().get("url");

    }





    public double getAverage_height() {
        return average_height;
    }

    public int getAverage_lifespan() {
        return average_lifespan;
    }

    public String getClassification() {
        return classification;
    }

    public String getCreated() {
        return created;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEdited() {
        return edited;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getPeople() {
        return people;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public String getUrl() {
        return url;
    }





}
