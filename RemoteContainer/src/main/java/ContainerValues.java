import java.util.List;

public class ContainerValues {
	
	public static List<String> InTemp;
	public static List<String> AirHum;
	public static List<String> AtmPre;
	
	public void addInTemp(String value) {
		InTemp.add(value);
	}
	
	public void addAirHum(String value) {
		AirHum.add(value);
	}
	
	public void addAtmPre(String value) {
		AtmPre.add(value);
	}

	public void ValsReset() {
		InTemp.clear();
		AirHum.clear();
		AtmPre.clear();
	}
	
}
