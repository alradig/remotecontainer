package LogisticCompany.info;


import java.util.List;

import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatusEntry;

public class JourneyInfo {
	private String originPort;
	private String destinationPort;
	private String cargo;
	private String location;
	private ContainerInfo containerInfo;
//	private ArrayList<String> journeyLog = new ArrayList<String>();
	private JourneyStatusEntry currentJourneyStatus;
//	private List<Container> containers ;
	private Container container;
	

	public JourneyInfo(Journey journey) {
		this.originPort = journey.getStartDestination();
		this.destinationPort = journey.getEndDestination();
		this.cargo = journey.getCargo();
		this.currentJourneyStatus = journey.getJourneyStatus();
		this.containerInfo = journey.getContainer().asContainerInfo();
		this.location = journey.getJourneyStatus().getLocation();
	}
	
	public JourneyInfo(String cargo, String originPort, String endDestination) {
		this.cargo = cargo;
		this.originPort = originPort;
		this.destinationPort = endDestination;
		currentJourneyStatus = new JourneyStatusEntry("not registered","not registered","not registered");
	}
	
	public JourneyInfo(String cargo, String originPort, String endDestination, JourneyStatusEntry currentJourneyStatus) {
		this.cargo = cargo;
		this.originPort = originPort;
		this.destinationPort = endDestination;
		this.currentJourneyStatus = currentJourneyStatus;
	}
	
	public Container getContainer() {
		return container;
	}

	public String getCargo() {
		return cargo;
	}
	
	public String getOriginPort() {
		return originPort;
	}
	
	public String getLocation(){
		return location;
	}
	
	public String getDestinationPort() {
		return destinationPort;
	}
	
	public Journey asJourney() {
		return new Journey(this);
	}
	
	public String toString() {
		return "Journey from " + getOriginPort() + " to " + getDestinationPort();
	}

	public ContainerInfo getContainerInfo() {
		return containerInfo;
	}

	public JourneyStatusEntry getCurrentJourneyStatus() {
		return currentJourneyStatus;
	}
}
