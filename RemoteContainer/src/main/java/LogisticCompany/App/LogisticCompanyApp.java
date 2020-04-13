package LogisticCompany.App;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;


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
			checklogisticCompanyLoggedIn();
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
	
	public void registerClient() {
		
	}
	
	public void registerContainer() throws OperationNotAllowedException {
		checklogisticCompanyLoggedIn();
		containerRepository.addContainer(container.asContainer());
		
	}
	
	public void registerJourney() {
		
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
	
	private void checklogisticCompanyLoggedIn() throws OperationNotAllowedException {
		if (!logisticCompanyLoggedIn()) {
			throw new OperationNotAllowedException("logisticCompany login required");
		}}
	public void setRepositories(MediumRepository mediumRepo, UserRepository userRepo) {
		this.mediumRepository = mediumRepo;
		this.userRepository = userRepo;		
	}

}
