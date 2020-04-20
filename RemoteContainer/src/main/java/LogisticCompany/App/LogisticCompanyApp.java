package LogisticCompany.App;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.ContainerStatus;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;


public class LogisticCompanyApp {

	private boolean logicticCompanyloggedIn = false;
	private boolean clientLoggedIn = false;
	private ClientRepository clientRepository;
	private JourneyRepository journeyRepository;
	private ContainerRepository containerRepository;
	private Database database;
	private ContainerStatus containerStatus; 

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
	
	
	public Client findClient(ClientInfo cc) {
		return clientRepository.getClient(cc.getEmail());
	}
	
//	private Container searchContainer() {
//		
//	}
	
	public Container findContainer(ContainerInfo container) {
		return containerRepository.getContainer(container.getCargo());
	}

	public Journey findJourney(JourneyInfo j) {
		return journeyRepository.getJourney(j.getCargo());
	}
	
	public List<ClientInfo> searchClient(String searchEmail) {
		return clientRepository.getAllClientsStream()
				.filter(c -> c.matchClient(searchEmail))
				.map(c -> c.asClientInfo())
				.collect(Collectors.toList());
	}

	public List<JourneyInfo> searchJourney(String searchCargo) {
		return journeyRepository.getAllJourneysStream()
				.filter(j -> j.matchJourney(searchCargo))
				.map(j -> j.asJourneyInfo())
				.collect(Collectors.toList());
	}
	
	public void registerClient(ClientInfo cc) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		
		Client client = findClient(cc);
		if (client != null) {
			throw new OperationNotAllowedException("The client is already registered");
		}
		
		clientRepository.addClient(cc.asClient());
	}
	
	public void registerContainer(ContainerInfo c) throws OperationNotAllowedException {
		// checkLogisticCompanyLoggedIn();
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

	public void updateJourneyInfo(JourneyInfo journeyInfo) {
		logisticCompanyLoggedIn();
		journeyInfo.addLocationToLog(journeyInfo, calenderDate.getCurrentDate());		
	}
	
	
	public boolean logisticCompanyLogin(String password) {
		logicticCompanyloggedIn = password.equals("logisticCompany123");
		return logicticCompanyloggedIn;
	}
	
	public boolean logisticCompanyLoggedIn() {
		return logicticCompanyloggedIn;
	}
	
	public void logisticCompanyLogout() {
		logicticCompanyloggedIn = false;
	}
	
	public boolean clientLoggedIn() {
		return clientLoggedIn;
	}
	
	public void checkLogisticCompanyLoggedIn() throws OperationNotAllowedException {
		if (!logisticCompanyLoggedIn()) {
			throw new OperationNotAllowedException("Logistic Company login required");
		}}
	
	public void checkClientLoggedIn() throws OperationNotAllowedException {
		if (!clientLoggedIn()) {
			throw new OperationNotAllowedException("Client login required");
		}}
	
	
	public void setRepositories(ClientRepository clientRepo, JourneyRepository journeyRepo, ContainerRepository containerRepo ) {
		this.clientRepository = clientRepo;
		this.journeyRepository = journeyRepo;	
		this.containerRepository = containerRepo;
		
	}

	public Stream<ClientInfo> getClientsStream() {
		return this.clientRepository.getAllClientsStream().map(c -> new ClientInfo(c));
	}
	
	public Stream<JourneyInfo> getJourneysStream() {
		return this.journeyRepository.getAllJourneysStream().map(j -> new JourneyInfo(j));
	}

	public boolean clientLogin(String clientPassword) {
		clientLoggedIn = clientPassword.equals("client123");
		return clientLoggedIn;
	}

	public void clientLogout() {
		clientLoggedIn = false;
	}

	public void registerContainerToJourney(ContainerInfo container, JourneyInfo journey) throws OperationNotAllowedException{
		checkLogisticCompanyLoggedIn();
		Journey journeyObj = findJourney(journey);
		Container containerObj = findContainer(container);
		
		journeyObj.setContainer(containerObj);
	}
	
	public void registerJourneyToClient(ClientInfo client, JourneyInfo journey) throws OperationNotAllowedException{
		Journey journeyObj = findJourney(journey);
		Client clientObj = findClient(client);
		
		clientObj.addJourney(journeyObj);
	}

	public void addMeasurements(Container container, ContainerStatus containerStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		containerStatus.addToMeasurementList(containerStatus.getCurrentTemp(), containerStatus.getCurrentAirHum(), containerStatus.getCurrentAtmPre());		
		container.setContainerStatus(containerStatus); 
	
	}

	
}
