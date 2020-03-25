import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
public class StepsDefinition {
	Client client = new Client();
	@Given("I have chosen to register a client")
	public void I_have_chosen_to_register_a_client(){
	   client.setRegister(true);
	}

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
