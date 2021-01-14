package framework.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import framework.injector.Injector;
import io.restassured.response.Response;

import java.util.ArrayList;

public class PeopleDTO extends StarWarsDTO{

    @JsonProperty private String name;
    @JsonProperty private String height;
    @JsonProperty private String mass;
    @JsonProperty private String hair_color;
    @JsonProperty private String eye_color;
    @JsonProperty private String birth_year;
    @JsonProperty private String gender;
    @JsonProperty private String homeworld;
    @JsonProperty private String skin_color;



    @JsonProperty private ArrayList<String> films;
    @JsonProperty private ArrayList<String> species;
    @JsonProperty private ArrayList<String> vehicles;
    @JsonProperty private ArrayList<String> starships;
    @JsonProperty private String created;
    @JsonProperty private String edited;
    @JsonProperty private String url;
    private Response response;


    public PeopleDTO(){
    }



    public PeopleDTO(String url){
        Injector injector = new Injector();
        response = injector.getJSON(url);


        try {
            setupVariables();
        }catch (ClassCastException e){
            e.printStackTrace();
       }

    }

    public Response getResponse() {
        return response;
    }

    private void setupVariables(){

            name = response.jsonPath().getString("name");
            height = response.jsonPath().get("height");
            mass = response.jsonPath().get("mass");
            hair_color = response.jsonPath().get("hair_color");
            eye_color = response.jsonPath().get("eye_color");
            birth_year = response.jsonPath().get("birth_year");
            gender = response.jsonPath().get("gender");
            homeworld = response.jsonPath().get("homeworld");
            films = response.jsonPath().get("films");
            species = response.jsonPath().get("species");
            vehicles = response.jsonPath().get("vehicles");
            starships = response.jsonPath().get("starships");
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

    public int getNameLength(){
        return name.length();
    }

    public int getTotalAmountOfNames(){
        String[] names = name.split(" ");
        return names.length;
    }

    public int checkIfEachNameIsUppercase(){
        String[] names = name.split(" ");
        int upperCaseCounter = 0;

        for (String string: names) {
           if (isFirstLetterUppercase(string)){
               upperCaseCounter++;
           }
        }

        return upperCaseCounter;
    }

    public boolean isEmptyOrNull(String word){
        if (word.equals(null) || word.equals("")){
            return true;
        }
        return false;
    }

    public boolean isFirstLetterUppercase(String name){
        boolean upperCase = false;
        char firstLetter = name.charAt(0);
        String nameToUpperCase = name.toUpperCase();

        if (firstLetter == nameToUpperCase.charAt(0)){
            upperCase = true;
        }
        return upperCase;
    }

    public String getHeight() {
        return height;
    }

    public int getHeightAsInt(){
        return Integer.valueOf(height);
    }

    public boolean isHeightNegative(){
        if (getHeightAsInt() < 0){
            return true;
        }
        return false;
    }


    public boolean doesHeightOnlyContainNumbers(){
        if (getHeight().matches("[0-9]+")){
            return true;
        }
        return false;
    }


    public int getMassAsInt(){
        return Integer.valueOf(mass);
    }


    public boolean isMassNegative(){
        if (getMassAsInt() < 0){
            return true;
        }

        return false;
    }

    public boolean doesMassOnlyContainNumbers(){
        if (getMass().matches("[0-9]+")){
            return true;
        }
        return false;
    }















    public String getSkin_color() {
        return skin_color;
    }


    public String getMass() {
        return mass;
    }

    public String getHair_color() {
        return hair_color;
    }

    public String getEye_color() {
        return eye_color;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public String getGender() {
        return gender;
    }

    public String getHomeWorld() {
        return homeworld;
    }

    public PlanetsDTO getHomeWorldObject(){
         PlanetsDTO planetDTO = (PlanetsDTO) Injector.generateDTO(homeworld);
         return planetDTO;
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
        return starships;
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
