package LogisticCompany.App;
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
	
	public void registerUser(UserInfo u) throws Exception {
			checkLogisticCompanyLoggedIn();
			User user = findUser(u);
			if (user != null) {
				throw new Exception("User is already registered");
			}
			clientRepository.addClient(u.asUser());
	}
	
	
	private Client searchClient() {
		
	}
	
	
	private Container searchContainer() {
		
	}
	
	private Journey searchJourney() {
		
		
		return Journey;
	}
	
	public void registerClient(ClientInfo cc) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		// register group ....
		
		//repository done
		clientRepository.addClient(cc.asClient());
		
	}
	
	public void registerContainer(ContainerInfo c) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		// register group ....
		// 
		
		//repository done
		containerRepository.addContainer(c.asContainer());
		
	}
	
	public void registerJourney(JourneyInfo j) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		// register group ....
		// 
				
		//repository done
		journeyRepository.addJourney(j.asJourney());
	}
	
	public void removeClient() {
		
	}
	public void removeContainer() {
		
	}
	public void removeJourney() {
		
	}
	
	public void updateJourney() {
		
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
			throw new OperationNotAllowedException("logisticCompany login required");
		}}
	public void setRepositories(ClientRepository clientRepo, JourneyRepository journeyRepo, ContainerRepository containerRepo ) {
		this.clientRepository = clientRepo;
		this.journeyRepository = journeyRepo;	
		this.containerRepository = containerRepo;
		
	}

}
