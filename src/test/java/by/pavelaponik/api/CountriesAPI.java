package by.pavelaponik.api;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;


public class CountriesAPI {

    final static String BASE_URL = "https://restcountries.com";
    final static String GET_BORDERS_END_POINT = "/v2/alpha";
    String countryName = "RUS";
    ArrayList borders;

    public static ArrayList getCountryBorders(Object country) {

        ArrayList bordersList = Requests.sendGetRequestForSpecificCountry(BASE_URL+ GET_BORDERS_END_POINT, country).get("borders");
        return (ArrayList) bordersList.get(0);

    }

    @Test
    public void testGetInformationAboutCountryBorders() {

        borders = getCountryBorders(countryName);

        for (Object country: borders)
        {
            ArrayList countryBorders = getCountryBorders(country.toString());
            Assertions.assertTrue(Arrays.asList(countryBorders).toString().contains(countryName));
        }
    }
}
