package CucumberSteps;

import static org.junit.Assert.assertEquals;

import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


public class ContainerSteps {
	
	private JourneyInfo journeyInfo;
	private ContainerInfo containerInfo;

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
	
}
