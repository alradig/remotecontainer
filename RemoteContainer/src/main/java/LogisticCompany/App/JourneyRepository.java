package LogisticCompany.App;
import java.util.stream.Stream;

import LogisticCompany.domain.Journey;


public interface JourneyRepository {
	
	boolean contains(Journey journey);
	
	void addJourney(Journey journey); 
	
	Stream<Journey> getAllJourneysStream();
	
	void updateJourney(Journey journey);

	void removeJourney(Journey journey);

	void clearJourneyDatabase();
	
	Journey getJourney(int id);
}
