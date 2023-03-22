package testRunners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class) >> Need this only with junit FW
@CucumberOptions(
		features = {"src/test/resources/appFeatures"},
		glue = {"stepDefinitions", "appHooks"},
		plugin = {"pretty",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"timeline:test-output-thread/",
				"rerun:target/failed-rerun.txt"
				},
		tags = "@excel or @login"
		)
public class TestRunner extends AbstractTestNGCucumberTests {
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
}

//Command Line build task >> mvn test "-DargLine=-Dcucumber.filter.tags='@smoke and not @norun'"