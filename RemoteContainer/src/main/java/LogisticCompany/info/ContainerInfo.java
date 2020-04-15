package LogisticCompany.info;

import LogisticCompany.domain.Container;

public class ContainerInfo {
	
	private String cargo;
	private String currentTemp;
	private String currentAirHum;
	private String currentAtmPre;

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
		return new Container();
	}
	
}
