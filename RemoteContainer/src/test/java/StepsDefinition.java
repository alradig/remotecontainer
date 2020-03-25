import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
public class StepsDefinition {

	
//------------------------------------------------------------------------------------------//
// Following steps are for M2 Journey Management	
	Client client = new Client();
	@Given("I have chosen to register a client")
	public void I_have_chosen_to_register_a_client(){
	   client.setRegister(true);
	   
	}

	@Given("Client with journey of {string}")
	public void client_with_journey_of(String string) {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("A start destination {string}")
	public void a_start_destination(String string) {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("A end destination {string}")
	public void a_end_destination(String string) {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the journey registered as true")
	public void the_journey_registered_as_true() {
	// Write code here that turns the phrase above into concrete actions
		   throw new io.cucumber.java.PendingException();
	}

	@When("Searching for journey")
	public void searching_for_journey() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Journey is displayed")
	public void journey_is_displayed() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("the journey registered as false")
	public void the_journey_registered_as_false() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("system displays that journey is not registered")
	public void system_displays_that_journey_is_not_registered() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("client {string}")
	public void client(String string) {
	// Write code here that turns the phrase above into concrete actions
	throw new io.cucumber.java.PendingException();
	}

	@Given("a trip origin {string}")
	public void a_trip_origin(String string) {
	// Write code here that turns the phrase above into concrete actions
	throw new io.cucumber.java.PendingException();
	}

	@When("Register")
	public void register() {
	// Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
	}

	@Then("Client gets assigned an empty container")
	public void client_gets_assigned_an_empty_container() {
	// Write code here that turns the phrase above into concrete actions
	throw new io.cucumber.java.PendingException();
	}

	@Given("a content {string}")
	public void a_content(String string) {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	
	@Given("End destination is not provided")
	public void end_destination_is_not_provided() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("trip origin is not provided")
	public void trip_origin_is_not_provided() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Client information not provided")
	public void client_information_not_provided() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("a content is not provided")
	public void a_content_is_not_provided() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("unable to register container")
	public void unable_to_register_container() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}


	@Given("a company name {string}")
	public void a_company_name(String string) {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("a conent {string}")
	public void a_conent(String string) {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("a trip desitnation {string}")
	public void a_trip_desitnation(String string) {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Container has arrived in {string}")
	public void container_has_arrived_in(String string) {
		 // Write code here that turns the phrase above into concrete actions
		 throw new io.cucumber.java.PendingException();
	}

	@Given("Container end-destination is false")
	public void container_end_destination_is_false() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("Update")
	public void update() {
	// Write code here that turns the phrase above into concrete actions
	throw new io.cucumber.java.PendingException();
	}

	@Then("Current position is added to journey")
	public void current_position_is_added_to_journey() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Given("Container end-destination is true")
	public void container_end_destination_is_true() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Journey is done")
	public void journey_is_done() {
	// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}
	
//------------------------------------------------------------------------------------------//
// Following steps are for M1 
	@Given("I am about to enter the client information")
	public void I_am_about_to_enter_the_client_information() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I do not enter the clients name")
	public void i_do_not_enter_the_clients_name() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I do not enter the clients email")
	public void i_do_not_enter_the_clients_email() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@When("I do not enter the clients address")
	public void i_do_not_enter_the_clients_address() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I do not enter the clients reference person")
	public void i_do_not_enter_the_clients_reference_person() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I submit the form")
	public void I_submit_the_form() {

	}

	@Then("the form should be redisplayed")
	public void the_form_should_be_redisplayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("I should be asked if I want to submit it anyway")
	public void i_should_be_asked_if_I_want_to_submit_it_anyway() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("I should see a message advising me that the clients email is required")
	public void i_should_see_a_message_advising_me_that_the_clients_email_is_required() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see a message advising me that the clients address is missing")
	public void i_should_see_a_message_advising_me_that_the_clients_address_is_missing() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see a message advising me that the clients reference person is missing")
	public void i_should_see_a_message_advising_me_that_the_clients_reference_person_is_missing() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

}
