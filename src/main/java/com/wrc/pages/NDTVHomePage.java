package com.wrc.pages;

import com.relevantcodes.extentreports.ExtentTest;
import com.wrc.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NDTVHomePage extends TestBase {

    // Page Factory - Locating Elements
    @FindBy(xpath = "//a[@id='h_sub_menu']")
    private WebElement extendedMenuLink;

    @FindBy(xpath = "//a[contains(text(), 'WEATHER')]")
    private WebElement weatherLink;

    @FindBy(xpath = "//a[contains(text(), 'NDTV')]")
    private WebElement NDTVLink;
    
    @FindBy(how = How.XPATH, using = "//a[starts-with(@onclick, 'ndtvCloseThis')]")
    private WebElement newsAlertCloseLink;

    // Initializing the Page Object
    public NDTVHomePage() {
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle() {
        System.out.println(driver.getTitle());
        return driver.getTitle();
    }

    public void closeAlert() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click()", newsAlertCloseLink);
    }

    public boolean validateNDTVLink() {
        return NDTVLink.isDisplayed();
    }

    public void clickExtendedMenuLink() {
        extendedMenuLink.click();
    }

    public NDTVWeatherDetailsPage clickWeatherLink() {
        weatherLink.click();
        return new NDTVWeatherDetailsPage();
    }
}
