package CucumberSteps;

import static org.junit.Assert.assertEquals;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class ContainerSteps {
	
	private JourneyInfo journeyInfo;
	private ContainerInfo containerInfo;
	private LogisticCompanyApp logisticCompanyApp;
	private String errorMessage;
	private Journey journey;
	
	public ContainerSteps(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
	}

	@Given("there is a journey with port of origin harbor {string} and destination {string}")
	public void there_is_a_journey_with_port_of_origin_harbor_and_destination(String Port_of_origin, String destination) {
		journeyInfo = new JourneyInfo(Port_of_origin,destination);
		assertEquals(journeyInfo.getStartDestination(),Port_of_origin);
		assertEquals(journeyInfo.getEndDestination(),destination);
	}

	@When("internal temperatur of {string} degrees, air humidity of {string} percent, and atmopshere pressure of {string} Pa")
	public void internal_temperatur_of_degrees_air_humidity_of_percent_and_atmopshere_pressure_of_Pa(String currentTemp, String currentAirHum, String currentAtmPre) {
		containerInfo = new ContainerInfo(currentTemp, currentAirHum, currentAtmPre);
		assertEquals(containerInfo.getCurrentTemp(),currentTemp);
		assertEquals(containerInfo.getCurrentAirHum(),currentAirHum);
		assertEquals(containerInfo.getCurrentAtmPre(),currentAtmPre);
	}

	@Then("new measurements are saved")
	public void new_measurements_are_saved() {
		// Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("internal temperatur of {string} degrees and air humidity of {string} percent")
	public void internal_temperatur_of_degrees_and_air_humidity_of_percent(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("new values are saved")
	public void new_values_are_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("there is a journey with cargo {string}, port of origin harbor {string} and destination  {string}")
	public void there_is_a_journey_with_port_of_origin_harbor_and_destination(String cargo, String Port_of_origin, String destination) throws Exception {
	   journeyInfo = new JourneyInfo(cargo, Port_of_origin,destination);
	   
	   assertEquals(journeyInfo.getStartDestination(),Port_of_origin);
	   assertEquals(journeyInfo.getEndDestination(),destination);
	   assertEquals(journeyInfo.getCargo(),cargo);
	}

	@Given("there is a container with content {string}")
	public void there_is_a_container_with_content(String content) throws Exception {
	containerInfo = new ContainerInfo(content);
	assertEquals(containerInfo.getCargo(),content);
	}
	
	@Given("there is an empty container")
	public void there_is_an_empty_container() {
		containerInfo = new ContainerInfo("");
	}

	@When("the client registers the container for the journey")
	public void the_client_registers_the_container_for_the_journey() {
		try {
			logisticCompanyApp.registerContainerToJourney(containerInfo, journeyInfo);
		} catch (Exception e) {
//			errorMessage.setErrorMessage(e.getMessage());
			this.errorMessage = e.getMessage();
		}
	}
	@Then("the container is a registered container for the journey")
	public void the_container_is_a_registered_container_for_the_journey() {
		Journey journey = logisticCompanyApp.findJourney(journeyInfo);
	    assertEquals(journey.getContainer().getCargo(), journey.getCargo());
	}
	
}
