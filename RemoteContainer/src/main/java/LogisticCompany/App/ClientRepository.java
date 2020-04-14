package LogisticCompany.App;

import java.util.stream.Stream;

import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;

public interface ClientRepository {
	
	boolean contains(Client client);
	
	void addClient(ClientInfo cc);

	Stream<Client> getAllClientsStream();

	void updateClient(Client client);

	void removeClient(Client client);

	void clearClientDatabase();

	Client getClient(String email);
}
