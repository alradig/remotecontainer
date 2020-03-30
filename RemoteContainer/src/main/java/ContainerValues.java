import java.util.List;

public class ContainerValues {
	
	public static List<String> InTemp;
	public static List<String> AirHum;
	public static List<String> AtmPre;
	public int a = 0;
	
	public void addInTemp(String value) {
		System.out.println("temp: " + value);
		InTemp.add(value);
		System.out.println("temp: " + value);
		a = a + 1;
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
	
	public boolean isSaved() {
		if(this.a == InTemp.size() && this.a == AirHum.size() && this.a== AtmPre.size()) {
			return true;
		} else {
			return false;
		}
	}
	
}
