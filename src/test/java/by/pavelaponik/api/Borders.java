package by.pavelaponik.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Borders {

    public static Response doGetRequest(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

        return
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get(endpoint).
                        then().contentType(ContentType.JSON).extract().response();
    }

    public static void main(String[] args) {

        Response response = doGetRequest("https://restcountries.com/v2/alpha/rus");
        List<String> jsonResponse = response.jsonPath().getList("borders");
        System.out.println(jsonResponse);
    }
}
