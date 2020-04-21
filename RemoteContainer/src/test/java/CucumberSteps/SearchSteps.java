package CucumberSteps;

 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

 

import java.util.List;

 

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 

public class SearchSteps {
    
    private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
    public ClientHelper helper;
    private String errorMessage;
    
    private List<ClientInfo> clients;
    private List<JourneyInfo> journeys;
    
    public SearchSteps(LogisticCompanyApp logisticCompanyApp,ClientHelper helper) {

    	 this.logisticCompanyApp = logisticCompanyApp;
    	 this.helper = helper;

    	}

    @Given("these clients are in the system")
    public void these_clients_are_in_the_system(List<List<String>> clients) throws Exception {  
    	for (List<String> clientInfo : clients) {
    		try {
    			logisticCompanyApp.registerClient(new ClientInfo(clientInfo.get(0), clientInfo.get(1), clientInfo.get(2)));
    		} catch (Exception e) {
    			this.errorMessage = e.getMessage();
    		}
        }
    }

//    @Given("the logistic company logs out")
//    public void the_logistic_company_logs_out() throws Exception {
//        logisticCompanyApp.logisticCompanyLogout();
//    }

 

    @When("the logistic company search for {string}")
    public void the_logistic_company_search_for(String searchEmail) throws Exception {
        clients = logisticCompanyApp.searchClient(searchEmail);
    }

 

    @Then("the client {string} is found")
    public void the_client_is_found(String name) {
        assertEquals(1, clients.size());
        assertEquals(name, clients.get(0).getName());
    }
    
//    @Given("that the client {string} is logged in")
//    public void that_the_client_is_logged_in(String string) {
//        assertTrue(logisticCompanyApp.clientLogin("client123"));
//    }
    
    @Then("no client is found")
    public void no_client_is_found() {
        assertTrue(clients.isEmpty());
    }
    

 

    @Given("these journeys are in the system")
    public void these_journeys_are_in_the_system(List<List<String>> journeys) throws Exception {
        for (List<String> journeyInfo : journeys) {
            logisticCompanyApp.registerJourney(new JourneyInfo(journeyInfo.get(0), journeyInfo.get(1), journeyInfo.get(2)));
        }
    }
 

    @When("the client search for {string}")
    public void the_client_search_for(String searchCargo) throws Exception {
        journeys = logisticCompanyApp.searchJourney(searchCargo);
    }

 

    @Then("the journey with cargo {string}, start destination {string} and end destination {string} is found")
    public void the_journey_with_cargo_start_destination_and_end_destination_is_found(String cargo, String startDestination, String endDestination) {
        assertEquals(1, journeys.size());
        assertEquals(cargo, journeys.get(0).getCargo());
        assertEquals(startDestination, journeys.get(0).getStartDestination());
        assertEquals(endDestination, journeys.get(0).getEndDestination());
    }
    
    @Then("no journeys are found")
    public void no_journeys_are_found() {
        assertTrue(journeys.isEmpty());
    }
    
    @Then("journeys with start destination {string} and {string} are found")
    public void journeys_with_start_destination_and_are_found(String startDestination1, String startDestination2) {
        assertEquals(2, journeys.size());
        JourneyInfo journey1 = journeys.get(0);
        JourneyInfo journey2 = journeys.get(1);
        assertTrue((journey1.getStartDestination().equals(startDestination1) && journey2.getStartDestination().equals(startDestination2))
                || (journey1.getStartDestination().equals(startDestination2) && journey2.getStartDestination().equals(startDestination1)));
    
    }
}