import io.cucumber.java.en.Given;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class StepsDefinition {

//------------------------------------------------------------------------------------------//
// Following steps are for M2 Journey Management	

	Client client = new Client();
	ResponseObject response = new ResponseObject("There is a problem");
	@Given("I have chosen to register a client")
	public void I_have_chosen_to_register_a_client(){

	   client.setRegister(true);

	}

	Journey journey = new Journey();
	
	@Given("client name {string}")
	public void client_name(String name) {
	    client.setName(name);
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
		assertTrue(journey.getRegistrationStatus());
	}

	@Given("end destination is empty")
	public void end_destination_is_empty() {
		assertTrue(journey.endDestinationIsEmpty(journey));
	}

	@Then("registration is false")
	public void registration_is_false() {
		assertFalse(journey.getRegistrationStatus());
	}

	@Given("cargo is empty")
	public void cargo_is_empty() {
	   assertTrue(journey.cargoIsEmpty(journey));
	}
	
	@Given("start destination is empty")
	public void start_destination_is_empty() {
	   assertTrue(journey.startDestinationIsEmpty(journey));
	}
//------------------------------------------------------------------------------------------------------------------------------//
	// Following steps are for M1	


	@Given("I am about to enter the client information")
	public void I_am_about_to_enter_the_client_information() {   
	}

	@When("I do not enter the clients name")
	public void i_do_not_enter_the_clients_name() {
	    if ((client.getName()).isEmpty()) {
	    	response.setErrorMessage("You haven't set a name.");
	    }
	}

	@When("I do not enter the clients email")
	public void i_do_not_enter_the_clients_email() {
		if ((client.getEmail()).isEmpty()) {
	    	response.setErrorMessage("You haven't set an email.");
		 }
			}
	@When("I do not enter the clients address")
	public void i_do_not_enter_the_clients_address() {
		if ((client.getAddress()).isEmpty()) {
	    	response.setErrorMessage("You haven't set an adress.");
		 }
			}

	@When("I do not enter the clients reference person")
	public void i_do_not_enter_the_clients_reference_person() {
		if ((client.getRefPerson()).isEmpty()) {
	    	response.setErrorMessage("You haven't set a ref person");
		 }
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
	
	@Then("I should see a message advising me that the clients name is required")
	public void i_should_see_a_message_advising_me_that_the_clients_name_is_required() {
		assertEquals(response.getErrorMessage(),"You haven't set a name.");
	}
		
	@Then("I should see a message advising me that the clients email is required")
	public void i_should_see_a_message_advising_me_that_the_clients_email_is_required() {
		assertEquals(response.getErrorMessage(),"You haven't set an email.");
	}

	@Then("I should see a message advising me that the clients address is missing")
	public void i_should_see_a_message_advising_me_that_the_clients_address_is_missing() {
		assertEquals(response.getErrorMessage(),"You haven't set an adress.");
	}

	@Then("I should see a message advising me that the clients reference person is missing")
	public void i_should_see_a_message_advising_me_that_the_clients_reference_person_is_missing() {
		assertEquals(response.getErrorMessage(),"You haven't set a ref person");
	}
	
}
