package automationFramework;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( tags = "not @ignore",features =
        {"src/test/resources/features",
        }
        ,glue = {"stepdefs"},plugin = {
        "pretty","html:target/report.html"} , dryRun = false,
        monochrome = true)

public class RunCucumberTest { }
