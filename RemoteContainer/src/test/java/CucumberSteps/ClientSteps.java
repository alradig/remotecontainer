package CucumberSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientSteps {
	
	private LogisticCompanyApp logisticCompanyApp;
	private ClientInfo clientInfo;
	
	private String errorMessage;
	private Address address;
	public ClientHelper clientHelper;
	private JourneyHelper journeyHelper;
	private ContainerHelper containerHelper;
	private Client client;
	private List<Container> containersList;
	
	public ClientSteps(LogisticCompanyApp logisticCompanyApp, ClientHelper helper, JourneyHelper journeyHelper,ContainerHelper containerHelper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.clientHelper = helper;
		this.journeyHelper = journeyHelper;
		this.containerHelper = containerHelper;
	}
	
	@Given("there is a client with name {string}, email {string}, reference person {string}")

	 public void there_is_a_client_with_name_email_reference_person_password(String name, String email, String ref_person) {
		clientInfo = new ClientInfo(name, email, ref_person);
		
	    assertEquals(clientInfo.getName(),name);
	    assertEquals(clientInfo.getEmail(),email);
	    assertEquals(clientInfo.getReference_person(),ref_person);
	}
	
	@Given("there is a client registered in the system")
	public void there_is_a_client_registered_in_the_system() throws OperationNotAllowedException {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");

		clientInfo = clientHelper.getClient();
		try {
			clientHelper.registerExampleClient();
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
		logisticCompanyApp.logisticCompanyLogout();
	}
	
	@Given("the client address is {string}, {string}, {string}")
	public void the_client_address_is(String street, String postcode, String city) throws OperationNotAllowedException {
		this.address = new Address(street,postcode,city);
		this.clientInfo.setAddress(address);
		
		assertEquals(clientInfo.getAddress().getStreet(),street);
		assertEquals(clientInfo.getAddress().getPostCode(),postcode);
		assertEquals(clientInfo.getAddress().getCity(),city);	
		
		

	}

	
	@Given("the client has registered journeys")
	public void the_client_has_registered_journeys() throws OperationNotAllowedException {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		
		clientInfo = clientHelper.getClient();
		
		journeyHelper.registerMultipleJourneys();
		List<JourneyInfo> journeysList = journeyHelper.getMultipleJourneys();
		List<ContainerInfo> containersList = containerHelper.getMultipleContainers();
		
		try {
			containerHelper.registerMultipleContainers();
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
		
		
		for (int i=0; i < 3; i++) {
			try {
				logisticCompanyApp.registerJourneyToClient(clientInfo, journeysList.get(i));
				logisticCompanyApp.registerContainerToJourney(containersList.get(i), journeysList.get(i));
			} catch (OperationNotAllowedException e) {
				this.errorMessage = e.getMessage();
			}
		}
		
		logisticCompanyApp.logisticCompanyLogout();
		
		List <ClientInfo>  list = logisticCompanyApp.searchClient(clientInfo.getEmail());
		
		assertEquals(list.get(0).getAddress().getCity(),clientInfo.getAddress().getCity());
		assertEquals(list.get(0).getAddress().getStreet(),clientInfo.getAddress().getStreet());
		assertEquals(list.get(0).getAddress().getPostCode(),clientInfo.getAddress().getPostCode());
		
	}
	
	@When("the client looks for all his\\/her containers")
	public void the_client_looks_for_all_his_her_containers() {
		containersList = logisticCompanyApp.getClientContainers(clientInfo);
	}
	
	@When("the client provide access to another client")
	public void the_client_provide_access_to_another_client() throws OperationNotAllowedException {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		
		try {
			clientHelper.registerMultipleClients();
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
		
		List<ClientInfo> clientsList = clientHelper.getMultipleClients();
		ClientInfo clientInfo2 = clientsList.get(0);
		
		logisticCompanyApp.provideAccess(clientInfo,clientInfo2);
		
		logisticCompanyApp.logisticCompanyLogout();
	}
	
	@Then("the other client should be able to access the client data")
	public void the_other_client_should_be_able_to_access_the_client_data() {
	    ClientInfo clientInfo2 = clientHelper.getMultipleClients().get(0);
	    
	    clientInfo = clientHelper.getClient();
	    client = logisticCompanyApp.findClient(clientInfo);
	    List<Journey> clientJourneys = client.getJourneyList();
	    
	    List<Container> resultList = logisticCompanyApp.collectAccessibleContainers(clientInfo2);
	    
	    assertTrue(resultList.contains(clientJourneys.get(0).getContainer()));
	    
	    for (Journey j : clientJourneys) {
	    	assertTrue(resultList.contains(j.getContainer()));
	    }
	    
	}
	
	@Then("all containers registered for the client journeys is given")
	public void all_containers_registered_for_the_client_journeys_is_given() {
		client = logisticCompanyApp.findClient(clientInfo);
		List<Journey> journeysList = client.getJourneyList();
		
		int n = journeysList.size();
		for (int i=0; i < n; i++) {
			assertEquals(journeysList.get(i).getContainer().getCargo(),containersList.get(i).getCargo());
		}
	}

	@When("the logistic company registers the client")
	public void the_logistic_company_registers_the_client() {
		
		try {
			this.logisticCompanyApp.registerClient(clientInfo, "clientclient");
		} catch (Exception e) {
			this.errorMessage = e.getMessage();
		}
	}
	
	@When("the logistic company registers the client again")
	public void the_logistic_company_registers_the_client_again() {
		the_logistic_company_registers_the_client();
	}
	
	@When("the logistic company updates the client reference person to {string}")
	public void the_logistic_company_updates_the_client_reference_person_to(String newReferencePerson) {
	    clientInfo = clientHelper.getClient();
	    client = logisticCompanyApp.findClient(clientInfo);
	    clientInfo.setRefPerson(newReferencePerson);
	    
	    try {
			logisticCompanyApp.updateClientInfo(client, clientInfo);
		} catch (OperationNotAllowedException e) {
			errorMessage = e.getMessage();
		}
	}
	
	@Then("the client information should be updated")
	public void the_client_information_should_be_updated() {
		client = logisticCompanyApp.findClient(clientInfo);
		assertEquals(client.getRefPerson(),clientInfo.getReference_person());
	}
	
	@Then("the client is registered in the system")
	public void the_client_is_registered_in_the_system() {
	    Optional<ClientInfo> usr = logisticCompanyApp.getClientsStream().findFirst();
	    assertTrue(usr.isPresent());
	    ClientInfo c = usr.get();
	    
	    assertEquals(clientInfo.getName(), c.getName());
	    assertEquals(clientInfo.getEmail(), c.getEmail());
	    assertEquals(clientInfo.getReference_person(), c.getReference_person());
	}
	
	@Then("the system gives the error message {string}")
	public void the_system_gives_the_error_message(String message) {
	    assertEquals(message,errorMessage);
	}

	
}