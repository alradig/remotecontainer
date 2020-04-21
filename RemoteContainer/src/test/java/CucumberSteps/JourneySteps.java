package CucumberSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.ContainerStatus;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatus;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;


public class JourneySteps {
	
    private InMemoryRepository repository = new InMemoryRepository();
    private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
    public ClientHelper helper;
    private JourneyStatus journeyStatus;
	public JourneyInfo journeyInfo;
	private ContainerInfo containerInfo;
	private String errorMessage;
	public JourneyHelper jouerneyHelper;
	public ContainerHelper containerHelper;
	
	
	public JourneySteps(LogisticCompanyApp logisticCompanyApp,ClientHelper helper, JourneyHelper jouerneyHelper, ContainerHelper containerHelper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.helper = helper;
		this.jouerneyHelper =jouerneyHelper;
		this.containerHelper = containerHelper;
	}
	
	@When("the journey has arrived at {string}")
	public void the_journey_has_arrived_at(String currentLocation) {
		journeyStatus = new JourneyStatus(currentLocation);
		assertEquals(journeyStatus.getCurrentLocation(),currentLocation);

	}

	@Then("current position is updated with current location {string}")
	public void current_position_is_updated_with_current_location(String currentLocation) throws Exception  {
		journeyInfo = jouerneyHelper.getJourney();
		Journey journey = logisticCompanyApp.findJourney(journeyInfo);
		
		logisticCompanyApp.updateJourneyInfo(journey, journeyStatus);
		JourneyStatus journeyStatus = journey.getJourneyStatus();
		assertEquals(journeyStatus.getJourneyLog().size(),1);
		assertTrue(journeyStatus.getJourneyLog().get(0).contains(currentLocation)); 
	    
	}

}
