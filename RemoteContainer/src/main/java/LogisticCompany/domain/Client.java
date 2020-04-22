package LogisticCompany.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
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
	private boolean Register;
	@OneToMany
	private List<Journey> journeys = new ArrayList<>();

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
	
	public void addJourney(Journey journey){
		journeys.add(journey);
	}
	
	public String getName() {
		return name;
	}
	public boolean isRegister() {
		return Register;
	}
	public void setRegister(boolean register) {
		Register = register;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return password;
	}
	public void setPw(String pw) {
		this.password = pw;
	}
	public String getRefPerson() {
		return refPerson;
	}
	public void setRefPerson(String refPerson) {
		this.refPerson = refPerson;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address2) {
		this.address = address2;
	}
	public long getId() {
		return id;
	}
	
	
	public boolean matchClient(String searchEmail) {
		return email.contains(searchEmail);
	}
	
	public ClientInfo asClientInfo() {
		return new ClientInfo(this.getName(), this.getEmail(), this.getRefPerson());
	}

	
}
