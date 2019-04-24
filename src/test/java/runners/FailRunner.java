package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html: target/fail-run-htmlReport",
                  "json: target/failReport.json"},
        features = "src/test/resources/features",
        glue = "steps",
        dryRun = false
//        #tags = "@ant"
)

public class FailRunner {
}
