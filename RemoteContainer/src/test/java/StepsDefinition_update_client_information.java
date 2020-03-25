import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefinition_update_client_information {
	
	Client client = new Client();
	List<List<String>> clientInfo;
	
	@Given("the client:")
	public void a_client_with_the_following_information(DataTable dataTable) {
	    List<List<String>> clientInfo = dataTable.asLists(String.class);
	    
	    // Use the for loop for multiple clients
	    //for(int i=1; i<clientInfo.size(); i++) { //i=0 is the header
	    
	    	this.client.setId(Integer.parseInt(clientInfo.get(1).get(0)));
	    	this.client.setName(clientInfo.get(1).get(1));
	        this.client.setEmail(clientInfo.get(1).get(2));
	        this.client.setAdress(clientInfo.get(1).get(3));;
	        this.client.setRefPerson(clientInfo.get(1).get(4));;
	        this.client.setPw(clientInfo.get(1).get(5));;
	    	
		//}
	}
	
	@Given("I have chosen to update a client information")
	public void i_have_chosen_to_update_a_client_information() {
		
	}

	@Given("I am about to enter the client new information")
	public void i_am_about_to_enter_the_client_new_information() {
		
	}

	@When("I enter the new name as {string}")
	public void i_enter_the_new_name(String new_name) {
	    client.name = new_name;
	}

	@When("I enter the new email as {string}")
	public void i_enter_the_new_email(String new_email) {
	    client.email = new_email;
	    this.client.setEmail(new_email);
	}
	
	@Given("I enter the new address as {string}")
	public void i_enter_the_new_address_as(String new_address) {
	    this.client.setAdress(new_address);
	}
		
	@Given("I enter the new Reference person as {string}")
	public void i_enter_the_new_Reference_person_as(String new_ref_person) {
	    this.client.setRefPerson(new_ref_person);
	}

	@Then("the client name should be {string}")
	public void the_client_name_should_be(String correct_name) {
	    assertEquals(this.client.getName(),correct_name);
	}

	@Then("the client email should be {string}")
	public void the_client_email_should_be(String new_email) {
		assertEquals(this.client.getEmail(),new_email);
	}
	
	@Then("the client address should be {string}")
	public void the_client_address_should_be(String new_address) {
		assertEquals(this.client.getAddress(),new_address);
	}

	@Then("the client Reference person should be {string}")
	public void the_client_Reference_person_should_be(String new_ref_person) {
		assertEquals(this.client.getRefPerson(),new_ref_person);
	}
	
}
