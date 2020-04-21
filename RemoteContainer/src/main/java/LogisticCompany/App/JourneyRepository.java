package LogisticCompany.App;
import java.util.stream.Stream;

import LogisticCompany.domain.Journey;


public interface JourneyRepository {
	
	boolean contains(Journey journey);
	
	void addJourney(Journey journey); 
	
	Stream<Journey> getAllJourneysStream();

	void removeJourney(Journey journey);

	void clearJourneyDatabase();
	
	Journey getJourney(String cargo);

	void updateJourney(Journey journey);
}
