package LogisticCompany.domain;

import LogisticCompany.App.ArchivableObject;
import LogisticCompany.App.ClientRepository;
import LogisticCompany.App.Database;
import LogisticCompany.info.ClientInfo;


public class Client implements ArchivableObject{
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String refPerson;
	private Address address;
	private boolean Register;


	
	public Client(String name, String email, String reference_person) {
		this.name = name;
		this.email = email;
		this.refPerson = reference_person;
	}

	public Client() {}; // Needed by Java Persistence Layer
	

//	public Client() {
//		this.id = 0;
//		this.name = "";
//		this.email = "";
//		this.pw = "";
//		this.refPerson = "";
//		this.address = "";
//	}
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public boolean matchClient(String searchEmail) {
		return email.contains(searchEmail);
	}
	
	public void archive() {
		String fileName = "Client_" + this.id + ".json";
		String folderName = "Clients";
		
		Database JSONfile = new Database();
		JSONfile.createFile(this,folderName, fileName);
	}
	
	public ClientInfo asClientInfo() {
		return new ClientInfo(this.getName(), this.getEmail(), this.getRefPerson());
	}

	
}
