package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class VehiclesDTO implements StarWarsDTO {


    private int cargo_capacity;
    private String consumables;
    private int cost_in_credits;
    private int crew;
    private double length;
    private String manufacturer;
    private int max_atmosphering_speed;
    private String model;
    private String name;
    private int passengers;
    private ArrayList<String> pilots;
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

    private void setupVariables(){
        cargo_capacity = Integer.valueOf(response.jsonPath().get("cargo_capacity"));
        consumables = response.jsonPath().getString("consumables");
        cost_in_credits = Integer.valueOf(response.jsonPath().get("cost_in_credits"));
        crew = Integer.valueOf(response.jsonPath().get("crew"));
        length = Double.valueOf(response.jsonPath().getString("length"));
        manufacturer = response.jsonPath().getString("manufacturer");
        max_atmosphering_speed = Integer.valueOf(response.jsonPath().get("max_atmosphering_speed"));
        model = response.jsonPath().getString("model");
        name = response.jsonPath().getString("name");
        passengers = response.jsonPath().getInt("passengers");
        pilots = response.jsonPath().get("pilots");
        vehicle_class = response.jsonPath().getString("vehicle_class");
        created = response.jsonPath().getString("created");
        edited = response.jsonPath().getString("edited");
        url = response.jsonPath().getString("url");
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

    public int getCrew() {
        return crew;
    }

    public double getLength() {
        return length;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getMax_atmosphering_speed() {
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
