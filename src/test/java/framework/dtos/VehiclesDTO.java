package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class VehiclesDTO extends StarWarsDTO {


    private String cargo_capacity;
    private String consumables;
    private String cost_in_credits;
    private String crew;
    private String length;
    private String manufacturer;
    private String max_atmosphering_speed;
    private String model;
    private String name;
    private String passengers;
    private ArrayList<String> pilots;
    private ArrayList<String> films;
    private String vehicle_class;


    private String created;
    private String edited;
    private String url;
    private Response response;

    public VehiclesDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);
        setupVariables();
    }

    public Response getResponse() {
        return response;
    }

    public ArrayList<String> getFilms() {
        return films;
    }


    private void setupVariables(){
        cargo_capacity = response.jsonPath().get("cargo_capacity");
        consumables = response.jsonPath().getString("consumables");
        cost_in_credits = response.jsonPath().get("cost_in_credits");
        films = response.jsonPath().get("films");
        crew = response.jsonPath().get("crew");
        length = response.jsonPath().get("length");
        manufacturer = response.jsonPath().getString("manufacturer");
        max_atmosphering_speed = response.jsonPath().get("max_atmosphering_speed");
        model = response.jsonPath().getString("model");
        name = response.jsonPath().getString("name");
        passengers = response.jsonPath().get("passengers");
        pilots = response.jsonPath().get("pilots");
        vehicle_class = response.jsonPath().getString("vehicle_class");
        created = response.jsonPath().getString("created");
        edited = response.jsonPath().getString("edited");
        url = response.jsonPath().getString("url");
    }


    public  String getCargo_capacity() {
        return cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public String getCost_in_credits() {
        return cost_in_credits;
    }

    public String getCrew() {
        return crew;
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

    public ArrayList<String> getPilots() {
        return pilots;
    }

    public String getVehicle_class() {
        return vehicle_class;
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
