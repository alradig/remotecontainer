package CucumberSteps;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;


public class ClientHelper {
	private ClientInfo client;
	private LogisticCompanyApp logisticCompanyApp;
	
	public ClientHelper(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
		
	}
	
	public ClientInfo getClient() {
		if (client == null) {
			client = exampleClient();
		}
		return client;
	}
	
	public void setUser(String name, String email, String referencePerson, String street, int postcode, String city) {
		Address a = new Address(street,postcode,city);
		client = new ClientInfo(name,email,referencePerson);
		client.setAddress(a);
	}
	
	public ClientInfo registerExampleClient() throws Exception {
		ClientInfo usr = getClient();
		boolean loggedIn = logisticCompanyApp.logisticCompanyLoggedIn();
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		}
		
		logisticCompanyApp.registerClient(usr);
		
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogout();
		}
		return usr;
	}
	
	private ClientInfo exampleClient() {
		ClientInfo client = new ClientInfo("Expresso","expresso@exp.com","Nach Jicholson");
		Address address = new Address("The street 3",1700,"Aarhus");
		client.setAddress(address);
		return client;
	}
}
