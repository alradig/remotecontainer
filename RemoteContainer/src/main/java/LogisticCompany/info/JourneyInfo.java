package LogisticCompany.info;


import java.util.ArrayList;

import LogisticCompany.domain.Journey;

public class JourneyInfo {
	private String startDestination;
	private String endDestination;
	private String cargo;
	private String currentLocation;
	private long id;
	private ArrayList<String> journeyLog = new ArrayList<String>();

	
	public JourneyInfo(String startDestination, String endDestination) {
		this.cargo = cargo;
		this.startDestination = startDestination;
		this.endDestination = endDestination;
	}
	
	public JourneyInfo(Journey journey) {
		this.id = journey.getId();
		this.startDestination = journey.getStartDestination();
		this.endDestination = journey.getEndDestination();
		this.cargo = journey.getCargo();
	}
	
	public JourneyInfo(String cargo, String startDestination, String endDestination) {
		this.cargo = cargo;
		this.startDestination = startDestination;
		this.endDestination = endDestination;
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public String getStartDestination() {
		return startDestination;
	}
	
	public String getCurrentLocation(){
		return currentLocation;
		
	}
	public String getEndDestination() {
		return endDestination;
	}
	
	public long getId() {
		return id;
	}
	
	public Journey asJourney() {
		return new Journey(id, startDestination,endDestination,cargo);
	}
	
	
}
