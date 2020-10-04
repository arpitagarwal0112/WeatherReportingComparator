package com.wrc.pages;

import com.wrc.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NDTVWeatherDetailsPage extends TestBase {

    @FindBy(how = How.ID, using = "searchBox")
    private WebElement citySearch;

    @FindBy(how = How.XPATH, using = "//*[@id='messages']/div[1]/label/input")
    private List<WebElement> cityList;

    @FindBy(how = How.XPATH, using = "//div[@class='cityText']")
    private WebElement cityName;

    @FindBy(how = How.XPATH, using = "//span[@class='tempWhiteText']")
    private WebElement cityTemperature;

    @FindBy(how = How.XPATH, using = "//b[contains(text(), 'Condition')]")
    private WebElement weatherCondition;

    @FindBy(how = How.XPATH, using = "/b[contains(text(), 'Wind')]")
    private WebElement windSpeed;

    @FindBy(how = How.XPATH, using = "//b[contains(text(), 'Humidity')]")
    private WebElement humidity;

    @FindBy(how = How.XPATH, using = "//b[contains(text(), 'Fahrenheit')]")
    private WebElement temperature;

    @FindBy(how = How.XPATH, using = "//a[@class='leaflet-popup-close-button']")
    private WebElement closeWeatherPopupButton;


    public NDTVWeatherDetailsPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateWeatherPageTitle() {
        return driver.getTitle();
    }

    public void searchForCity(String city) {
        cityName.sendKeys(city);
    }

    public void selectCity(String city) {
        for(int i = 0; i < cityList.size(); ++i) {
            WebElement checkbox = cityList.get(i);
            checkbox.click();
        }
    }

    public void clearCityList() {
        for(int i = 0; i < cityList.size(); ++i) {
            WebElement checkbox = cityList.get(i);
            if(checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    public boolean isCityDisplayedOnMap() {
        return cityName.isDisplayed();
    }

    public boolean isTemperatureDisplayedOnMap() {
        return cityTemperature.isDisplayed();
    }

    public void selectCityOnMap() {
        cityName.click();
    }

    public String verifyWeatherPageTitle() {
        return driver.getTitle();
    }

    public boolean verifyWeatherConditionDisplay() {
        return weatherCondition.isDisplayed();
    }

    public boolean verifyWindSpeedDisplay() {
        return windSpeed.isDisplayed();
    }

    public boolean verifyHumidityDisplay() {
        return humidity.isDisplayed();
    }

    public boolean verifyTemperatureDisplay() {
        return temperature.isDisplayed();
    }

    public void closeWeatherPopup() {
        closeWeatherPopupButton.click();
    }
}
