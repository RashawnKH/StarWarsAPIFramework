package framework.dtos;

import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class PersonDTO extends StarWarsDTO{

    private String name;
    private String height;
    private String mass;
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
        height = response.jsonPath().get("height");
        mass = response.jsonPath().get("mass");
        hair_colour = response.jsonPath().get("hair_color");
        eye_colour = response.jsonPath().get("eye_color");
        birth_year = response.jsonPath().get("birth_year");
        gender = response.jsonPath().get("gender");
        homeWorld = response.jsonPath().get("homeworld");
        films = response.jsonPath().get("films");
        species = response.jsonPath().get("species");
        vehicles = response.jsonPath().get("vehicles");
        starShips = response.jsonPath().get("starships");
        created = response.jsonPath().get("created");
        edited = response.jsonPath().get("edited");
        url = response.jsonPath().get("url");
    }


    public ArrayList<FilmsDTO> getFilmObjectsList(){
        ArrayList<FilmsDTO> films = new ArrayList<>();

        if (getFilms().size()!=0) {
            for (String string : getFilms()) {
                FilmsDTO filmsDTO = (FilmsDTO) Injector.generateDTO(string);
                films.add(filmsDTO);
            }
        }

        return films;
    }


    public ArrayList<VehiclesDTO> getVehiclesObjectsList(){
        ArrayList<VehiclesDTO> vehicles = new ArrayList<>();

        if (getVehicles().size()!=0) {
            for (String string : getVehicles()) {
                VehiclesDTO vehiclesDTO = (VehiclesDTO) Injector.generateDTO(string);
                vehicles.add(vehiclesDTO);
            }
        }
        return vehicles;
    }


    public ArrayList<SpeciesDTO> getSpeciesObjectsList(){
        ArrayList<SpeciesDTO> species = new ArrayList<>();

        if (getSpecies().size()!=0) {
            for (String string : getSpecies()) {
                SpeciesDTO speciesDTO= (SpeciesDTO) Injector.generateDTO(string);
                species.add(speciesDTO);
            }
        }
        return species;

    }


    public ArrayList<StarshipsDTO> getStarshipsObjectsList(){
        ArrayList<StarshipsDTO> starships = new ArrayList<>();

        if (getStarShips().size()!=0) {
            for (String string : getStarShips()) {
                StarshipsDTO starshipsDTO= (StarshipsDTO) Injector.generateDTO(string);
                starships.add(starshipsDTO);
            }
        }
        return starships;
    }







    public String getName() {
        return name;
    }

    public String getHeight() {
        return height;
    }

    public String getMass() {
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
