import java.util.ArrayList;
import java.util.List;

public class ContainerValues {
	
	public static List<String> InTemp = new ArrayList<String>();
	public static List<String> AirHum = new ArrayList<String>();
	public static List<String> AtmPre = new ArrayList<String>();
	public int a = 0;
	
	public void addInTemp(String value) {
		InTemp.add(value);
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
