package CucumberSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;
import dtu.library.dto.MediumInfo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	
	private LogisticCompanyApp logisticCompanyApp;
	private List<ClientInfo> client;
	
	@Given("that the logistic company is logged in")
	public void that_the_logistic_company_is_logged_in() {
		assertTrue(logisticCompanyApp.logisticCompanyLoggedIn());
	}

	@Given("these clients are in the system")
	public void these_clients_are_in_the_system(List<List<String>> clients) throws Exception {
		for (List<String> clientInfo : clients) {
			logisticCompanyApp.registerClient(new ClientInfo(clientInfo.get(0), clientInfo.get(1), clientInfo.get(2)));
		}
	}

	@Given("the logistic company logs out")
	public void the_logistic_company_logs_out() throws Exception {
		logisticCompanyApp.logisticCompanyLogout();
	}

	@When("the logistic company search for {string}")
	public void the_logistic_company_search_for(String searchEmail) throws Exception {
		client = logisticCompanyApp.searchClient(searchEmail);
	}

	@Then("the client {string} is found")
	public void the_client_is_found(String string) {
		assertEquals(1, client.size());
		assertEquals(email, client.get(0).getSignature());
	}

}
   




