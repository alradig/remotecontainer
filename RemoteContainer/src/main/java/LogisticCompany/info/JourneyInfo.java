package LogisticCompany.info;


import java.util.ArrayList;

import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatusEntry;

public class JourneyInfo {
	private String originPort;
	private String destinationPort;
	private String cargo;
	private String location;

	private long id;
//	private ArrayList<String> journeyLog = new ArrayList<String>();
	private JourneyStatusEntry currentJourneyStatus;
	
	public JourneyInfo(String startDestination, String endDestination) {
		this.originPort = startDestination;
		this.destinationPort = endDestination;
	}
	
	public JourneyInfo(Journey journey) {
		this.id = journey.getId();
		this.originPort = journey.getStartDestination();
		this.destinationPort = journey.getEndDestination();
		this.cargo = journey.getCargo();
		this.currentJourneyStatus = journey.getJourneyStatus();
	}
	
	public JourneyInfo(String cargo, String originPort, String endDestination) {
		this.cargo = cargo;
		this.originPort = originPort;
		this.destinationPort = endDestination;
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
	
	public long getId() {
		return id;
	}
	
	public Journey asJourney() {
		return new Journey(this);
	}
	
	
}
