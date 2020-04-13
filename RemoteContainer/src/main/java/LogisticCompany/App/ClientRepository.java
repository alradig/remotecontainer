package LogisticCompany.App;

import java.util.stream.Stream;

import LogisticCompany.domain.Client;

public interface ClientRepository {
	
	boolean contains(Client client);
	
	void addClient(Client client);

	Stream<Client> getAllClientsStream();

	void updateClient(Client client);

	void removeClient(Client client);

	void clearClientDatabase();

	Client getClient(int id);
}
