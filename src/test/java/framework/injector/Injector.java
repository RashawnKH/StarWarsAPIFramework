package framework.injector;

import framework.connectionmanager.ConnectionManager;
import framework.dtos.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Injector {

    public static Response getJSON(String url){
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(url);
        Response json =  connectionManager.getResponse(); //.then().contentType(ContentType.JSON).extract().response();

        return json;
    }

    public static StarWarsDTO generateDTO(String url) {
        if (url.equals(null) || url.equals("")){
            return null;
        }
        if (url.contains("people")) {
            return new PeopleDTO(url);
        } else if (url.contains("films")) {
            return new FilmsDTO(url);
        } else if (url.contains("vehicles")) {
            return new VehiclesDTO(url);
        } else if (url.contains("starships")){
            return new StarshipsDTO(url);
        }else if(url.contains("species")){
            return new SpeciesDTO(url);
        }else if(url.contains("planets")){
            return new PlanetsDTO(url);
        }

        return null;
    }

}
