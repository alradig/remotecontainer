package JUnit_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Journey;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.InMemoryRepository;

public class testUpdate {
	private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
    private JourneyInfo j;
    private ContainerInfo container;
    
	@Before
	public void setUp() throws OperationNotAllowedException {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		j = new JourneyInfo("something", "oldPlace", "newPlace");
		container = new ContainerInfo("empty");
		logisticCompanyApp.registerJourney(j);
		logisticCompanyApp.registerContainer(container);
		logisticCompanyApp.registerContainerToJourney(container,j);
		logisticCompanyApp.setSelectedObjects(j);
		
	}
	@Test
	public void testUpdateSelectedContainer() {
		logisticCompanyApp.updateSelectedContainer("1", "2", "3");		
		assertEquals(logisticCompanyApp.getSelectedContainerInfo().getContainerStatusList().get(0).getTemperature(),"1");
		assertEquals(logisticCompanyApp.getSelectedContainerInfo().getContainerStatusList().get(0).getAirHumidity(),"2");
		assertEquals(logisticCompanyApp.getSelectedContainerInfo().getContainerStatusList().get(0).getAtmPressure(),"3");
	}
	@Test
	public void testUpdateSelectedJourney() throws OperationNotAllowedException {
		logisticCompanyApp.updateSelectedJourney("newLocation");
		assertEquals(logisticCompanyApp.getSelectedJourney().asJourneyInfo().getLocation(),"newLocation");
	}

}
