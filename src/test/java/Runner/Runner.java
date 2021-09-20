package Runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ayko.driverSetup.DriverManager;

import io.cucumber.junit.Cucumber;
import io.cucumber.messages.Messages;
import io.cucumber.messages.Messages.Pickle;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", 
glue = {"com.ayko.stepDefinition"})
public class Runner extends AbstractTestNGCucumberTests {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	
	@BeforeClass(alwaysRun = true)
	public void setUpCucumber() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
}
