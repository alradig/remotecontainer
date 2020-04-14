package LogisticCompany.domain;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import LogisticCompany.App.ArchivableObject;
import LogisticCompany.App.Database;


public class Client implements ArchivableObject{
	
	private int id;
	private String name;
	private String email;
	private String password;
	private String refPerson;
	private Address address;
	private boolean Register;


	
	public Client(String name, String email, String reference_person, String password) {
		this.name = name;
		this.email = email;
		this.refPerson = reference_person;
		this.password = password;
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
	
	public boolean matchClient(String searchText) {
		return email.contains(searchText);
	}
	
	public void archive() {
		String fileName = "Client_" + this.id + ".json";
		String folderName = "Clients";
		
		Database JSONfile = new Database();
		JSONfile.createFile(this,folderName, fileName);
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Client client = (Client) o;
        return 	this.id == client.getId() &&
        		this.name.equals(client.getName()) &&
        		this.email.equals(client.getEmail()) &&
        		this.password.equals(client.getPw()) &&
        		this.refPerson.equals(client.getRefPerson()) &&
        		this.address.equals(client.getAddress());
    }
	
	@Override
	public int hashCode() {
		return new HashCodeBuilder(19, 53)
				.append(id)
				.append(name)
				.append(email)
				.append(password)
				.append(refPerson)
				.append(address)
				.toHashCode();
	}
}
