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
	
	@Given("the client email is {string}")
	public void the_client_email_is(String old_email) {
	    client.email = old_email;
	}

	@When("I enter the new email {string}")
	public void i_enter_the_new_email(String new_email) {
	    client.email = new_email;
	}

	@Then("the client email should be {string}")
	public void the_client_email_should_be(String new_email) {
		assertEquals(client.email,new_email);
	}
}
