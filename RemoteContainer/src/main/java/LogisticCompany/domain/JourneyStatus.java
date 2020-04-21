package LogisticCompany.domain;

import java.util.ArrayList;

import LogisticCompany.info.JourneyInfo;

public class JourneyStatus {
	private String startDestination;
	private String currentLocation;
	
	
	private ArrayList<String> journeyLog = new ArrayList<String>();

	public JourneyStatus(String currentLocation)
	{
		this.currentLocation = currentLocation;
	}
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		
	}
	public String getCurrentLocation(){
		return currentLocation;
		
	}
	
	public void addLocationToLog(String currentLocation, String currentDateTime) {	
		String currentInfo = currentLocation + " " +currentDateTime;
		journeyLog.add(currentInfo);
	}
	
	public ArrayList<String> getJourneyLog(){
		return journeyLog;
	}

	
}
