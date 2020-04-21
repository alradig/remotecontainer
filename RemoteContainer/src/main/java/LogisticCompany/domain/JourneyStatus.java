package LogisticCompany.domain;

import java.util.ArrayList;
import javax.persistence.*;
import LogisticCompany.info.JourneyInfo;

@Embeddable
public class JourneyStatus {
	private String startDestination;
	private String currentLocation;
	
//	private ArrayList<String> journeyLog = new ArrayList<String>();
	
	public JourneyStatus(String startDestination, String currentLocation) {
		this.startDestination = startDestination;
		this.currentLocation = currentLocation;
	}
	
	public JourneyStatus() {
		this.startDestination = "";
		this.currentLocation = "";
	}
	
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		
	}
	public String getCurrentLocation(){
		return currentLocation;
		
	}
	
//	public void addLocationToLog(String currentLocation, String currentDateTime) {	
//		String currentInfo = currentLocation + " " +currentDateTime;
//		journeyLog.add(currentInfo);
//	}

	
}
