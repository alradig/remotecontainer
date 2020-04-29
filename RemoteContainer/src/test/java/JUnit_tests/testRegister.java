package JUnit_tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.InMemoryRepository;

public class testRegister {
	private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
	@Test 
	
	public void testRegisterClient() throws OperationNotAllowedException {
    	logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		logisticCompanyApp.registerClient("name", "email", "ps","123", "city", "street", "refPerson");
		Client c = logisticCompanyApp.findClient(new ClientInfo("name", "email", "refPerson"));
		assertEquals(c.getName(),"name");
		assertEquals(c.getEmail(),"email");
		assertEquals(c.getPassword(),"ps");
		assertEquals(c.getRefPerson(),"refPerson");
		assertEquals(c.getAddress().getPostCode(),"123");
		assertEquals(c.getAddress().getCity(),"city");
		assertEquals(c.getAddress().getStreet(),"street");
	}

	
	@Test
	public void testRegisterJourney() throws OperationNotAllowedException{
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
    	ClientInfo c = new ClientInfo("nameName","emailEmail","referenceP");
    	logisticCompanyApp.registerClient(c , "ps");
		logisticCompanyApp.setSelectedClient(c);
		
		logisticCompanyApp.registerJourney("cargo", "originPort", "endDestination");
		assertEquals(c.getName(),"nameName");
		
		assertEquals(logisticCompanyApp.getSelectedClient().getJourneyList().size(),1);
		assertEquals(logisticCompanyApp.getSelectedClient().getJourneyList().get(0).getCargo(), "cargo");
		assertEquals(logisticCompanyApp.getSelectedClient().getJourneyList().get(0).getStartDestination(), "originPort");
		assertEquals(logisticCompanyApp.getSelectedClient().getJourneyList().get(0).getEndDestination(), "endDestination");
		
	}
}
