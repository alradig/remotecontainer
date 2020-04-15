import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import LogisticCompany.App.ArchivableObject;
import LogisticCompany.App.ClientRepository;
import LogisticCompany.App.ContainerRepository;
import LogisticCompany.App.Database;
import LogisticCompany.App.JourneyRepository;
import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.ResponseObject;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.InMemoryRepository;
import dtu.library.acceptance_tests.helper.ErrorMessageHolder;
import dtu.library.dto.UserInfo;
import LogisticCompany.domain.Address;
import LogisticCompany.domain.Container;
import LogisticCompany.info.ContainerInfo;
public class StepsDefinition {

//------------------------------------------------------------------------------------------//
// Following steps are for M2 Journey Management
	private ContainerInfo ContainerInfo;
	private JourneyInfo JourneyInfo;
	private ClientInfo client;
	private ResponseObject response = new ResponseObject(100, "There is a problem");
	private ClientForm clientForm;
	private Journey journey = new Journey();
	private LogisticCompany.domain.Address address;
	private ClientRepository clientRepository;
	private InMemoryRepository repository = new InMemoryRepository();
	
//	LogisticCompanyApp(ClientRepository clientRepository, JourneyRepository journeyRepository, ContainerRepository containerRepository )
	private String errorMessage;
	
	private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
	
	/*
	 * NEW REGISTER CONTAINER
	 */
	
	@Given("a client is logged in")
	public void a_client_is_logged_in() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("there is a journey with port of origin harbor {string} and destination  {string}")
	public void there_is_a_journey_with_port_of_origin_harbor_and_destination(String Port_of_origin, String destination) throws Exception {
	   JourneyInfo = new JourneyInfo(Port_of_origin,destination);
	   
	}

	@Given("there is a container with content {string}")
	public void there_is_a_container_with_content(String content) throws Exception {
	ContainerInfo = new ContainerInfo(content);
	}

	@When("the client registers the container for the journey")
	public void the_client_registers_the_container_for_the_journey() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the container is a registered container for the journey")
	public void the_container_is_a_registered_container_for_the_journey() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
/*
 * OLD
 */
	
	
	
	
	
	
	
	
	@Given("client name {string}")
	public void client_name(String name) {
	    this.client.setName(name);
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
	@Given("the administrator is logged in")
	public void the_administrator_is_logged_in()  throws Exception {
		assertTrue(logisticCompanyApp.logisticCompanyLogin("logisticCompany123"));
	}
	

	@Then("the client is registered in the system")
	public void the_client_is_registered_in_the_system() {
	    Optional<ClientInfo> usr = logisticCompanyApp.getClientsStream().findFirst();
	    assertTrue(usr.isPresent());
	    ClientInfo c = usr.get();
	    assertEquals(client.getName(), c.getName());
	    assertEquals(client.getEmail(), c.getEmail());
	    assertEquals(client.getReference_person(), c.getReference_person());
	}


	@Given("There is a client with name {string}, email {string}, reference person {string}, password {string}")
	public void there_is_a_client_with_name_email_reference_person_password(String name, String email, String ref_person, String password) {
	   client = new ClientInfo(name, email, ref_person, password);
	   
	    
	    assertEquals(client.getName(),name);
	    assertEquals(client.getEmail(),email);
	    assertEquals(client.getReference_person(),ref_person);
	    assertEquals(client.getPassword(),password);
	}

	@Given("the client address is {string}, {int}, {string}")
	public void the_client_address_is(String street, int postcode, String city) {
		this.address = new Address(street,postcode,city);
		this.client.setAddress(address);
		
		assertEquals(client.getAddress().getStreet(),street);
		assertEquals(client.getAddress().getPostCode(),postcode);
		assertEquals(client.getAddress().getCity(),city);	
	}
	
	@When("the administrator registers the client")
	public void the_administrator_registers_the_client() {
		try {
			this.logisticCompanyApp.registerClient(client);
		} catch (Exception e) {
//			errorMessage.setErrorMessage(e.getMessage());
			errorMessage = e.getMessage();
			System.out.println(errorMessage);
		}
	}
	
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
