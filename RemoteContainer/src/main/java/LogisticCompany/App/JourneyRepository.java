package LogisticCompany.App;
import LogisticCompany.domain.Journey;

public interface JourneyRepository {
	
	void clearJourneyDatabase();
	void addJourney(Journey journey); 

}
