package LogisticCompany.info;

import LogisticCompany.domain.Client;
import LogisticCompany.domain.Journey;

public class JourneyInfo {
	private String startDestination;
	private String endDestination;
	private String cargo;
	private int id;
	
	public JourneyInfo(int id, String startDestination, String endDestination, String cargo) {
		this.id = id;
		this.startDestination = startDestination;
		this.endDestination = endDestination;
		this.cargo = cargo; 
	}
	
	public JourneyInfo(Journey journey) {
		this.id = journey.getId();
		this.startDestination = journey.getStartDestination();
		this.endDestination = journey.getEndDestination();
		this.cargo = journey.getCargo();
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public String getStartDestination() {
		return startDestination;
	}

	public String getEndDestination() {
		return endDestination;
	}
	
	public int getId() {
		return id;
	}
	
	public Journey asJourney() {
		return new Journey(id,startDestination,endDestination,cargo);
	}
	
	
}
