package CucumberSteps;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;

public class JourneyHelper {
	
	private LogisticCompanyApp logisticCompanyApp;
	private JourneyInfo journeyInfo;
	
	public JourneyHelper(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
	}
	
	public JourneyInfo getJourney() {
		if (journeyInfo == null) {
			journeyInfo = exampleJourney();
		}
		return journeyInfo;
	}
	
	public JourneyInfo registerExampleJourney() throws Exception {
		JourneyInfo usr = getJourney();
		boolean loggedIn = logisticCompanyApp.logisticCompanyLoggedIn();
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		}
		logisticCompanyApp.registerJourney(usr);
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogout();
		}
		return usr;
	}
	
	private JourneyInfo exampleJourney() {
		JourneyInfo journeyInfo = new JourneyInfo("Apples","Copenhagen","London");
		return journeyInfo;
	}

	public List<JourneyInfo> getMultipleJourneys() {
		JourneyInfo journeyInfo1 = new JourneyInfo("Apples","Copenhagen","London");
		JourneyInfo journeyInfo2 = new JourneyInfo("Bananas","Rio de Janeiro","Marseille");
		JourneyInfo journeyInfo3 = new JourneyInfo("Oranges","Hamburg","Aalborg");
	
		return new ArrayList<JourneyInfo>(Arrays.asList(journeyInfo1, journeyInfo2, journeyInfo3));
	}

	public void registerMultipleJourneys() {
		List<JourneyInfo> journeysList = getMultipleJourneys();
		
		for (JourneyInfo j : journeysList) {
			logisticCompanyApp.registerJourney(j);
		}
	}
	

}
