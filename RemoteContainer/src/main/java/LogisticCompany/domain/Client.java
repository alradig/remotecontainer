package LogisticCompany.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.persistence.*;
import LogisticCompany.App.ClientRepository;
import LogisticCompany.info.ClientInfo;

@Entity
public class Client{
    @GeneratedValue
    private long id;
	private String name;
	@Id
	private String email;
	private String password;
	private String refPerson;
	@Embedded
	private Address address;
	@OneToMany
	private List<Journey> journeys = new ArrayList<>();
	
	@OneToMany
	private List<Client> accessList = new ArrayList<>();

	public Client() {
		
	}
	
	public Client(ClientInfo clientInfo) {
		this.name = clientInfo.getName();
		this.email = clientInfo.getEmail();
		this.refPerson = clientInfo.getReference_person();
		this.address = clientInfo.getAddress();
	}

	public List<Journey> getJourneyList(){
		return journeys;
	}
	
	public Stream<Journey> getJourneysStream() {
		return journeys.stream();
	}
	
	public void addJourney(Journey journey){
		journeys.add(journey);
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public String getRefPerson() {
		return refPerson;
	}

	public Address getAddress() {
		return address;
	}
	
	public boolean matchClient(String searchEmail) {
		return email.contains(searchEmail);
	}
	
	public ClientInfo asClientInfo() {
		return new ClientInfo(this.getName(), this.getEmail(), this.getRefPerson());
	}
	
	public void updateClientInfo(ClientInfo clientInfo) {
		this.name = clientInfo.getName();
		this.email = clientInfo.getEmail();
		this.refPerson = clientInfo.getReference_person();
		this.address = clientInfo.getAddress();
	}

	public void addToAccessList(Client client) {
		accessList.add(client);
	}

	public List<Client> getAccessList() {
		return accessList;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
