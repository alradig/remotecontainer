package LogisticCompany.info;
import java.util.ArrayList;
import java.util.List;

import LogisticCompany.domain.Address;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Journey;

/**
 * This class represents a client with name, email, password, reference person and an address
 * Each client has list of journeys and a list of other clients that this client has access to.
 */
public class ClientInfo {
	private String name;
	private String email;
	private String reference_person;
	private Address address;
	private List<Journey> journeys;
	private List<Client> accessList;
	
	

//	public ClientInfo(String name, String email, String reference_person, Address adress, List<Journey> journeys , List<Client> accessList ) {
//		this.name = name;
//		this.email = email;
//		this.reference_person = reference_person;
//		this.address = adress;
//		this.journeys =journeys;
//		this.accessList = accessList;
//	}
	
	public ClientInfo(String name, String email, String reference_person) {
		this.name = name;
		this.email = email;
		this.reference_person = reference_person;
		this.journeys = new ArrayList<>();
	}
	
	public ClientInfo(Client client) {
		this.name = client.getName();
		this.email = client.getEmail();
		this.reference_person = client.getRefPerson();
		this.address = client.getAddress();
		this.journeys = client.getJourneyList();

	}
	
	public List<Client> getAccessList() {
		return accessList;
	}

	public List<Journey> getJourneys() {
		return journeys;
	}

	public String getReference_person() {
		return reference_person;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public Client asClient() {
		return new Client(this);
	}
	
	public void setRefPerson(String refPerson) {
		this.reference_person = refPerson;
	}
	
	public String toString() {
		return getName() + ", " + getEmail();
	}
	
}