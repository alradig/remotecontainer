package CucumberSteps;
import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
public class ContainerHelper {
	
	private LogisticCompanyApp logisticCompanyApp;
	private ContainerInfo containerInfo;
		
	public ContainerHelper(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
	}
	public ContainerInfo getContainer() {
		if (containerInfo == null) {
			containerInfo = exampleContainer();
		}
		return containerInfo;
	}
	
	public ContainerInfo registerExampleContainer() throws Exception {
		ContainerInfo usr = getContainer();
		boolean loggedIn = logisticCompanyApp.logisticCompanyLoggedIn();
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		}
		
		logisticCompanyApp.registerContainer(usr);
		
		if (!loggedIn) {
			logisticCompanyApp.logisticCompanyLogout();
		}
		return usr;
	}
	
	private ContainerInfo exampleContainer() {
		ContainerInfo containerInfo = new ContainerInfo("Apples");
		return containerInfo;
	}
		

}



