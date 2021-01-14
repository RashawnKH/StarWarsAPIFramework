package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class StarshipsDTO extends StarWarsDTO{
    public Response getResponse() {
        return response;
    }

    private String MGLT;
    private String cargo_capacity;
    private String consumables;
    private String cost_in_credits;
    private String created;
    private String crew;
    private String edited;
    private String hyperdrive_rating;
    private String length;
    private String manufacturer;
    private String max_atmosphering_speed;
    private String model;
    private String name;
    private String passengers;
    private ArrayList<String> films;
    private ArrayList<String> pilots;
    private String starship_class;
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

    public String getCargo_capacity() {
        return cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public String getCreated() {
        return created;
    }

    public String getCrew() {
       return  crew;
    }

    public String getEdited() {
        return edited;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public String getLength() {
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

    public String getPassengers() {
        return passengers;
    }

    public ArrayList<String> getFilms() {
        return films;
    }

    public ArrayList<String> getPilots() {
        return pilots;
    }

    public String getStarship_class() {
        return starship_class;
    }

    public String getUrl() {
        return url;
    }

    private void setupVariables(){

        MGLT = response.jsonPath().getString("MGLT");
        cargo_capacity = response.jsonPath().get("cargo_capacity");
        consumables = response.jsonPath().getString("consumables");
        cost_in_credits = response.jsonPath().get("cost_in_credits");
        created = response.jsonPath().getString("created");
        crew = response.jsonPath().get("crew");
        edited = response.jsonPath().get("edited");
        hyperdrive_rating = response.jsonPath().get("hyperdrive_rating");
        length = response.jsonPath().get("length");
        manufacturer = response.jsonPath().getString("manufacturer");
        max_atmosphering_speed = response.jsonPath().get("max_atmosphering_speed");
        model = response.jsonPath().get("model");
        pilots = response.jsonPath().get("pilots");
        passengers = response.jsonPath().get("passengers");

        starship_class = response.jsonPath().get("starship_class");
        name = response.jsonPath().getString("name");
        films = response.jsonPath().get("films");
        url = response.jsonPath().getString("url");
    }






}
