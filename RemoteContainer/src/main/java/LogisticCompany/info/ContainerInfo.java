package LogisticCompany.info;

import java.util.ArrayList;
import java.util.List;

import LogisticCompany.domain.Container;

public class ContainerInfo {
	
	private String cargo;
	private String currentTemp;
	private String currentAirHum;
	private String currentAtmPre;
	
	private ArrayList<String> Temp = new ArrayList<String>();
	private ArrayList<String> AirHum = new ArrayList<String>();
	private ArrayList<String> AtmPre = new ArrayList<String>();

	public ContainerInfo(String cargo) {
		this.cargo = cargo;
	}
	
	public ContainerInfo(String currentTemp, String currentAirHum, String currentAtmPre) {
		this.currentTemp = currentTemp;
		this.currentAirHum = currentAirHum;
		this.currentAtmPre = currentAtmPre;
	}
	
	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCurrentTemp() {
		return currentTemp;
	}
	
	public String getCurrentAirHum() {
		return currentAirHum;
	}
	
	public String getCurrentAtmPre() {
		return currentAtmPre;
	}
	
	public Container asContainer() {
		// missing things to register container with .. Ask group ! ? 
		
		return new Container(cargo);
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
	
	public void addToMeasurementList(String currentTemp, String currentAirHum, String currentAtmPre) {
		Temp.add(currentTemp);
		AirHum.add(currentAirHum);
		AtmPre.add(currentAtmPre);
	}
	
}
