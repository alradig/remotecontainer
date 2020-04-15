package LogisticCompany.domain;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import LogisticCompany.App.ArchivableObject;
import LogisticCompany.App.Database;
import LogisticCompany.info.ContainerInfo;

public class Container implements ArchivableObject{
	
	private int id;
	private String cargo;
	private String currentTemp;
	private String currentAirHum;
	private String currentAtmPre;
	
	private List<String> Temp = new ArrayList<String>();
	private List<String> AirHum = new ArrayList<String>();
	private List<String> AtmPre = new ArrayList<String>();
	
//	private ArrayList<String> journeyLog = new ArrayList<String>();
	
	public Container() {
		
	}
	
	public void addTemp(String currentTemp) {
		Temp.add(currentTemp);

	}
	public void addAirHum(String currentAirHum) {
		AirHum.add(currentAirHum);
	}
	
	public void addAtmPre(String currentAtmPre) {
		AtmPre.add(currentAtmPre);
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
	
//	public boolean isSaved() {
//		if(this.a == getInTemp().size() && this.a == getAirHum().size() && this.a== getAtmPre().size()) {
//			return true;
//		} else {
//			return false;
//		}
//	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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
	
	public void archive() {
		String fileName = "Container_" + this.id + ".json";
		String folderName = "Containers";
		
		Database JSONfile = new Database();
		JSONfile.createFile(this,folderName, fileName);
	}
	
//-----------------------------------------------------------------------
//	@Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        
//        Container container = (Container) o;
//        return 	this.id == container.getId() &&
//        		this.getInTemp().equals(container.getInTemp()) &&
//        		this.getAirHum().equals(container.getAirHum()) &&
//        		this.getAtmPre().equals(container.getAtmPre()) &&
//        		this.a == container.a;
//    }
	
//	@Override
//	public int hashCode() {
//		return new HashCodeBuilder(19, 53)
//				.append(id)
//				.append(InTemp)
//				.append(AtmPre)
//				.append(AirHum)
//				.append(a)
//				.toHashCode();
//	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


}
