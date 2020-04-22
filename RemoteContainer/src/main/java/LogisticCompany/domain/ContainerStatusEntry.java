package LogisticCompany.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class ContainerStatusEntry {
	@Id
	private String temperature;
	private String airHumidity;
	private String atmPressure;
	
	public ContainerStatusEntry(String temperature, String airHumidity, String atmPressure) {
		this.temperature = temperature;
		this.airHumidity = airHumidity;
		this.atmPressure = atmPressure;
	}
	
	public ContainerStatusEntry() {
		
	}

	public void setTemperature(String currentTemp) {
		this.temperature = currentTemp;
	}
	
	public String getTemperature() {
		return temperature;
	}
	
	public String getAirHumidity() {
		return airHumidity;
	}

	public void setAirHumidity(String currentAirHum) {
		this.airHumidity = currentAirHum;
	}
	
	public void setAtmPressure(String currentAtmPre) {
		this.atmPressure = currentAtmPre;
	}
	
	public String getAtmPressure() {
		return atmPressure;
	}
}
