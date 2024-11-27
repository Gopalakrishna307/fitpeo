package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions
	(
			features="src/test/resources/Features",
			glue="stepDef",
			dryRun=false,
			monochrome = true,
			plugin = {"pretty","html:test-output.html"
			}
	)


public class Test_Runner {

	
}
