import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition {
	
//------------------------------------------------------------------------------------------//
// Following steps are for M2 Journey Management	

	Client client = new Client();
	Journey journey = new Journey();
	
	@Given("client name {string}")
	public void client_name(String name) {
	    client.setClientName(name);
	}

	@Given("start destination {string}")
	public void start_destination(String startDestination) {
	    journey.setStartDestination(startDestination);
	}

	@Given("end destination {string}")
	public void end_destination(String endDestination) {
	    journey.setEndDestination(endDestination);
	}

	@Given("cargo {string}")
	public void cargo(String cargo) {
	    journey.setCargo(cargo);
	}

	@When("register")
	public void register() {
	    journey.registerJourney(journey);
	}

	@Then("registration is true")
	public void registration_is_true() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("end destination is empty")
	public void end_destination_is_empty() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("registration is false")
	public void registration_is_false() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("trip desitnation {string}")
	public void trip_desitnation(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("company name {string}")
	public void company_name(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("trip origin is empty")
	public void trip_origin_is_empty() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("trip origin {string}")
	public void trip_origin(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("client name is empty")
	public void client_name_is_empty() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Given("cargo is empty")
	public void cargo_is_empty() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
				
}
