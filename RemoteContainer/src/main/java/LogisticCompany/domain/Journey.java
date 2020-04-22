package LogisticCompany.domain;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.*;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import LogisticCompany.domain.JourneyStatusEntry;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;

@Entity
public class Journey{
	@Id
    @GeneratedValue
    private long id;
	private String originPort;
	private String destinationPort;
	private boolean isRegistered;
	private String location;
	private String cargo;
	private boolean endDestinationReached;
	@OneToMany
	private List<Container> containers = new ArrayList<Container>();
	private Container container;

	@Embedded
	private JourneyStatusEntry currentJourneyStatus;
	
//	@ElementCollection
//	private List<String> journeyLog = new ArrayList<String>(); //Consider creating a logEntry object and having a list of it here!
//	@OneToMany
//	private ArrayList<JourneyStatus> journeyLogs = new ArrayList<>();
	
	public Journey() {
		
	}
	
	public Journey(JourneyInfo journeyInfo) {
		this.originPort = journeyInfo.getOriginPort();
		this.destinationPort = journeyInfo.getDestinationPort();
		this.location = journeyInfo.getLocation();
		this.cargo = journeyInfo.getCargo();
	}
	
	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
		container.setCargo(this.cargo);
		containers.add(container);
	}
	

	public void setJourneyStatus(JourneyStatusEntry journeyStatus) {
//		journeyLogs.add(this.currentJourneyStatus);
		this.currentJourneyStatus=journeyStatus;
	}

	public JourneyStatusEntry getJourneyStatus() {
		return currentJourneyStatus;
	}
	
	public void setStartDestination(String startDestination) {
		this.originPort = startDestination;
	}
	
	public String getStartDestination() {
		return originPort;
	}

	public void setEndDestination(String endDestination) {
		this.destinationPort = endDestination;
	}
	
	public String getEndDestination() {
		return destinationPort;
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
