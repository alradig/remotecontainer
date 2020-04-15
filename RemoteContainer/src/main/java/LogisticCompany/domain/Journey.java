package LogisticCompany.domain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import LogisticCompany.App.ArchivableObject;
import LogisticCompany.App.Database;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

public class Journey implements ArchivableObject{
	
	private int id;
	
	private String startDestination;
	private String endDestination;
	private boolean isRegistered;
	private String cargo;
	private String currentLocation;
	private boolean endDestinationReached;
	private ArrayList<String> journeyLog = new ArrayList<String>();
	private Container container;
	
	
	
	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
		cargo = container.getCargo();
	}

	public Journey(int id, String startDestination, String endDestination, String cargo) {
		this.id = id;
		this.startDestination = startDestination;
		this.endDestination = endDestination;
		this.cargo = cargo;
	}
	
	public Journey() {}; 
	
	
//	public Journey() {
//		this.id = 0;
//		this.endDestinationReached = false;
//	}
	
	public void setStartDestination(String startDestination) {
		this.startDestination = startDestination;
	}
	
	public String getStartDestination() {
		return startDestination;
	}

	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}
	
	public String getEndDestination() {
		return endDestination;
	}

	public void setRegistrationStatus(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	
	public boolean getRegistrationStatus() {
		return isRegistered;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}
	
	public int getId() {
		return id;
	}
	
////	public void setId(int id) {
////		this.id = id;
//	}
// !! 
	public void registerJourney(Journey journey, Container container) {
		if (journeyInformationNotComplete(journey) & Container.containerRegistered(container))
		{
			this.isRegistered = false; 
		}
		else {
			this.isRegistered = true; 
		}
		
	}
// !! 
	public boolean journeyInformationNotComplete(Journey journey) {
		return cargoIsEmpty(journey) || endDestinationIsEmpty(journey) || startDestinationIsEmpty(journey);
	}
// !! 
	 public boolean startDestinationIsEmpty(Journey journey) {
		return journey.getStartDestination() == null;
	}
// !! 
	public boolean endDestinationIsEmpty(Journey journey) {
		return journey.getEndDestination() == null;
	}
// !! 	
	public boolean cargoIsEmpty(Journey journey) {
		return journey.getCargo() == null;	
	}
	
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		
	}
	public String getCurrentLocation(){
		return currentLocation;
		
	}
	
	public void addLocationToLog(Journey journey , String currentDateTime) {	
		String currentInfo = journey.getCurrentLocation() + " " +currentDateTime;
		journeyLog.add(currentInfo);
	}
	
	public boolean matchJourney(String searchCargo) {
		return cargo.contains(searchCargo);
	}
	
	public JourneyInfo asJourneyInfo() {
		return new JourneyInfo(this.getCargo(), this.getStartDestination(), this.getEndDestination());
	}
	
//// !!! 
//	public void updateJourneyInfo() {
//		String currentInfo = this.currentLocation+ " " + this.dateTime ;
//		journeyLog.add(currentInfo); 
//		isJourneyDone();
//
//	}

//	public void isJourneyDone() {
//		if (currentLocation.equals(endDestination))
//		{
//			endDestinationReached = true; 
//		}
//		else { endDestinationReached = false; }
//	}
// .............................................................................................................................//	
	public void archive() {
		String fileName = "Journey_" + this.id + ".json";
		String folderName = "Journeys";
		
		Database JSONfile = new Database();
		JSONfile.createFile(this,folderName,fileName);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Journey journey = (Journey) o;
        return 	this.id == journey.getId() &&
        		this.startDestination.equals(journey.getStartDestination()) &&
        		this.endDestination.equals(journey.getEndDestination()) &&
        		this.cargo.equals(journey.getCargo()) &&
        		this.currentLocation.equals(journey.getCurrentLocation()) &&
        		this.endDestinationReached == journey.endDestinationReached;
    }
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(19, 53)
				.append(id)
				.append(startDestination)
				.append(endDestination)
				.append(cargo)
				.append(currentLocation)
				.append(endDestinationReached)
				.toHashCode();
	}
	
	public static void main(String [] args) {
		Journey journey = new Journey();
		journey.setStartDestination("DK");
		journey.setEndDestination("AUS");
		journey.setCurrentLocation("AUS");
//		journey.isJourneyDone();
		System.out.println(journey.endDestinationReached);
		
	}
}
