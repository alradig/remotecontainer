
public class Client {
	
	private int id;
	String name;
	String email;
	String pw;
	String refPerson;
	String address;
	boolean Register;
	String cargo;
	
	
	public String getName() {
		return name;
	}
	public boolean isRegister() {
		return Register;
	}
	public void setRegister(boolean register) {
		Register = register;
	}
	public ResponseObject setName(String name) {
		int code = 100;
		String message = "Invalid client information! Please try again!";
		
		if (!name.isEmpty()) {
			this.name = name;
			code = 200;
			message = "Client information successfully updated!";		
		}
		
		ResponseObject response = new ResponseObject(code, message);
			
		return response;
	}
	public String getEmail() {
		return email;
	}
	public ResponseObject setEmail(String email) {
		int code = 100;
		String message = "Invalid client information! Please try again!";
		
		if (!email.isEmpty()) {
			this.email = email;
			code = 200;
			message = "Client information successfully updated!";		
		}
		
		ResponseObject response = new ResponseObject(code, message);
			
		return response;
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
	public ResponseObject setRefPerson(String refPerson) {
		int code = 100;
		String message = "Invalid client information! Please try again!";
		
		if (!refPerson.isEmpty()) {
			this.refPerson = refPerson;
			code = 200;
			message = "Client information successfully updated!";		
		}
		
		ResponseObject response = new ResponseObject(code, message);
			
		return response;
	}
	public String getAddress() {
		return address;
	}
	public ResponseObject setAddress(String address) {
		int code = 100;
		String message = "Invalid client information! Please try again!";
		
		if (!address.isEmpty()) {
			this.address = address;
			code = 200;
			message = "Client information successfully updated!";		
		}
		
		ResponseObject response = new ResponseObject(code, message);
			
		return response;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
