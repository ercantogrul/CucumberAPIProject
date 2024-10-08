package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {//report plugins
                "pretty",//prints colored logs to the console
                "html:target/reports/default-cucumber-reports.html" //plugin used to generate reports in html format
        },
        features = "src/test/resources/features",
        glue = {"stepdefinitions","base_urls"},  // java kodlarinin calisacagi package lari girilir
        tags = "@Contact",
        dryRun = false  // dryRun = false test calisir
        //dryRun = true // yapildiginda test calismaz sadece eksik step definitions methodlari tespit eder


)
public class Runner {

}