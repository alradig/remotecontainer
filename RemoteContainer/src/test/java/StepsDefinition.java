import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.util.List;

import LogisticCompany.App.ArchivableObject;
import LogisticCompany.App.Database;
import LogisticCompany.App.ResponseObject;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;

import static org.junit.Assert.assertFalse;

public class StepsDefinition {

//------------------------------------------------------------------------------------------//
// Following steps are for M2 Journey Management	

	Client client = new Client();
	ResponseObject response = new ResponseObject(100, "There is a problem");
	ClientForm clientForm;
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
	    container.setId(journey.getId());
	}

	@When("register")
	public void register() {
	    journey.registerJourney(journey, container);
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
	
	@Then("the journey is saved")
	public void the_journey_is_saved() {
	    journey.archive();
	}
	
//------------------------------------------------------------------------------------------//
// M2 Update journey feature

	@Given("date and local time")
	public void date_and_local_time() {
		journey.setCurrentDate();
	}

	@When("container has arrived in {string}")
	public void container_has_arrived_in(String currentLocation) {
	    journey.setCurrentLocation(currentLocation);
	    journey.updateJourneyInfo();
	}
	
	@Then("current position is added to journey")
	public void current_position_is_added_to_journey() {
	    
	}

	
//------------------------------------------------------------------------------------------------------------------------------//
	// Following steps are for M1	

/*
 * Register a new client
 */
	
	@Given("I have chosen to register a client")
	public void I_have_chosen_to_register_a_client(){
	   client.setRegister(true);
	   clientForm = new ClientForm(this.client);
	}

	@When("I enter the following client information:")
	public void i_enter_the_following_client_information(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> clientInfo = dataTable.asLists(String.class);
	    
	    this.clientForm.setNameField(clientInfo.get(1).get(1));
	    this.clientForm.setEmailField(clientInfo.get(1).get(2));
	    this.clientForm.setAddressField(clientInfo.get(1).get(3));
	    this.clientForm.setRefPersonField(clientInfo.get(1).get(4));
	    this.clientForm.setPwField(clientInfo.get(1).get(5)); 	

	}
	@When("I submit the form")
	public void I_submit_the_form() {
		response = clientForm.submit();
	}

	/*
	 * Step Definitions for Update a clients information
	 */
	@Given("the client:")
	public void a_client_with_the_following_information(DataTable dataTable) {
	    List<List<String>> clientInfo = dataTable.asLists(String.class);
	    
	    // Use the for loop for multiple clients
	    //for(int i=1; i<clientInfo.size(); i++) { //i=0 is the header
	    	this.client.setId(Integer.parseInt(clientInfo.get(1).get(0)));
	    	this.client.setName(clientInfo.get(1).get(1));
	        this.client.setEmail(clientInfo.get(1).get(2));
	        this.client.setAddress(clientInfo.get(1).get(3));
	        this.client.setRefPerson(clientInfo.get(1).get(4));
	        this.client.setPw(clientInfo.get(1).get(5)); 	

		//}
	}
	
	@Given("I have chosen to update the client information")
	public void i_have_chosen_to_update_a_client_information() {
		clientForm = new ClientForm(this.client);
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
		
	@Given("I enter the new client reference person as {string}")
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

	@Then("the client reference person should be {string}")
	public void the_client_Reference_person_should_be(String new_ref_person) {
		assertEquals(this.client.getRefPerson(),new_ref_person);
	}
	
	@Then("the client password should be {string}")
	public void the_client_password_should_be(String new_pw) {
		assertEquals(this.client.getPw(),new_pw);
	}
	
	@Then("I should see a success message")
	public void i_should_see_a_success_message() {
		assertEquals(this.response.getErrorCode(),200);
	}
	
	@Then("I should see an error message")
	public void i_should_see_an_error_message() {
		assertEquals(this.response.getErrorCode(),100);
	}
	
	//------------------------------------------------------------------------------------------------------------------------------//
		// Following steps are for M3	
	
	Container container = new Container();
	
	@Given("New internal temp of {string}")
	public void new_internal_temp_of(String string) {
	    container.addInTemp(string);
	}

	@Given("New air humidity of {string}")
	public void new_air_humidity_of(String string) {
	    container.addAirHum(string);
	}

	@Given("New atmosphere pressure of {string}")
	public void new_atmosph_pressure_of(String string) {
	    container.addAtmPre(string);
	}

	@Then("Values saved")
	public void values_saved() {
		container.isSaved();
	}	

	@Given("Container end-destination is true")
	public void container_end_destination_is_true() {
	    assertTrue(journey.endDestinationReached);
	}
	
	@When("Container end-destination is false")
	public void container_end_destination_is_false() {
		assertFalse(journey.endDestinationReached);
	   
	}
	
	@Then("Data reset")
	public void data_reset() {
	    container.ValsReset();
	}

	//------------------------------------------------------------------------------------------------------------------------------//
		// Following steps are for External Database feature	
	
	Database databaseHandler = new Database();
	ArchivableObject storedClient = new Client();
	ArchivableObject storedContainer = new Client();
	ArchivableObject storedJourney = new Client();
	
	@Given("I register the client")
	public void i_register_the_client(io.cucumber.datatable.DataTable dataTable) {
	    List<List<String>> clientInfo = dataTable.asLists(String.class);
	    
	    // creates the database structure if it doesn't yet exists
	    databaseHandler.createDatabaseStructure();
	    
	    clientForm = new ClientForm(this.client);
	    this.client.setId(Integer.parseInt(clientInfo.get(1).get(0)));
	    this.clientForm.setNameField(clientInfo.get(1).get(1));
	    this.clientForm.setEmailField(clientInfo.get(1).get(2));
	    this.clientForm.setAddressField(clientInfo.get(1).get(3));
	    this.clientForm.setRefPersonField(clientInfo.get(1).get(4));
	    this.clientForm.setPwField(clientInfo.get(1).get(5));
	    
	    response = clientForm.submit();
	    if (this.response.getErrorCode() == 200) {
	    	this.client.archive();
	    }
	    
	    assertEquals(this.response.getErrorCode(),200);
	}

	@Then("the client information should be in the external database")
	public void the_client_information_should_be_in_the_external_database() { 
		String filePath = "Clients/" + "Client_" + this.client.getId() + ".json";

		this.storedClient = databaseHandler.readFile(this.storedClient, filePath);

		assertEquals(true,this.client.equals(storedClient));
	}
	
}
