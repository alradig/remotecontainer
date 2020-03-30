import java.util.ArrayList;
import java.util.List;

public class ContainerValues implements ArchivableObject{
	
	private int id;
	private static List<String> InTemp = new ArrayList<String>();
	private static List<String> AirHum = new ArrayList<String>();
	private static List<String> AtmPre = new ArrayList<String>();
	public int a;
	
	public ContainerValues() {
		this.id = 0;
		this.a = 0;
	}
	
	public void addInTemp(String value) {
		getInTemp().add(value);
		a = a + 1;
	}
	
	public void addAirHum(String value) {
		getAirHum().add(value);
	}
	
	public void addAtmPre(String value) {
		getAtmPre().add(value);
	}

	public void ValsReset() {
		getInTemp().clear();
		getAirHum().clear();
		getAtmPre().clear();
	}
	
	public boolean isSaved() {
		if(this.a == getInTemp().size() && this.a == getAirHum().size() && this.a== getAtmPre().size()) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public List<String> getInTemp() {
		return InTemp;
	}

	public static void setInTemp(List<String> inTemp) {
		InTemp = inTemp;
	}
	
	public List<String> getAirHum() {
		return AirHum;
	}

	public static void setAirHum(List<String> airHum) {
		AirHum = airHum;
	}

	public List<String> getAtmPre() {
		return AtmPre;
	}

	public static void setAtmPre(List<String> atmPre) {
		AtmPre = atmPre;
	}
	
	public void archive() {
		String fileName = "Container_" + this.id + ".json";
		String folderName = "Containers";
		
		Database JSONfile = new Database();
		JSONfile.createFile(this,folderName, fileName);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        ContainerValues container = (ContainerValues) o;
        return 	this.id == container.getId() &&
        		this.getInTemp().equals(container.getInTemp()) &&
        		this.getAirHum().equals(container.getAirHum()) &&
        		this.getAtmPre().equals(container.getAtmPre()) &&
        		this.a == container.a;
    }


}
