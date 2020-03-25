
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsDefM3 {
		
	public static List<String> InTemp;
	public static List<String> AirHum;
	public static List<String> AtmPre;
	
	@Given("Container end-destination is false")
	public void container_end_destination_is_false() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Register")
	public void register() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("New internal temp of {string}")
	public void new_internal_temp_of(String string) {
	    // Write code here that turns the phrase above into concrete actions
		InTemp.add(string);
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Internal temperature is saved")
	public void internal_temperature_is_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("New air humidity of {string}")
	public void new_air_humidity_of(String string) {
	    // Write code here that turns the phrase above into concrete actions
		AirHum.add(string);
	    throw new io.cucumber.java.PendingException();
	}
	
	@Then("Air humidity is saved")
	public void air_humidity_is_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("New atmosph pressure of {string}")
	public void new_atmosph_pressure_of(String string) {
	    // Write code here that turns the phrase above into concrete actions
		AtmPre.add(string);
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Atmosph pressure is saved")
	public void atmosph_pressure_is_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	@Given("Container has arrived in {string}")
	public void container_has_arrived_in(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("Container end-destination is true")
	public void container_end_destination_is_true() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("Data reset")
	public void data_reset() {
	    // Write code here that turns the phrase above into concrete actions
		InTemp.clear();
		AirHum.clear();
		AtmPre.clear();
	    throw new io.cucumber.java.PendingException();
	}
	    
	@Then("Journey is done")
	public void journey_is_done() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
