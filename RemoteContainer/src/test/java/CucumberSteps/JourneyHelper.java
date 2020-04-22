package CucumberSteps;


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
	

}
