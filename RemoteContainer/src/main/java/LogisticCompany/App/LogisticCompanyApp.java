package LogisticCompany.App;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatusEntry;
import LogisticCompany.domain.ContainerStatusEntry;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;


public class LogisticCompanyApp {

	private boolean logisticCompanyloggedIn = false;
	private boolean clientLoggedIn = false;
	private ClientRepository clientRepository;
	private JourneyRepository journeyRepository;
	private ContainerRepository containerRepository;
	private ContainerStatusEntry containerStatus; 
	private JourneyStatusEntry journeyStatus; 
	private CalenderDate calenderDate = new CalenderDate();
	private Client client;
	

	
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
	
	public List<ContainerInfo> searchContainer(String cargo) {
		return containerRepository.getAllContainersStream()
				.filter(c -> c.matchContainer(cargo))
				.map(c -> c.asContainerInfo())
				.collect(Collectors.toList());
	}

	public List<JourneyInfo> searchJourney(String searchCargo) {
		return journeyRepository.getAllJourneysStream()
				.filter(j -> j.matchJourney(searchCargo))
				.map(j -> j.asJourneyInfo())
				.collect(Collectors.toList());
	}
	
	public void registerClient(ClientInfo cc, String password) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		
		Client client = findClient(cc);
		if (client != null) {
			throw new OperationNotAllowedException("The client is already registered");
		}
		
		clientRepository.addClient(cc.asClient());
		setClientPassword(cc,password);
	}
	
	public void registerContainer(ContainerInfo c) throws OperationNotAllowedException {
		containerRepository.addContainer(c.asContainer());
	}
	
	public void registerJourney(JourneyInfo j) {
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
		if (j.getLocation().equals(j.getDestinationPort()))
		{
			return true; 
		}
		else { return false; }
	}
	
	public boolean logisticCompanyLogin(String password) {
		logisticCompanyloggedIn = password.equals("logisticCompany123");
		return logisticCompanyloggedIn;
	}
	
	public boolean logisticCompanyLoggedIn() {
		return logisticCompanyloggedIn;
	}
	
	public void logisticCompanyLogout() {
		logisticCompanyloggedIn = false;
	}
	
	public boolean clientLoggedIn() {
		return clientLoggedIn;
	}
	
	public void checkLogisticCompanyLoggedIn() throws OperationNotAllowedException {
		if (!logisticCompanyLoggedIn()) {
			throw new OperationNotAllowedException("Logistic Company login required");
		}
	}
	
	public void checkClientLoggedIn() throws OperationNotAllowedException {
		if (!clientLoggedIn()) {
			throw new OperationNotAllowedException("Client login required");
		}
	}
	
	
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

	public boolean clientLogin(String email, String password) throws OperationNotAllowedException{
		client = findClient(new ClientInfo("",email,""));
		
		if (client == null) {
			throw new OperationNotAllowedException("No client registered with the given email!");
		}

		clientLoggedIn = password.equals(client.getPassword());
		
		if (clientLoggedIn == false) {
			throw new OperationNotAllowedException("Incorrect password!");
		}
		
		return clientLoggedIn;
	}

	public void clientLogout() {
		clientLoggedIn = false;
	}

	public void registerContainerToJourney(ContainerInfo containerInfo, JourneyInfo journey) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		
		Journey journeyObj = findJourney(journey);
		Container containerObj = findContainer(containerInfo);
		
		journeyObj.setContainer(containerObj);
		updateContainerInfo(containerObj,containerObj.asContainerInfo());
	}
	
	public void registerJourneyToClient(ClientInfo client, JourneyInfo journey) throws OperationNotAllowedException{
		
		Journey journeyObj = findJourney(journey);
		Client clientObj = findClient(client);
		
		clientObj.addJourney(journeyObj);
	}

	public void addMeasurements(Container container, ContainerStatusEntry containerStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		container.updateContainerStatus(containerStatus);		
	
	}
	
	public void updateJourneyInfo(Journey journey, JourneyStatusEntry journeyStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		journey.setJourneyStatus(journeyStatus);
		journeyRepository.updateJourney(journey);
	}
	
	public void updateClientInfo(Client client, ClientInfo clientInfo) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		client.updateClientInfo(clientInfo);
		clientRepository.updateClient(client);
	}
	
	public void updateContainerInfo(Container container, ContainerInfo containerInfo) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		container.updateContainerInfo(containerInfo);
		containerRepository.updateContainer(container);
	}
	
	
	public List<Container> getClientContainers(ClientInfo clientInfo) {
//		List<Journey> journeyList = client.getJourneyList();
		Client client = findClient(clientInfo);
		return client.getJourneysStream().map(j -> j.getContainer()).collect(Collectors.toList());	
	}

	public void provideAccess(ClientInfo clientInfo1, ClientInfo clientInfo2) {
		Client client = findClient(clientInfo1);
		Client client2 = findClient(clientInfo2);
		
		client2.addToAccessList(client);
		clientRepository.updateClient(client2);
	}
	
	public List<Container> collectAccessibleContainers(ClientInfo clientInfo) {
		Client client = findClient(clientInfo);
		List<Container> ContainersList = getClientContainers(clientInfo);
		
		List<Client> clientAccessList = client.getAccessList();
		if(!clientAccessList.isEmpty()) {
			for (Client c : clientAccessList) {
				List<Journey> journeyList = c.getJourneyList();
				for (Journey j : journeyList) {
					ContainersList.add(j.getContainer());
				}
			}
		}		
		return ContainersList;
	}

	public void setClientPassword(ClientInfo clientInfo, String password) {
		Client client = findClient(clientInfo);
		client.setPassword(password);
		
	}
	
}
