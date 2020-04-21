package LogisticCompany.domain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.*;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import LogisticCompany.domain.JourneyStatus;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

@Entity
public class Journey{
	@Id
    @GeneratedValue
    private long id;
	private String startDestination;
	private String endDestination;
	private boolean isRegistered;
	private String currentLocation;
	private String cargo;
	private boolean endDestinationReached;
	@OneToMany
	private List<Container> containers = new ArrayList<Container>();
	private Container container;

	@Embedded
	private JourneyStatus currentJourneyStatus;
	
//	@ElementCollection
//	private List<String> journeyLog = new ArrayList<String>(); //Consider creating a logEntry object and having a list of it here!
//	@OneToMany
//	private ArrayList<JourneyStatus> journeyLogs = new ArrayList<>();
	
	
	public Container getContainer() {
		return container;
	}
	
	public Journey(long id, String startDestination, String endDestination, String cargo) {
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
	

	public void setJourneyStatus(JourneyStatus journeyStatus) {
//		journeyLogs.add(this.currentJourneyStatus);
		this.currentJourneyStatus=journeyStatus;
	}

	public JourneyStatus getJourneyStatus() {
		return currentJourneyStatus;
	}
	
	public Journey() {
		
	} 
	
	
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
	
	public long getId() {
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
	
}
