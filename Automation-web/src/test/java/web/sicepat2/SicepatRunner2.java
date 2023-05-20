package web.sicepat2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import static constant.ServicesConstant.SERVICES_SICEPAT;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {
                "src/test/resources/Services/web/sicepat2/LoginTest2.feature"

        },
        glue = SERVICES_SICEPAT,
        plugin = {
                "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class SicepatRunner2 {
}