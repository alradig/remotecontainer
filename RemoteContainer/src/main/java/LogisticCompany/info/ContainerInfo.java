package LogisticCompany.info;

import java.util.ArrayList;
import java.util.List;

import LogisticCompany.domain.Container;
import LogisticCompany.domain.ContainerStatusEntry;

public class ContainerInfo {
	
	private String cargo;
	private String currentTemp;
	private String currentAirHum;
	private String currentAtmPre;
	private ContainerStatusEntry containerStatus;
	
	public ContainerInfo(String cargo) {
		this.cargo = cargo;
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
	
	public ContainerStatusEntry getContainerStatus() {
		return containerStatus;
	}
	

	
}
