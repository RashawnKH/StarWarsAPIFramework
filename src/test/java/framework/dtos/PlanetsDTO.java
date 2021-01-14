package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class PlanetsDTO extends StarWarsDTO{
    private String name;
    private String rotation_period;
    private String orbital_period;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surface_water;
    private String population;
    private ArrayList<String> residents;
    private ArrayList<String> films;
    private String created;
    private String edited;
    private String url;
    private Response response;

    public Response getResponse() {
        return response;
    }

    public PlanetsDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);
        setupVariables();
    }

    private void setupVariables(){
        name = response.jsonPath().getString("name");
        rotation_period = response.jsonPath().getString("rotation_period");
        orbital_period = response.jsonPath().getString("orbital_path");
        diameter = response.jsonPath().getString("diameter");
        climate = response.jsonPath().getString("climate");
        gravity = response.jsonPath().getString("gravity");
        terrain = response.jsonPath().getString("terrain");
        surface_water = response.jsonPath().getString("surface_water");
        population = response.jsonPath().getString("population");
        residents = response.jsonPath().get("residents");
        films = response.jsonPath().get("films");
        created = response.jsonPath().getString("created");
        edited = response.jsonPath().getString("edited");
        url = response.jsonPath().getString("url");
    }

    public String getName() {
        return name;
    }

    public int getRotation_period() {
        return Integer.valueOf(rotation_period);
    }

    public int getOrbital_period() {
        return Integer.valueOf(orbital_period);
    }

    public int getDiameter() {
        return Integer.valueOf(diameter);
    }

    public String getClimate() {
        return climate;
    }

    public String getGravity() {
        return gravity;
    }

    public String getTerrain() {
        return terrain;
    }

    public int getSurface_water() {
        return Integer.valueOf(surface_water);
    }

    public int getPopulation() {
        return Integer.valueOf(population);
    }

    public ArrayList<String> getResidents() {
        return residents;
    }

    public ArrayList<String> getFilms() {
        return films;
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
