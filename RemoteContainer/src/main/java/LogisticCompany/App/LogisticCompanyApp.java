package LogisticCompany.App;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;

import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;


public class LogisticCompanyApp {

	private boolean loggedIn = false;
	private ClientRepository clientRepository;
	private JourneyRepository journeyRepository;
	private ContainerRepository containerRepository;

	private Database database;

	private CalenderDate calenderDate = new CalenderDate();
	

	
	public LogisticCompanyApp(ClientRepository clientRepository, JourneyRepository journeyRepository, ContainerRepository containerRepository ) {
		this.containerRepository = containerRepository;
		this.journeyRepository = journeyRepository;
		this.clientRepository = clientRepository;
	}
	
	public LogisticCompanyApp() {
	}

	public void clearDatabase() {
		clientRepository.clearClientDatabase();
		journeyRepository.clearJourneyDatabase();
		containerRepository.clearContainerDatabase();
	}
	
	
	private Client findClient(ClientInfo cc) {
		return clientRepository.getClient(cc.getEmail());	
	}
	
//	private Container searchContainer() {
//		
//	}

	private Journey findJourney(JourneyInfo j) {
		return journeyRepository.getJourney(j.getCargo());
	}
	
	public List<Object> searchClient(String searchEmail) {
		return clientRepository.getAllClientsStream()
				.filter(b -> b.matchClient(searchEmail))
				.map(b -> b.getEmail())
				.collect(Collectors.toList());
	}
	
//	public void registerUser(UserInfo u) throws Exception {
//			checkLogisticCompanyLoggedIn();
//			User user = findUser(u);
//			if (user != null) {
//				throw new Exception("User is already registered");
//			}
//			clientRepository.addClient(u.asUser());
//	}
	
	public void registerClient(ClientInfo cc) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
//		Client client = findUser(u);
//		if (user != null) {
//			throw new Exception("User is already registered");
//		}
//	
		clientRepository.addClient(cc);
		
	}
	
	public void registerContainer(ContainerInfo c) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		// register group ....
		// 
		
		//repository done
		containerRepository.addContainer(c.asContainer());
		
	}
	
	public void registerJourney(JourneyInfo j) {
		
		// register group ....
		// 
		
		
				
		//repository done
		journeyRepository.addJourney(j.asJourney());
	}
	
	public void unregisterClient(ClientInfo cc, JourneyInfo j)throws Exception {
		Client client = findClient(cc);
		logisticCompanyLoggedIn();
		if (!isJourneyDone(j) )
		{
			throw new Exception("Can not unregister a client when a journey is on going");
		}
		clientRepository.removeClient(client);
	}
	
	public boolean isJourneyDone(JourneyInfo j) {
		if (j.getCurrentLocation().equals(j.getEndDestination()))
		{
			return true; 
		}
		else { return false; }
	}
	
	public void setNewLocation() {
		
	}

	public void updateJourneyInfo(JourneyInfo j) {
		logisticCompanyLoggedIn();
		Journey journey = findJourney(j);
//		Client client = searchClient(cc);
		journey.addLocationToLog(journey , calenderDate.getCurrentDate());
		journeyRepository.updateJourney(journey); 		
		// need more
		// if journey done automatically terminates and give info
	}
	
	
	public boolean logisticCompanyLogin(String password) {
		loggedIn = password.equals("logisticCompany123");
		return loggedIn;
		
}
	public boolean logisticCompanyLoggedIn() {
		return loggedIn;
	}
	public void logisticCompanyLogout() {
		loggedIn = false;
	}
	
	private void checkLogisticCompanyLoggedIn() throws OperationNotAllowedException {
		if (!logisticCompanyLoggedIn()) {
			throw new OperationNotAllowedException("Logistic Company login required");
		}}
	
	
	public void setRepositories(ClientRepository clientRepo, JourneyRepository journeyRepo, ContainerRepository containerRepo ) {
		this.clientRepository = clientRepo;
		this.journeyRepository = journeyRepo;	
		this.containerRepository = containerRepo;
		
	}

}
