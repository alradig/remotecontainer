package LogisticCompany.domain;

import java.util.ArrayList;
import java.util.List;

public class ContainerStatus {
	
	private String currentTemp;
	private String currentAirHum;
	private String currentAtmPre;
	
	private ArrayList<String> Temp = new ArrayList<String>();
	private ArrayList<String> AirHum = new ArrayList<String>();
	private ArrayList<String> AtmPre = new ArrayList<String>();
	
	public ContainerStatus(String currentTemp, String currentAirHum, String currentAtmPre) {
		this.currentTemp = currentTemp;
		this.currentAirHum = currentAirHum;
		this.currentAtmPre = currentAtmPre;	
	}
	
	public List<String> getTemp() {
		 return Temp;
	}
	
	public List<String> getAirHum() {
		 return AirHum;
	}
	
	public List<String> getAtmPre() {
		 return AtmPre;
	}

	public void clearMeasurements() {
		Temp.clear();
		AirHum.clear();
		AtmPre.clear();
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
	
	public void addToMeasurementList(String currentTemp, String currentAirHum, String currentAtmPre) {
		Temp.add(currentTemp);
		AirHum.add(currentAirHum);
		AtmPre.add(currentAtmPre);
	}
}
