package LogisticCompany.domain;

import javax.persistence.*;

@Entity
public class ContainerStatusEntry {
	@Id
	private String temperature;
	private String airHumidity;
	private String atmPressure;
	
	public ContainerStatusEntry() {
		
	}
	
	public ContainerStatusEntry(String temperature, String airHumidity, String atmPressure) {
		this.temperature = temperature;
		this.airHumidity = airHumidity;
		this.atmPressure = atmPressure;
	}
	
	public String getTemperature() {
		return temperature;
	}
	
	public String getAirHumidity() {
		return airHumidity;
	}
	
	public String getAtmPressure() {
		return atmPressure;
	}
}
