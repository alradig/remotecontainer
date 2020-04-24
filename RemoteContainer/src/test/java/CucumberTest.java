import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/main/resources")
//		features = "src/main/resources/ClientViewOwnInformation.feature")

public class CucumberTest {

}