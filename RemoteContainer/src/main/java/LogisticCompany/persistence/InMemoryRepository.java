package LogisticCompany.persistence;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


import LogisticCompany.App.ClientRepository;
import LogisticCompany.App.ContainerRepository;
import LogisticCompany.App.JourneyRepository;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Journey;
import LogisticCompany.domain.Container;



public class InMemoryRepository implements ClientRepository, ContainerRepository , JourneyRepository{

	List<Client> clients = new ArrayList<>();
	List<Container> containers = new ArrayList<>();
	List<Journey> journeys = new ArrayList<>();

	@Override
	public void addClient(Client client) {
		clients.add(client);
	}

	@Override
	public Stream<Client> getAllClientsStream() {
		return clients.stream();
	}


	@Override
	public boolean contains(Client client) {
		return clients.contains(client);
	}
	
	@Override
	public void clearClientDatabase() {
		clients.clear();
		
	}
	
	@Override
	public boolean contains(Container container) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeClient(Client client) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addContainer(Container container) {
		containers.add(container);
	}

	@Override
	public Stream<Container> getAllContainersStream() {
		return containers.stream();
	}

	@Override
	public void removeContainer(Container container) {
		containers.remove(container);
	}

	@Override
	public void clearContainerDatabase() {
		containers.clear();
	}
	
	@Override
	public void addJourney(Journey journey) {
		journeys.add(journey);
	}

	@Override
	public Stream<Journey> getAllJourneysStream() {
		return journeys.stream();
	}

	@Override
	public void removeJourney(Journey journey) {
		journeys.remove(journey);
	}
	
	@Override
	public boolean contains(Journey journey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clearJourneyDatabase() {
		journeys.clear();
		
	}

	@Override
	public Container getContainer(String cargo) {
	return containers.stream().filter(c -> c.getCargo().equals(cargo)).findFirst().orElse(null);
	}


	@Override
	public Journey getJourney(String cargo) {
		return journeys.stream().filter(j -> j.getCargo().equals(cargo)).findFirst().orElse(null);
	}

	@Override
	public Client getClient(String email) {
		return clients.stream().filter(c -> c.getEmail().equals(email)).findFirst().orElse(null);
	}

	@Override
	public void updateJourney(Journey journey) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateContainer(Container container) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateClient(Client client) {
		// TODO Auto-generated method stub
		
	}

	

	
}
