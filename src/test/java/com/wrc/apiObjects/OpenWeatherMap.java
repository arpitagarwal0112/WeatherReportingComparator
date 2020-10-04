package com.wrc.apiObjects;

import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class OpenWeatherMap implements apiFields {

    protected static ResponseOptions currentResponse = null;
    //protected static String cityName = null;

    // APIKey - final/fixed value
    protected static final String APIKEY = "7fe67bf08c80ded756e598d6f8fedaea";

    // Private parameters to use within this class
    private static final String WEATHER_DETAILS_URI = "http://api.openweathermap.org/data/2.5/weather";
    private static RequestSpecification request = null;

    // Constructor
    public OpenWeatherMap() {
        request = given().contentType(ContentType.JSON);
    }

    // --------------------------------------
    // Fetch Weather Details by City Name
    // --------------------------------------

    public static ResponseOptions getWeatherDetailsByCityName(String apiKey, String cityName) {
        ResponseOptions responseOptionReturn = null;
        try {
            responseOptionReturn = given()
                    .when()
                    .get(WEATHER_DETAILS_URI+"?q="+cityName+"&appid="+apiKey);
        } catch (Exception e) {
            System.out.println("EXCEPTION: " + e.getMessage());
        }
        // Extract Response into an Object response"
        return responseOptionReturn;
    }


    // --------------------------------
    // Get response values by key
    // --------------------------------
    public String getValueByKey(ResponseOptions resp, String key) {
        String returnString = "";
        try {
            //returnString = resp.body().jsonPath().get(key).toString();
            returnString = resp.getBody().jsonPath().get(key).toString();
        } catch (JsonPathException jsonEx) {
            System.out.println("EXCEPTION: JSON PATH NOT FOUND");
            returnString = "NA";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return returnString;
    }

    // Get the Status Code
    public String getStatusCode(ResponseOptions<Response> resp) {
        return String.valueOf(((RestAssuredResponseImpl) resp).then().extract().statusCode());
    }

}
