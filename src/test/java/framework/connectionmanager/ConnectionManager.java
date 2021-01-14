package framework.connectionmanager;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class ConnectionManager {


    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public void connect(String url){
        setResponse(RestAssured.get(url));
    }


    public String convertServerDateToLocalDate(){
        String date = response.getHeader("date");
        String from_format = "E, dd MMM yyyy HH:mm:ss z";

        DateTimeFormatter from_formatter = DateTimeFormatter.ofPattern(from_format);
        LocalDateTime dateFromServer = LocalDateTime.parse(date, from_formatter);

        return String.valueOf(dateFromServer);
    }


    public HashMap<String, String> getHeaders()  {
        HashMap<String, String> headers = new HashMap<>();

        headers.put("server",response.getHeader("server"));
        headers.put("date",response.getHeader("date"));
        headers.put("content-type", response.getHeader("content-type"));
        headers.put("transfer-encoding",response.getHeader("transfer-encoding"));
        headers.put("connection", response.getHeader("connection"));
        headers.put("vary", response.getHeader("vary"));
        headers.put("x-frame-options", response.getHeader("x-frame-options"));
        headers.put("etag", response.getHeader("etag"));
        headers.put("allow", response.getHeader("allow"));
        headers.put("strict-transport-security", response.getHeader("strict-transport-security"));


        return headers;
    }

    public int getStatusCode(){
         return response.getStatusCode();
    }

    public ResponseBody getBody(){
        return response.getBody();
    }



}
