package CucumberSteps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatusEntry;
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
    public ClientHelper clientHelper;
    private JourneyStatusEntry journeyStatus;
	public JourneyInfo journeyInfo;
	private ContainerInfo containerInfo;
	private String errorMessage;
	public JourneyHelper journeyHelper;
	public ContainerHelper containerHelper;
	private Journey journey;
	
	
	public JourneySteps(LogisticCompanyApp logisticCompanyApp,ClientHelper clientHelper, JourneyHelper journeyHelper, ContainerHelper containerHelper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.clientHelper = clientHelper;
		this.journeyHelper =journeyHelper;
		this.containerHelper = containerHelper;
	}
	
	@When("the logistic company updates the journey location to {string}")
	public void the_logistic_company_updates_the_journey_location_to(String newLocation) {
		journeyInfo = journeyHelper.getJourney();
		journey = logisticCompanyApp.findJourney(journeyInfo);
		journeyStatus = new JourneyStatusEntry(journeyInfo.getOriginPort(), journeyInfo.getDestinationPort(),newLocation);
		
		try {
			logisticCompanyApp.updateJourneyInfo(journey, journeyStatus);
		} catch (OperationNotAllowedException e) {
			errorMessage = e.getMessage();
		}      
	}
	
	@Then("the journey current position is updated with current location {string}")
	public void the_journey_current_position_is_updated_with_current_location(String string) {
		journey = logisticCompanyApp.findJourney(journeyInfo);
		assertEquals(journey.getJourneyStatus().getLocation(),journeyStatus.getLocation());
	}
	
//	@When("the journey has arrived at {string}")
//	public void the_journey_has_arrived_at(String currentLocation) {
//		journeyStatus = new JourneyStatusEntry(currentLocation);
//		assertEquals(journeyStatus.getCurrentLocation(),currentLocation);
//
//	}
//	


//	@Then("current position is updated with current location {string}")
//	public void current_position_is_updated_with_current_location(String currentLocation) throws Exception  {
//		journeyInfo = jouerneyHelper.getJourney();
//		Journey journey = logisticCompanyApp.findJourney(journeyInfo);
//		
//		logisticCompanyApp.updateJourneyInfo(journey, journeyStatus);
//		JourneyStatusEntry journeyStatus = journey.getJourneyStatus();
//		assertEquals(journeyStatus.getJourneyLog().size(),1);
//		assertTrue(journeyStatus.getJourneyLog().get(0).contains(currentLocation)); 
//	    
//	}

}
