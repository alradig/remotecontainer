package LogisticCompany.domain;

import java.util.ArrayList;
import java.util.List;

public class ContainerStatus {
	
	private String currentTemp;
	private String currentAirHum;
	private String currentAtmPre;
	
	public ContainerStatus(String currentTemp, String currentAirHum, String currentAtmPre) {
		this.currentTemp = currentTemp;
		this.currentAirHum = currentAirHum;
		this.currentAtmPre = currentAtmPre;
	}

	public void setCurrentTemp(String currentTemp) {
		this.currentTemp = currentTemp;
	}
	
	public String getCurrentTemp() {
		return currentTemp;
	}
	
	public String getCurrentAirHum() {
		return currentAirHum;
	}

	public void setCurrentAirHum(String currentAirHum) {
		this.currentAirHum = currentAirHum;
	}
	
	public void setAtmPre(String currentAtmPre) {
		this.currentAtmPre = currentAtmPre;
	}
	
	public String getCurrentAtmPre() {
		return currentAtmPre;
	}
}
