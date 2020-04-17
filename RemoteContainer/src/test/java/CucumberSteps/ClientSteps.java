package CucumberSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Address;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClientSteps {
	
	private LogisticCompanyApp logisticCompanyApp;
	private ClientInfo clientInfo;
	private String errorMessage;
	private Address address;
	
	public ClientSteps(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
		
	}

	@Given("There is a client with name {string}, email {string}, reference person {string}")

	 public void there_is_a_client_with_name_email_reference_person_password(String name, String email, String ref_person) {
	   clientInfo = new ClientInfo(name, email, ref_person);

	     assertEquals(clientInfo.getName(),name);
	     assertEquals(clientInfo.getEmail(),email);
	     assertEquals(clientInfo.getReference_person(),ref_person);

	}
	
	@When("the administrator registers the client")
	public void the_administrator_registers_the_client() {
		try {
			this.logisticCompanyApp.registerClient(clientInfo);
		} catch (Exception e) {
//			errorMessage.setErrorMessage(e.getMessage());
			this.errorMessage = e.getMessage();
		}
	}
	

	@Given("the client address is {string}, {int}, {string}")
	public void the_client_address_is(String street, int postcode, String city) {
		this.address = new Address(street,postcode,city);
		this.clientInfo.setAddress(address);
		
		assertEquals(clientInfo.getAddress().getStreet(),street);
		assertEquals(clientInfo.getAddress().getPostCode(),postcode);
		assertEquals(clientInfo.getAddress().getCity(),city);	
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

	
}