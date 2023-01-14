package by.pavelaponik.api;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CountriesAPI {

    @Test
    public void testGetInformationAboutCountryRus() {

        String endPoint = "https://restcountries.com/v2/alpha";

        given().queryParams("codes", "RUS").when().get(endPoint)
                .then().log().body();

    }
}
