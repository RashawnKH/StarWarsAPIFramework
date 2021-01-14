package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class StarshipsDTO implements StarWarsDTO{

    private String MGLT;
    private int cargo_capacity;
    private String consumables;
    private int cost_in_credits;
    private String created;
    private int crew;
    private String edited;
    private double hyperdrive_rating;
    private int length;
    private String manufacturer;
    private String max_atmosphering_speed;
    private String model;
    private String name;
    private int passengers;
    private ArrayList<String> films;
    private ArrayList<String> pilots;
    private int starship_class;
    private String url;
    private Response response;



    public StarshipsDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);
        setupVariables();
    }

    public String getMGLT() {
        return MGLT;
    }

    public int getCargo_capacity() {
        return cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public int getCost_in_credits() {
        return cost_in_credits;
    }

    public String getCreated() {
        return created;
    }

    public int getCrew() {
        return crew;
    }

    public String getEdited() {
        return edited;
    }

    public double getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public int getLength() {
        return length;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public String getModel() {
        return model;
    }

    public String getName() {
        return name;
    }

    public int getPassengers() {
        return passengers;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public ArrayList<String> getPilots() {
        return pilots;
    }

    public int getStarship_class() {
        return starship_class;
    }

    public String getUrl() {
        return url;
    }

    private void setupVariables(){

        MGLT = response.jsonPath().getString("MGLT");
        cargo_capacity = Integer.valueOf(response.jsonPath().get("cargo_capacity"));
        consumables = response.jsonPath().getString("consumables");
        cost_in_credits = Integer.valueOf(response.jsonPath().get("cost_in_credits"));
        created = response.jsonPath().getString("created");
        crew = Integer.valueOf(response.jsonPath().get("crew"));
        edited = response.jsonPath().get("edited");
        hyperdrive_rating = Double.valueOf(response.jsonPath().get("hyperdrive_rating"));
        length = Integer.valueOf(response.jsonPath().get("length"));
        manufacturer = response.jsonPath().getString("manufacturer");
        max_atmosphering_speed = response.jsonPath().get("max_atmosphering_speed");
        model = response.jsonPath().get("model");
        pilots = response.jsonPath().get("pilots");
        passengers = Integer.valueOf(response.jsonPath().get("passengers"));

        starship_class = response.jsonPath().get("starship_class");
        name = response.jsonPath().getString("name");
        films = response.jsonPath().get("films");
        url = response.jsonPath().getString("url");
    }






}
