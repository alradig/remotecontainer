package LogisticCompany.domain;

import javax.persistence.*;
/**
 * This class represents a container status with temperature, Air Humidity and air Pressure measurements
 * The id is automatically generated
 */

@Entity
public class ContainerStatusEntry {
	@Id
    @GeneratedValue
	private long id;
	private String temperature;
	private String airHumidity;
	private String atmPressure;
	
	public ContainerStatusEntry() {
		temperature = "";
		airHumidity = "";
		atmPressure = "";
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
	
	public void setTemperature(String temp) {
		this.temperature = temp;
	}
	
	public void setHumidity(String humidity) {
		this.airHumidity = humidity;
	}
	
	public void setPressure(String pressure) {
		this.atmPressure = pressure;
	}
	
}
