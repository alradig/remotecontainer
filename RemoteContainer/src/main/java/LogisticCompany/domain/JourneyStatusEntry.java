package LogisticCompany.domain;

import javax.persistence.*;

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
	
	public JourneyStatusEntry() {
		this.originPort = "";
		this.location = "";
	}

	public void setLocation(String currentLocation) {
		this.location = currentLocation;
		
	}
	public String getLocation(){
		return location;
	}
	
}
