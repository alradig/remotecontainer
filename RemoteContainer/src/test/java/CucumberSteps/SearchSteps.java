package CucumberSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {
	
	private InMemoryRepository repository = new InMemoryRepository();
	
	private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
	
	private List<ClientInfo> clients;
	
	@Given("that the logistic company is logged in")
	public void that_the_logistic_company_is_logged_in() throws Exception  {
		assertTrue(logisticCompanyApp.logisticCompanyLogin("logisticCompany123"));
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
		clients = logisticCompanyApp.searchClient(searchEmail);
	}

	@Then("the client {string} is found")
	public void the_client_is_found(String name) {
		assertEquals(1, clients.size());
		assertEquals(name, clients.get(0).getName());
	}

}
   




