package CucumberSteps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
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
	
	public List<ContainerInfo> getMultipleContainers() {
		ContainerInfo containerInfo1 = new ContainerInfo("empty");
		ContainerInfo containerInfo2 = new ContainerInfo("empty");
		ContainerInfo containerInfo3 = new ContainerInfo("empty");
	
		return new ArrayList<ContainerInfo>(Arrays.asList(containerInfo1, containerInfo2, containerInfo3));
	}

	public void registerMultipleContainers() throws Exception{
		List<ContainerInfo> containersList = getMultipleContainers();
		
		for (ContainerInfo c : containersList) {
				logisticCompanyApp.registerContainer(c);
		}
	}

}



