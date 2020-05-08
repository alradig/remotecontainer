package LogisticCompany.App;
import java.util.stream.Stream;

import LogisticCompany.domain.Journey;


public interface JourneyRepository {
	
	void addJourney(Journey journey); 
	
	Stream<Journey> getAllJourneysStream();

	void clearJourneyDatabase();
	
	Journey getJourney(String cargo);

	void updateJourney(Journey journey);
}
