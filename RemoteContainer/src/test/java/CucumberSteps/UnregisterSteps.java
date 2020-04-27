package CucumberSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.ClientInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UnregisterSteps {
	
	private LogisticCompanyApp logisticCompanyApp;
	private ClientInfo clientInfo;
	
	private String errorMessage;
	public ClientHelper clientHelper;
	public String password;
	private Client cl;
	
	public UnregisterSteps() {
	}

	@Given("the client has info {string}, email {string}, reference person {string}")
	 public void the_client_has_info_email_reference_person(String name, String email, String ref_person) {
		clientInfo = new ClientInfo(name, email, ref_person);
	}
	
	@Given("the client is found")
	public void the_client_is_found(){
		try {
			Client cl = logisticCompanyApp.findClient(clientInfo);
			assertEquals(cl.getPassword(), password);
		} catch (Exception e) { 
			the_client_is_not_found();
		}
	}
	
	@Given("the client is not found")
	public void the_client_is_not_found() {
		this.errorMessage = "The client is not registered or error in the information provided";
	}
	
	@Given("the client has password {string}")
	public void the_client_has_password(String password) {
		this.password = password;
	}

	@Then("the client is unregistered from the system")
	public void the_client_is_unregistered_from_the_system() throws Exception {
		try {
			for (Journey journey : cl.getJourneyList()) {
				assertFalse(logisticCompanyApp.isJourneyDone(journey.asJourneyInfo()));
				logisticCompanyApp.unregisterClient(clientInfo, journey.asJourneyInfo());
			}
		} catch (Exception e) { 
			the_client_is_not_found();
		}
	}
	
	@Then("the system sends the error {string}")
	public void the_system_sends_the_error(String error) {
	    assertEquals(error,errorMessage);
	}
}

	