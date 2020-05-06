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
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;
/**
 * This class represents a journey with port of origin, destination and the cargo
 * each journey has a container and a journey status containing the journey's current location.
 */
@Entity
public class Journey {
	@GeneratedValue
	@Id
	private long id;
	private String originPort;
	private String destinationPort;
	private String cargo;
	
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
		this.cargo = journeyInfo.getCargo();
		this.currentJourneyStatus = journeyInfo.getCurrentJourneyStatus();
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
		container.setCargo(this.cargo);
	}

	public void setJourneyStatus(JourneyStatusEntry journeyStatus) {
		this.currentJourneyStatus = journeyStatus;
	}

	public JourneyStatusEntry getJourneyStatus() {
		return currentJourneyStatus;
	}

	public String getStartDestination() {
		return originPort;
	}

	public String getEndDestination() {
		return destinationPort;
	}

	public String getCargo() {
		return cargo;
	}

//	public long getId() {
//		return id;
//	}

	public boolean matchJourney(String searchText) {
		return cargo.toLowerCase().contains(searchText.toLowerCase()) || 
				originPort.toLowerCase().contains(searchText.toLowerCase()) || 
				destinationPort.toLowerCase().contains(searchText.toLowerCase());
	}

	public JourneyInfo asJourneyInfo() {
//		return new JourneyInfo(this.getCargo(), this.getStartDestination(), this.getEndDestination(), this.currentJourneyStatus, this.containers);
		
		// This method should not change: if we need more things from this journey object,
		// then we need to build a get function in this Journey object and call it in the JourneyInfo constructor
		// and then pass the gotten information to the JoruneyInfo object inside its constructor!
		return new JourneyInfo(this); 
	}

}
