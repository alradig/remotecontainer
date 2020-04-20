package LogisticCompany.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import LogisticCompany.App.ArchivableObject;
import LogisticCompany.App.Database;
import LogisticCompany.info.ContainerInfo;

public class Container {
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id;
	private String cargo;
	private String currentTemp;
	private String currentAirHum;
	private String currentAtmPre;
	
	private ArrayList<String> Temp = new ArrayList<String>();
	private ArrayList<String> AirHum = new ArrayList<String>();
	private ArrayList<String> AtmPre = new ArrayList<String>();
	
	public Container() {
		this.id = count.incrementAndGet(); 
	}

	public Container(String cargo) {
		this.cargo = cargo;
		this.id = count.incrementAndGet(); 
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
	
	public int getId() {
		return id;
	}
		
	public static boolean containerRegistered(Container container) {
		return container.getId() == 0;
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
	
//	public void archive() {
//		String fileName = "Container_" + this.id + ".json";
//		String folderName = "Containers";
//		
//		Database JSONfile = new Database();
//		JSONfile.createFile(this,folderName, fileName);
//	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	
}
