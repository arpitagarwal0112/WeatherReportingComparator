package com.wrc.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Arpit K\\IdeaProjects\\WeatherReportingComparator\\src\\test\\java\\com\\wrc\\features\\OpenWeatherMapDetails.feature",
        glue = {"com/wrc/steps"},
        monochrome = (true),
        dryRun = false
        //tags = {}
        )

public class WeatherRunner { }
