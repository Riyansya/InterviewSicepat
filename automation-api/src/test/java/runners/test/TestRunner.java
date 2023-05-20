package runners.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static constant.ServicesConstant.SERVICES_TEST;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {
                "src/test/resources/services/test/Test.feature"
        },
        glue = SERVICES_TEST,
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunner {
}