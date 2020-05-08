package JUnit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Address;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.persistence.InMemoryRepository;

public class testUpdateClientInfo {
	private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
    
	@Before
    public void setUp() throws OperationNotAllowedException {
    	logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		logisticCompanyApp.registerClient("name2", "email2", "ps2","456", "city2", "street2", "refPerson2");
		
		ClientInfo c1 = new ClientInfo("name1","email1","refPerson1");
		Address address = new Address("The brasilian rua 34","27645","Rio de Janeiro");
		c1.setAddress(address);
		
    	logisticCompanyApp.registerClient(c1 , "ps1");
    	logisticCompanyApp.setLoggedInClient(c1.asClient());
    }
	
	@Test 
	public void testUpdateClient() {
		logisticCompanyApp.updateClient("newName", "" ,"" ,"" ,"" ,"" );
		assertEquals(logisticCompanyApp.getLoggedInClient().getName(),"newName");
		
		logisticCompanyApp.updateClient("", "" ,"" ,"" ,"" ,"" );
		assertEquals(logisticCompanyApp.getLoggedInClient().getName(),"newName");
		
		logisticCompanyApp.updateClient("", "" ,"" ,"123" ,"" ,"" );
		assertEquals(logisticCompanyApp.getLoggedInClient().getAddress().getPostCode(),"123");

	}

}
