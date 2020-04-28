package JUnit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.InMemoryRepository;

public class testSelectedObjects {
	private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
	
    @Test
	public void testSetSelectedJourney() {
		JourneyInfo j = new JourneyInfo("something", "oldPlace", "newPlace");
		ContainerInfo container = new ContainerInfo("empty");

		logisticCompanyApp.registerJourney(j);
		logisticCompanyApp.registerContainer(container);
		logisticCompanyApp.registerContainerToJourney(container,j);
		
		logisticCompanyApp.setSelectedObjects(j);
		
		assertEquals(logisticCompanyApp.getSelectedjourneyInfo().getCargo(),"something");
		assertEquals(logisticCompanyApp.getSelectedjourneyInfo().getOriginPort(),"oldPlace");
		assertEquals(logisticCompanyApp.getSelectedjourneyInfo().getDestinationPort(),"newPlace");
		
		assertEquals(logisticCompanyApp.getSelectedJourney().getCargo(), "something");
		assertEquals(logisticCompanyApp.getSelectedJourney().getStartDestination(),"oldPlace");
		assertEquals(logisticCompanyApp.getSelectedJourney().getEndDestination(), "newPlace");
		
	}
    @Test
    public void testSelectedClient() throws OperationNotAllowedException{
    	logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
    	ClientInfo c = new ClientInfo("nameName","emailEmail","referenceP");
    	logisticCompanyApp.registerClient(c , "ps");
    	
		logisticCompanyApp.setSelectedClient(c);
		
		assertEquals(logisticCompanyApp.getSelectedClientInfo().getName(),"nameName");
		assertEquals(logisticCompanyApp.getSelectedClientInfo().getEmail(),"emailEmail");
		assertEquals(logisticCompanyApp.getSelectedClientInfo().getReference_person(),"referenceP");
		
		assertEquals(logisticCompanyApp.getSelectedClient().getName(),"nameName");
		assertEquals(logisticCompanyApp.getSelectedClient().getEmail(),"emailEmail");
		assertEquals(logisticCompanyApp.getSelectedClient().getRefPerson(),"referenceP");

    }
	
    

}
