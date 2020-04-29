package JUnit_tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.persistence.InMemoryRepository;


public class testAccessClient {

	private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
    
    @Before
    public void setUp() throws OperationNotAllowedException {
    	logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		logisticCompanyApp.registerClient("name2", "email2", "ps2","456", "city2", "street2", "refPerson2");
    }
		
	@Test
	public void testProvideAccess() throws Exception {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
    	ClientInfo c1 = new ClientInfo("name1","email1","refPerson1");
    	logisticCompanyApp.registerClient(c1 , "ps1");
    	
		logisticCompanyApp.setSelectedClient(c1);
		assertTrue(logisticCompanyApp.provideAccess("name2", "email2"));
    }
		
	
	
}
