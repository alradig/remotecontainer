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
	private List<Container> containers ;
	
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
	}
	
	public JourneyInfo(String cargo, String originPort, String endDestination, JourneyStatusEntry currentJourneyStatus, List<Container> containers) {
		this.cargo = cargo;
		this.originPort = originPort;
		this.destinationPort = endDestination;
		this.currentJourneyStatus = currentJourneyStatus;
		this.containers = containers;
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
}
