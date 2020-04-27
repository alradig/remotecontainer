package LogisticCompany.App;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.JourneyStatusEntry;
import LogisticCompany.domain.ContainerStatusEntry;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.info.JourneyInfo;


public class LogisticCompanyApp {
	
	private PropertyChangeSupport support = new PropertyChangeSupport(this);
	
	private boolean logisticCompanyloggedIn = false;
	private boolean clientLoggedIn = false;
	private ClientRepository clientRepository;
	private JourneyRepository journeyRepository;
	private ContainerRepository containerRepository;
	private ContainerStatusEntry containerStatus; 
	private JourneyStatusEntry journeyStatus; 
	private CalenderDate calenderDate = new CalenderDate();
	private Client client;
	private JourneyInfo selectedJourneyInfo;
	private ContainerInfo selectedContainerInfo;
	private Container selectedContainer;
	private Journey selectedJourney;
	private String errorMessage;
	
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
	
	public List<ClientInfo> searchClient(String searchText) {
		return clientRepository.getAllClientsStream()
				.filter(c -> c.matchClient(searchText))
				.map(c -> c.asClientInfo())
				.collect(Collectors.toList());
	}
	
	public List<ContainerInfo> searchContainer(String cargo) {
		return containerRepository.getAllContainersStream()
				.filter(c -> c.matchContainer(cargo))
				.map(c -> c.asContainerInfo())
				.collect(Collectors.toList());
	}

	public List<JourneyInfo> searchJourney(String searchText) {
		return journeyRepository.getAllJourneysStream()
				.filter(j -> j.matchJourney(searchText))
//				.filter(j -> client.matchClient(client.getEmail()))
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
	
	public void registerClient(String name, String email, String password, String zipCode, String city, String street, String refPerson) throws OperationNotAllowedException {
		ClientInfo clientInfo = new ClientInfo(name, email, refPerson);
		
		Address address = new Address(street,zipCode,city);
		clientInfo.setAddress(address);
		
		registerClient(clientInfo, password);
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
	
	public boolean logisticCompanyLogin(String password) throws OperationNotAllowedException {
		logisticCompanyloggedIn = password.equals("logisticCompany123");
		
		if (logisticCompanyloggedIn == false) {
			throw new OperationNotAllowedException("Incorrect password!");
		}
		
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
		this.client = findClient(new ClientInfo("",email,""));
		
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

	public void registerContainerToJourney(ContainerInfo containerInfo, JourneyInfo journeyInfo) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		
		Journey journeyObj = findJourney(journeyInfo);
		Container containerObj = findContainer(containerInfo);
		
		journeyObj.setContainer(containerObj);
		updateContainerInfo(containerObj,containerObj.asContainerInfo());
		journeyRepository.updateJourney(journeyObj);
	}
	
	public void registerJourney(String cargo, String originPort, String endDestination) {
		JourneyInfo journeyInfo = new JourneyInfo(cargo, originPort, endDestination);
		
		registerJourney(journeyInfo);
		
		registerJourneyToClient(client.asClientInfo(), journeyInfo);
	}
	
	public void registerJourneyToClient(ClientInfo client, JourneyInfo journey){
		
		Journey journeyObj = findJourney(journey);
		Client clientObj = findClient(client);
		
		clientObj.addJourney(journeyObj);
		clientRepository.updateClient(clientObj);
	}

	public void addMeasurements(Container container, ContainerStatusEntry containerStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		container.updateContainerStatus(containerStatus);		
		containerRepository.updateContainer(container);
	}
	
	public void updateJourneyInfo(Journey journey, JourneyStatusEntry journeyStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		journey.setJourneyStatus(journeyStatus);
		journeyRepository.updateJourney(journey);
	}
	public void updateJourneyInfo(JourneyInfo journeyinfo, JourneyStatusEntry journeyStatus) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		Journey journey = findJourney(journeyinfo);
		journey.setJourneyStatus(journeyStatus);
		journeyRepository.updateJourney(journey);
	}
	public void updateSelectedJourney(String newLocation) throws OperationNotAllowedException {
		checkLogisticCompanyLoggedIn();
		JourneyStatusEntry newEntry = new JourneyStatusEntry("not registered");
		
		if(!newLocation.isEmpty()) {
			newEntry.setLocation(newLocation);
		}
		try {
			updateJourneyInfo(this.selectedJourney, newEntry);
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}
		
		support.firePropertyChange("UpdatedJourney",null,null);
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

	public boolean provideAccess(String name, String email) throws  Exception{
		ClientInfo clientInfo2 = new ClientInfo(name, email, "");
		
		Client client2 = findClient(clientInfo2);
		
		if(client2 == null) {
			throw new OperationNotAllowedException("No client registered with the given email!");
		}
		
		if(!client2.getName().equals(name)) {
			throw new OperationNotAllowedException("Client name and email do not match!");
		}
		
		provideAccess(client.asClientInfo(),client2.asClientInfo());
		return true;
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
	
//	public List<Container> collectAccessibleJourneys(String searchText) {
//		client = findClient(client.asClientInfo());
//		
//		List<Client> accessList = client.getAccessList();
//		
//		for (Client c : accessList) {
//			List<Journey> JourneysList = c.getJourneyList();
//		}
//		
//		
//		List<Client> clientAccessList = client.getAccessList();
//		if(!clientAccessList.isEmpty()) {
//			for (Client c : clientAccessList) {
//				List<Journey> journeyList = c.getJourneyList();
//				for (Journey j : journeyList) {
//					ContainersList.add(j.getContainer());
//				}
//			}
//		}		
//		return ContainersList;
//	}

	public void setClientPassword(ClientInfo clientInfo, String password) {
		Client client = findClient(clientInfo);
		client.setPassword(password);
		
	}
	
	public Client getClient() {
		return client;
	}
	
	public void addObserver(PropertyChangeListener l) {
		support.addPropertyChangeListener(l);
	}

	public JourneyInfo getSelectedjourneyInfo() {
		return selectedJourneyInfo;
	}
	
	public ContainerInfo getSelectedContainerInfo() {
		return this.selectedContainerInfo;
	}

	public void setSelectedObjects(JourneyInfo selectedJourneyInfo) {
		this.selectedJourneyInfo = selectedJourneyInfo;
		this.selectedJourney = findJourney(selectedJourneyInfo);

		this.selectedContainer = selectedJourney.getContainer();
		selectedContainerInfo = this.selectedContainer.asContainerInfo();
		
		support.firePropertyChange("SelectedJourney",null,null);
	}

	public void updateSelectedContainer(String temperature, String humidity, String airPressure) {
		ContainerStatusEntry newEntry;
		ContainerStatusEntry previousEntry;
		List<ContainerStatusEntry> ContainerStatusList = selectedContainer.getContainerStatusList();
		
		if(!ContainerStatusList.isEmpty()) {
			previousEntry = ContainerStatusList.get(ContainerStatusList.size()-1);
			newEntry = new ContainerStatusEntry(previousEntry.getTemperature(), previousEntry.getAirHumidity(), previousEntry.getAtmPressure());
		}else {
			newEntry = new ContainerStatusEntry("not registered","not registered","not registered");
		}
		
		
		if(temperature != null && !temperature.isEmpty()) {
			newEntry.setTemperature(temperature);
		}
		
		if(!humidity.isEmpty()) {
			newEntry.setHumidity(humidity);
		}
		
		if(!airPressure.isEmpty()) {
			newEntry.setPressure(airPressure);
		}
		
		try {
			addMeasurements(this.selectedContainer, newEntry);
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}
		
		support.firePropertyChange("UpdatedContainer",null,null);
	}
	
	
	
}
