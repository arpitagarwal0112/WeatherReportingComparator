package com.wrc.steps;

import com.wrc.apiObjects.OpenWeatherMap;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.*;

import static java.util.Objects.isNull;
import static org.junit.Assert.assertEquals;

public class OpenWeatherMapDetailsSteps extends OpenWeatherMap {

    @When("^I fetch weather details from OpenWhetherMap \"([^\"]*)\" APIKey and city name as \"([^\"]*)\"$")
    public void fetchWeatherDetailsWithCityName(String withOrWithOut_APIKey, String cityName)  {
        String apiKey = withOrWithOut_APIKey.equalsIgnoreCase("without") ? "" : APIKEY;
        try {
            currentResponse = OpenWeatherMap.getWeatherDetailsByCityName(apiKey, cityName);
        }
        catch (Exception ex) {
            System.out.println(">> Can't fetch weather details: Is it a valid APIKey? -> '" + apiKey + "'");
        }
    }

    @Then("^I should see the response body with \"([^\"]*)\" as \"([^\"]*)\"$")
    public void iShouldSeeTheResponseBodyWith(String key, String value)  {
        if (isNull(currentResponse)) { return; }

        String actualString = getValueByKey(currentResponse, key);
        assertEquals("ERROR: The actual Code is " + actualString, value, actualString);
    }

    @Then("^I have received HTTP response code of \"([^\"]*)\"$")
    public void iHaveReceivedHTTPResponseCodeOf(String expectedHTTPCode)  {
        String actualHTTPCode = isNull(currentResponse) ? "" : getStatusCode(currentResponse);
        assertEquals("ERROR: The actual Code is " + actualHTTPCode, expectedHTTPCode, actualHTTPCode);
    }

    @Then("^I see weather details with values as \"([^\"]*)\",\"([^\"]*)\"$")
    public void verifyLatitudeAndLongitude(String latitude, String longitude)  {

        if (isNull(currentResponse)) { return; }

        List<String> actualList = new ArrayList<>();

        actualList.add(getValueByKey(currentResponse,"lon"));
        actualList.add(getValueByKey(currentResponse,"lat"));

        List<String> expectedList = Arrays.asList(latitude, longitude);

        assertEquals("ERROR: The city details are not matching; Actual: " + actualList.toString() ,
                expectedList, actualList);
    }



}
