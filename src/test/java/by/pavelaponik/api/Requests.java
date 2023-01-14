package by.pavelaponik.api;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;

public class Requests {

    public static JsonPath sendGetRequestForSpecificCountry(String endPoint, Object country) {

        JsonPath response = given().queryParams("codes", country).when().get(endPoint).then().extract().response().jsonPath();
        return response;
    }
}
