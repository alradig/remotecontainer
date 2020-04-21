package LogisticCompany.App;

import java.util.stream.Stream;

import LogisticCompany.domain.Client;
import LogisticCompany.info.ClientInfo;

public interface ClientRepository {
	
	boolean contains(Client client);
	
	void addClient(Client cc);

	Stream<Client> getAllClientsStream();

	void removeClient(Client client);

	void clearClientDatabase();

	Client getClient(String email);

	void updateClient(Client client);
}
