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

import LogisticCompany.domain.Address;
import LogisticCompany.domain.Container;
import LogisticCompany.info.ContainerInfo;
public class StepsDefinition {

//------------------------------------------------------------------------------------------//
// Following steps are for M2 Journey Management
	private ContainerInfo containerInfo;
	private JourneyInfo journeyInfo;
	private ClientInfo clientInfo;
	private ResponseObject response = new ResponseObject(100, "There is a problem");
	private ClientForm clientForm;
	private Journey journey = new Journey();
	
//	LogisticCompanyApp(ClientRepository clientRepository, JourneyRepository journeyRepository, ContainerRepository containerRepository )
	private String errorMessage;
	
	private LogisticCompanyApp logisticCompanyApp;
	
	public StepsDefinition(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
	}
	
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
	   journeyInfo = new JourneyInfo(Port_of_origin,destination);
	   assertEquals(journeyInfo.getStartDestination(),Port_of_origin);
	   assertEquals(journeyInfo.getEndDestination(),destination);
	   
	}

	@Given("there is a container with content {string}")
	public void there_is_a_container_with_content(String content) throws Exception {
	containerInfo = new ContainerInfo(content);
	assertEquals(containerInfo.getCargo(),content);
	}
	
/*
 * OLD
 */
	@Given("client name {string}")
	public void client_name(String name) {
	    this.clientInfo.setName(name);
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

	

	@Given("the administrator is logged in")
	public void the_administrator_is_logged_in()  throws Exception {
		assertTrue(logisticCompanyApp.logisticCompanyLogin("logisticCompany123"));
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
	    
	    clientForm = new ClientForm(this.clientInfo);
	    this.clientInfo.setId(Integer.parseInt(clientInfo.get(1).get(0)));
	    this.clientForm.setNameField(clientInfo.get(1).get(1));
	    this.clientForm.setEmailField(clientInfo.get(1).get(2));
	    this.clientForm.setAddressField(clientInfo.get(1).get(3));
	    this.clientForm.setRefPersonField(clientInfo.get(1).get(4));
	    this.clientForm.setPwField(clientInfo.get(1).get(5));
	    
	    response = clientForm.submit();
	    if (this.response.getErrorCode() == 200) {
	    	this.clientInfo.archive();
	    }
	    
	    assertEquals(this.response.getErrorCode(),200);
	}

	@Then("the client information should be in the external database")
	public void the_client_information_should_be_in_the_external_database() { 
		String filePath = "Clients/" + "Client_" + this.clientInfo.getId() + ".json";

		this.storedClient = databaseHandler.readFile(this.storedClient, filePath);

		assertEquals(true,this.clientInfo.equals(storedClient));
	}
	
}
