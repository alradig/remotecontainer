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

	}
	
	public String getLocation(){
		return location;
	}
	
}
