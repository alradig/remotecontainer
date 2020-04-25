package CucumberSteps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;
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
		
		logisticCompanyApp.registerClient(client, "clientclient");
		
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogout();
		}
		return client;
	}
	
	private ClientInfo exampleClient() {
		ClientInfo client = new ClientInfo("Expresso","expresso@exp.com","Nach Jicholson");
		Address address = new Address("The street 3","1700","Aarhus");
		client.setAddress(address);
		return client;
	}
	
	public void registerMultipleClients() throws Exception{
		List<ClientInfo> clientsList = getMultipleClients();
		
		for (ClientInfo c : clientsList) {
			logisticCompanyApp.registerClient(c, null);
			logisticCompanyApp.setClientPassword(c, "clientclient");
		}
	}

	public List<ClientInfo> getMultipleClients() {
		ClientInfo client2 = new ClientInfo("Wurth","wurth@wrt.com","Mika McNuggets");
		Address address2 = new Address("The german strasse 5","27645","Berlin");
		client2.setAddress(address2);
		
		ClientInfo client3 = new ClientInfo("Embraer","embraer@emb.com","Bhristian Cale");
		Address address3 = new Address("The brasilian rua 34","27645","Rio de Janeiro");
		client3.setAddress(address3);
		
		return new ArrayList<ClientInfo>(Arrays.asList(client2, client3));
	}

}
