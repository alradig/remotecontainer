import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import static org.junit.Assert.assertFalse;

public class StepsDefinition {

//------------------------------------------------------------------------------------------//
// Following steps are for M2 Journey Management	

	Client client = new Client();
	ResponseObject response = new ResponseObject(100, "There is a problem");
	ClientForm clientForm = new ClientForm(this.client);
	
	
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
		
		client.setAddress("bla");
		client.setEmail("sjssjj@sjsj");
		client.setName("Peter");
		client.setRefPerson("Mama");
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
		response = clientForm.submit();
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
	
	@Given("the client:")
	public void a_client_with_the_following_information(DataTable dataTable) {
	    List<List<String>> clientInfo = dataTable.asLists(String.class);
	    
	    System.out.println(Integer.parseInt(clientInfo.get(1).get(0)));
	    
	    // Use the for loop for multiple clients
	    //for(int i=1; i<clientInfo.size(); i++) { //i=0 is the header
	    	this.client.setId(Integer.parseInt(clientInfo.get(1).get(0)));
	    	this.clientForm.setNameField(clientInfo.get(1).get(1));
	        this.clientForm.setEmailField(clientInfo.get(1).get(2));
	        this.clientForm.setAddressField(clientInfo.get(1).get(3));
	        this.clientForm.setRefPersonField(clientInfo.get(1).get(4));
	        this.clientForm.setPw(clientInfo.get(1).get(5)); 	
	        
	        this.clientForm.submit();
		//}
	}
	
	@Given("I have chosen to update a client information")
	public void i_have_chosen_to_update_a_client_information() {
		
	}

	@Given("I am about to enter the client new information")
	public void i_am_about_to_enter_the_client_new_information() {
		
	}

	@When("I enter the new client name as {string}")
	public void i_enter_the_new_name(String new_name) {
		this.clientForm.setNameField(new_name);
	}

	@When("I enter the new client email as {string}")
	public void i_enter_the_new_email(String new_email) {
		this.clientForm.setEmailField(new_email);
	}
	
	@Given("I enter the new client address as {string}")
	public void i_enter_the_new_address_as(String new_address) {
	    this.clientForm.setAddressField(new_address);
	}
		
	@Given("I enter the new client Reference person as {string}")
	public void i_enter_the_new_Reference_person_as(String new_ref_person) {
		this.clientForm.setRefPersonField(new_ref_person);
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
	
	@Then("I should see a success message")
	public void i_should_see_a_success_message() {
		System.out.println("Entered here 1!");
		assertEquals(this.response.getErrorCode(),200);
	}
	
	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		System.out.println("Entered here 2!");
		assertEquals(this.response.getErrorCode(),100);
	}
	
}
