package CucumberSteps;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.ContainerStatusEntry;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class ContainerSteps {
	
	public JourneyInfo journeyInfo;
	private ContainerInfo containerInfo;
	private LogisticCompanyApp logisticCompanyApp;
	private String errorMessage;
	private Journey journey;
	private ClientInfo clientInfo;
	public ClientHelper helper;
	


	private ContainerStatusEntry containerStatus;

	public JourneyHelper journeyHelper;
	public ContainerHelper containerHelper;

	public ContainerSteps(LogisticCompanyApp logisticCompanyApp, ClientHelper helper, JourneyHelper journeyHelper, ContainerHelper containerHelper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.helper = helper;
		this.journeyHelper=journeyHelper;
		this.containerHelper = containerHelper;
	}
	
	@Given("there is an existing journey and container") 
	public void there_is_an_existing_journey_and_container() throws Exception  {
		journeyInfo = journeyHelper.registerExampleJourney();
		containerInfo = containerHelper.registerExampleContainer();
//	    List <ContainerInfo>  list = logisticCompanyApp.searchContainer(containerInfo.getCargo());
//		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
//		containerInfo = containerHelper.getContainer();
//		logisticCompanyApp.registerContainer(containerInfo);
//		journeyInfo = helperJourney.getJourney();
		
//		
//		try {
//			logisticCompanyApp.registerJourney(journeyInfo);
//			logisticCompanyApp.registerContainerToJourney(containerInfo, journeyInfo);
//			
//		}
//		catch(Exception e) {
//			 this.errorMessage = e.getMessage();
//		}
//		logisticCompanyApp.registerJourneyToClient(helper.getClient(), journeyInfo);
	}
	
	@When("internal temperatur of {string} degrees, air humidity of {string} percent, and atmopshere pressure of {string} Pa")
	public void internal_temperatur_of_degrees_air_humidity_of_percent_and_atmopshere_pressure_of_Pa(String currentTemp, String currentAirHum, String currentAtmPre) {
		containerStatus = new ContainerStatusEntry(currentTemp, currentAirHum, currentAtmPre);
		
		assertEquals(containerStatus.getTemperature(),currentTemp);
		assertEquals(containerStatus.getAirHumidity(),currentAirHum);
		assertEquals(containerStatus.getAtmPressure(),currentAtmPre);
	}

	@Then("new measurements {string}, {string}, {string} are saved")
	public void new_measurements_are_saved(String currentTemp, String currentAirHum, String currentAtmPre) throws Exception {
		
		Container container = logisticCompanyApp.findContainer(containerInfo);
		logisticCompanyApp.addMeasurements(container, containerStatus);
		
		Optional<ContainerStatusEntry> csStream = container.getContainerStatusListStream().findFirst();
	    assertTrue(csStream.isPresent());
	    ContainerStatusEntry cs = csStream.get();
	    
	    assertEquals(containerStatus.getTemperature(), cs.getTemperature());
	    assertEquals(containerStatus.getAtmPressure(), cs.getAtmPressure());
	    assertEquals(containerStatus.getAirHumidity(), cs.getAirHumidity());
	}

	@Given("the client registers a journey with cargo {string}, port of origin harbor {string} and destination  {string}")
	public void the_client_registers_a_journey_with_cargo_port_of_origin_harbor_and_destination(String cargo, String Port_of_origin, String destination) throws Exception {
		journeyInfo = new JourneyInfo(cargo, Port_of_origin,destination);   

	   try {
			logisticCompanyApp.registerJourney(journeyInfo);
	   } catch (Exception e) {
			this.errorMessage = e.getMessage();
	   }
	   
	   logisticCompanyApp.registerJourneyToClient(helper.getClient(), journeyInfo);
		
	   assertEquals(journeyInfo.getOriginPort(),Port_of_origin);
	   assertEquals(journeyInfo.getDestinationPort(),destination);
	   assertEquals(journeyInfo.getCargo(),cargo);
	   
	   List <ClientInfo>  list = logisticCompanyApp.searchClient(helper.getClient().getEmail());
		
	   assertEquals(list.get(0).getJourneys().get(0).getCargo(),cargo);
	   assertEquals(list.get(0).getJourneys().get(0).getStartDestination() ,Port_of_origin);
	   assertEquals(list.get(0).getJourneys().get(0).getEndDestination() ,destination);

	
	   
	}

	@Given("there is a container with content {string}")
	public void there_is_a_container_with_content(String content) throws Exception {
	containerInfo = new ContainerInfo(content);
	assertEquals(containerInfo.getCargo(),content);
	}
	
	@Given("there is an empty container")
	public void there_is_an_empty_container() {
		containerInfo = new ContainerInfo("empty");
		try {
			logisticCompanyApp.registerContainer(containerInfo);
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
	}
	
	@When("the logistic company registers the container for the journey")
	public void the_logistic_company_registers_the_container_for_the_journey() throws OperationNotAllowedException {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		
		try {
			logisticCompanyApp.registerContainerToJourney(containerInfo, journeyInfo);
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
		
		logisticCompanyApp.logisticCompanyLogout();
		
		Journey journey = logisticCompanyApp.findJourney(journeyInfo);
	    assertEquals(journey.getContainer().getCargo(), journey.getCargo());
	    
		List <JourneyInfo>  list = logisticCompanyApp.searchJourney(journeyInfo.getCargo());
		assertEquals(list.get(0).getContainers().get(0).getCargo(),journey.getCargo());	
		
	    
	    
	}
	
	@When("the journey is a registered journey for the client")
	public void the_journey_is_a_registered_journey_for_the_client() {
		Client clientObj = logisticCompanyApp.findClient(helper.getClient());
		
		List<Journey> journeys = clientObj.getJourneyList();
		
		Optional<Journey> jrn = journeys.stream().filter(j -> j.getCargo().equals(journeyInfo.getCargo())).findFirst();
	    assertTrue(jrn.isPresent());
	    Journey j = jrn.get();
		
		assertEquals(journeyInfo.getOriginPort(),j.getStartDestination());
		assertEquals(journeyInfo.getDestinationPort(),j.getEndDestination());
		assertEquals(journeyInfo.getCargo(),j.getCargo());
	}
	
}
