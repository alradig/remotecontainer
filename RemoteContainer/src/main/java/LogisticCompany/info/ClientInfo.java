package LogisticCompany.info;

import LogisticCompany.domain.Client;


public class ClientInfo {
	private String id;
	private String name;
	private String email;
	
	public ClientInfo(String id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}
	
	public ClientInfo(Client client) {
		this.id = client.getId();
		this.name = client.getName();
		this.email = client.getEmail();
	}
	
	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
	public String getId() {
		return id;
	}
	
	public Client asClient() {
	
		return new Client(id,name,email);
	}
	
	
	

}
