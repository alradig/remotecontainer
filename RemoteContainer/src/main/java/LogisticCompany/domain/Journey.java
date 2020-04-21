package LogisticCompany.domain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import LogisticCompany.App.ArchivableObject;

import LogisticCompany.domain.JourneyStatus;
import LogisticCompany.App.Database;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;


public class Journey implements ArchivableObject{
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id;
	private String startDestination;
	private String endDestination;
	private boolean isRegistered;
	private String currentLocation;
	private String cargo;
	private boolean endDestinationReached;
	private ArrayList<Container> containers = new ArrayList<Container>();
	private Container container;
	private JourneyStatus journeyStatus; 
	
	public Journey(int id, String startDestination, String endDestination, String cargo) {
		this.id = id;
//		this.id = count.incrementAndGet();  does not work yet since we pass ID to journey so far
		this.startDestination = startDestination;
		this.endDestination = endDestination;
		this.cargo = cargo;
	}

	public void setContainer(Container container) {
		this.container = container;
		container.setCargo(cargo);
		containers.add(container);
	}
	
	public Container getContainer() {
		return container;
	}
	
	public void setJourneyStatus(JourneyStatus journeyStatus) {
		this.journeyStatus=journeyStatus;
	}

	public JourneyStatus getJourneyStatus() {
		return journeyStatus;
	}
	
	public Journey() {this.id = count.incrementAndGet(); }; 
	
	
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
	
}
