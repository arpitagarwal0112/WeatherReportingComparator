package com.wrc.base;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class Base {

    public WebDriver driver;

    public ExtentTest test;

    public Base() {}

    public Base(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
        PageFactory.initElements(driver, Base.class);
    }

    public boolean isElementPresent(String locator) {
        test.log(LogStatus.INFO, "Finding the element");

        List<WebElement> elements = driver.findElements(By.xpath(locator));

        if(elements.size() > 0) {
            test.log(LogStatus.INFO, "Element found");
            return true;
        }
        else {
            test.log(LogStatus.INFO, "Element not found");
            return false;
        }
    }

    public void takeScreenshot() {
        
        // File Name of the screenshot
        Date date = new Date();
        String screenshotFile = date.toString().replace(":", "_").replace(" ", "_")+".png";

        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"//screenshots//"+screenshotFile));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void failTest(String failureMessage) {
        test.log(LogStatus.INFO, failureMessage);
        takeScreenshot();
        Assert.fail(failureMessage);
    }
}
