package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class PlanetsDTO implements StarWarsDTO{
    private String name;
    private int rotation_period;
    private int orbital_period;
    private int diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private int surface_water;
    private int population;
    private ArrayList<String> residents;
    private ArrayList<String> films;
    private String created;
    private String edited;
    private String url;
    private Response response;




    public PlanetsDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);
        setupVariables();
    }

    private void setupVariables(){
        name = response.jsonPath().getString("name");
        rotation_period = Integer.valueOf(response.jsonPath().get("rotation_period"));
        orbital_period = Integer.valueOf(response.jsonPath().get("orbital_path"));
        diameter = Integer.valueOf(response.jsonPath().get("diameter"));
        climate = response.jsonPath().getString("climate");
        gravity = response.jsonPath().getString("gravity");
        terrain = response.jsonPath().getString("terrain");
        surface_water = Integer.valueOf(response.jsonPath().get("surface_water"));
        population = Integer.valueOf(response.jsonPath().get("population"));
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
        return rotation_period;
    }

    public int getOrbital_period() {
        return orbital_period;
    }

    public int getDiameter() {
        return diameter;
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
        return surface_water;
    }

    public int getPopulation() {
        return population;
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
