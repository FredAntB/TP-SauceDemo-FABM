import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/home.feature",
        glue = {"StepDefinitions"},
        tags = "@run"
)
public class TestRunner {
}
