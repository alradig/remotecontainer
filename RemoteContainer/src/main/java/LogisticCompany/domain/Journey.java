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
 * The id is automatically generated
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

	public boolean matchJourney(String searchText) {
		return cargo.toLowerCase().contains(searchText.toLowerCase()) || 
				originPort.toLowerCase().contains(searchText.toLowerCase()) || 
				destinationPort.toLowerCase().contains(searchText.toLowerCase());
	}

	public JourneyInfo asJourneyInfo() {
		return new JourneyInfo(this); 
	}

}
