package CucumberSteps;

import java.util.List;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.*;


public class ClientHelper {
	private ClientInfo client;
	private LogisticCompanyApp logisticCompanyApp;
	private JourneyHelper journeyHelper;
	
	public ClientHelper(LogisticCompanyApp logisticCompanyApp, JourneyHelper journeyHelper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.journeyHelper = journeyHelper;
		
	}
	
	public ClientInfo getClient() {
		if (client == null) {
			client = exampleClient();
		}
		return client;
	}
	
	public ClientInfo registerExampleClient() throws Exception {
		ClientInfo client = getClient();
		boolean loggedIn = logisticCompanyApp.logisticCompanyLoggedIn();
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		}
		
		logisticCompanyApp.registerClient(client);
		
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogout();
		}
		return client;
	}
	
	private ClientInfo exampleClient() {
		ClientInfo client = new ClientInfo("Expresso","expresso@exp.com","Nach Jicholson");
		Address address = new Address("The street 3",1700,"Aarhus");
		client.setAddress(address);
		return client;
	}

}
