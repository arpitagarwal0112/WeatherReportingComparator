package com.wrc.base;

import com.relevantcodes.extentreports.LogStatus;
import com.wrc.util.TestUtil;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties properties;

    public TestBase() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(
                    "C:\\Users\\Arpit K\\IdeaProjects\\WeatherReportingComparator" +
                            "\\src\\main\\java\\com\\wrc\\config\\config.properties"
            );
            properties.load(fis);
        } catch(IOException e) {
            e.getMessage();
        }
    }

    public static void initialization() {
        String browserName = properties.getProperty("browser");

        if(browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Arpit K\\IdeaProjects\\WeatherReportingComparator\\" +
                    "src\\test\\resources\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if(browserName.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Arpit K\\IdeaProjects\\WeatherReportingComparator\\" +
                    "src\\test\\resources\\firefoxdriver_win32\\chromedriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

        driver.get(properties.getProperty("url"));
    }
}
