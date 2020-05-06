package LogisticCompany.domain;

import javax.persistence.*;
/**
 * This class represents a journey status with location status' of the journey.
 */

@Embeddable
public class JourneyStatusEntry {
	private String originPort;
	private String destinationPort;
	private String location;
	
	public JourneyStatusEntry(String originPort,String destinationPort, String location) {
		this.originPort = originPort;
		this.location = location;
		this.destinationPort = destinationPort;
	}
//	public JourneyStatusEntry(String location) {
//		this.location = location;
//	}
	
	public JourneyStatusEntry() {

	}
	
	public String getLocation(){
		return location;
	}
	public void setLocation(String newLocation) {
		this.location = newLocation;
		
	}
	
}
