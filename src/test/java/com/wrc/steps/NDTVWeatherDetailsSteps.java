package com.wrc.steps;

import com.wrc.base.TestBase;
import com.wrc.pages.NDTVHomePage;
import com.wrc.pages.NDTVWeatherDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class NDTVWeatherDetailsSteps extends TestBase {

    NDTVHomePage homePage = new NDTVHomePage();
    NDTVWeatherDetailsPage weatherDetailsPage = new NDTVWeatherDetailsPage();

    @Given("User open browser")
    public void user_open_browser() {
        TestBase.initialization();
    }

    @Given("User is on the NDTV Home Page")
    public void user_is_on_the_ndtv_home_page() {
        String homePageTitle = homePage.validateHomePageTitle();
        Assert.assertEquals(properties.getProperty("homePageTitle"), homePageTitle);
        homePage.closeAlert();
    }

    @When("User click on Weather link")
    public void user_click_on_weather_link() {
        homePage.clickExtendedMenuLink();
        weatherDetailsPage = homePage.clickWeatherLink();
    }

    @Then("User navigate to NDTV Weather Page")
    public void user_navigate_to_ndtv_weather_page() {
        String weatherPageTitle = weatherDetailsPage.validateWeatherPageTitle();
        Assert.assertEquals(properties.getProperty("weatherPageTitle"), weatherPageTitle);
    }

    @When("User enter the city name in the Pin Your City search field")
    public void user_enter_the_city_name_in_the_pin_your_city_search_field() {
        weatherDetailsPage.searchForCity(properties.getProperty("cityToFind"));
    }

    @When("User select the city from the list")
    public void user_select_the_city_from_the_list() {
        weatherDetailsPage.clearCityList();
        weatherDetailsPage.selectCity(properties.getProperty("cityToFind"));
    }

    @Then("User should see the city name displayed on the map")
    public void user_should_see_the_city_name_displayed_on_the_map() {
        Assert.assertTrue(weatherDetailsPage.isCityDisplayedOnMap());
    }
    @Then("User should see the temperature displayed on the map")
    public void user_should_see_the_temperature_displayed_on_the_map() {
        Assert.assertTrue(weatherDetailsPage.isTemperatureDisplayedOnMap());
    }
}
