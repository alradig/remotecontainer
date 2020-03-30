import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Journey implements ArchivableObject{
	
	private int id = 0;
	
	String startDestination;
	String endDestination;
	boolean isRegistered;
	String cargo;
	String dateTime;
	String currentLocation;
	boolean endDestinationReached;
	ArrayList<String> list = new ArrayList<String>();
	
	private String JSONPath = "/Users/alradig/Desktop/Database/Journeys/";
	
	public void setStartDestination(String startDestination) {
		this.startDestination = startDestination;
	}
	
	public String getStartDestination() {
		return startDestination;
	}

	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}
	
	public String getEndDestination() {
		return endDestination;
	}

	public void setRegistrationStatus(boolean isRegistered) {
		this.isRegistered = isRegistered;
	}
	
	public boolean getRegistrationStatus() {
		return isRegistered;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCargo() {
		return cargo;
	}

	public void registerJourney(Journey journey) {
		if (journeyInformationNotComplete(journey))
		{
			this.isRegistered = false; 
		}
		else {
			this.isRegistered = true; 
		}
		
	}

	public boolean journeyInformationNotComplete(Journey journey) {
		return cargoIsEmpty(journey) || endDestinationIsEmpty(journey) || startDestinationIsEmpty(journey);
	}

	 public boolean startDestinationIsEmpty(Journey journey) {
		return journey.getStartDestination() == null;
	}

	public boolean endDestinationIsEmpty(Journey journey) {
		return journey.getEndDestination() == null;
	}
	
	public boolean cargoIsEmpty(Journey journey) {
		return journey.getCargo() == null;
		
	}
	
	public void setCurrentDate() {
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String  dateTime= formatter.format(date);
		this.dateTime = dateTime; 
	}

	public String getCurrentDate() {
		return dateTime; 
	}
	
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
		
	}
	public String getCurrentLocation(){
		return currentLocation;
		
	}

	public void updateJourneyInfo() {
		String currentInfo = this.currentLocation+ " " + this.dateTime ;
		list.add(currentInfo); 
		
		isJourneyDone();

	}

	public void isJourneyDone() {
		if (this.currentLocation == this.endDestination)
		{
			endDestinationReached = true; 
		}
		else { endDestinationReached = false; }
	}
	
	public void archive() {
//		String fileName = "Journey_" + this.id + ".json";
//		String path = this.JSONPath + fileName;
//		
//		JSONDocument JSONfile = new JSONDocument();
//		JSONfile.createDocument(this,path);
	}
	
//	public static void main(String [] args) {
//		Journey journey = new Journey();
//		journey.setStartDestination("DK");
//		journey.setEndDestination("AUS");
//		
//	}
}
