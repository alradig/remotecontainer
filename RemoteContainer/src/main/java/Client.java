import java.util.List;

public class Client implements ArchivableObject{
	
	private int id;
	private String name;
	private String email;
	private String pw;
	private String refPerson;
	private String address;
	private boolean Register;
	private String cargo;
	
	public Client() {
		this.id = 0;
		this.name = "";
		this.email = "";
		this.pw = "";
		this.refPerson = "";
		this.address = "";
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
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getRefPerson() {
		return refPerson;
	}
	public void setRefPerson(String refPerson) {
		this.refPerson = refPerson;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
        	System.out.println("Entered here 1!");
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
        	System.out.println("Entered here 2!");
            return false;
        }
        
        Client client = (Client) o;
        return 	this.id == client.getId() &&
        		this.name.equals(client.getName()) &&
        		this.email.equals(client.getEmail()) &&
        		this.pw.equals(client.getPw()) &&
        		this.refPerson.contentEquals(client.getRefPerson()) &&
        		this.address.contentEquals(client.getAddress());
    }
}
