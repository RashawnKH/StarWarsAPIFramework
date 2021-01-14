package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class FilmsDTO implements StarWarsDTO{


    private ArrayList<String> characters;
    private String created;
    private String edited;
    private int episode_id;
    private String opening_crawl;
    private ArrayList<String> planets;
    private String producer;
    private String release_date;
    private ArrayList<String> species;
    private ArrayList<String> starships;
    private String title;
    private String url;
    private ArrayList<String> vehicles;
    private Response response;




    public FilmsDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);
        setupVariables();


    }

    public ArrayList<String> getCharacters() {
        return characters;
    }

    public String getCreated() {
        return created;
    }

    public String getEdited() {
        return edited;
    }

    public int getEpisode_id() {
        return episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public ArrayList<String> getPlanets() {
        return planets;
    }

    public String getProducer() {
        return producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public ArrayList<String> getSpecies() {
        return species;
    }

    public ArrayList<String> getStarships() {
        return starships;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getVehicles() {
        return vehicles;
    }

    private void setupVariables(){
        characters = response.jsonPath().get("characters");
        created = response.jsonPath().get("created");
        edited = response.jsonPath().get("edited");
        episode_id = Integer.valueOf(response.jsonPath().get("episode_id"));
        opening_crawl = response.jsonPath().get("opening_crawl");
        planets = response.jsonPath().get("planets");
        producer = response.jsonPath().get("producer");
        release_date = response.jsonPath().get("release_date");
        species = response.jsonPath().get("species");
        starships = response.jsonPath().get("starships");
        title = response.jsonPath().get("title");
        url = response.jsonPath().get("url");
        vehicles = response.jsonPath().get("vehicles");
    }


}
