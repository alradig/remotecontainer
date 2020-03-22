import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition_update_client_information {
	
	Client client = new Client();
	
	@Given("I have chosen to update a client information")
	public void i_have_chosen_to_update_a_client_information() {
		
	}

	@Given("I am about to enter the client new information")
	public void i_am_about_to_enter_the_client_new_information() {
		
	}

	@Given("the client name is {string}")
	public void the_client_name_is(String string) {
	    client.name = string;
	}

	@When("I enter the new name {string}")
	public void i_enter_the_new_name(String new_name) {
	    client.name = new_name;
	}

	@Then("the client name should be {string}")
	public void the_client_name_should_be(String correct_name) {
	    assertEquals(client.name,correct_name);
	}

	@Then("I should see a message telling me {string}")
	public void i_should_see_a_message_telling_me_that_the_clients_name_was_successfully_updated(String message) {
		System.out.println(message);
	}
}
