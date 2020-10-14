package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features/outline.feature"},
        glue = "steps",
        plugin = {"pretty",
                "html:target/cucumber-html-reports.html",
                "json:target/cucumber-html-reports.json"}
)
public class SearchTest extends AbstractTestNGCucumberTests {
}
