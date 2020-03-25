
public class Journey {
	
	String startDestination;
	String endDestination;
	boolean isRegistered;
	String cargo;
	
	
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
	
//	public static void main(String [] args) {
//		Journey journey = new Journey();
//		journey.setStartDestination("DK");
//		journey.setEndDestination("AUS");
//		
//	}
}
