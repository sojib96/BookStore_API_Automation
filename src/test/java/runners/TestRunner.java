package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"./src/test/java/features/"},
        glue={"stepdefinations"},
        plugin = {"pretty", "io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
