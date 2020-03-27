
public class ClientForm {
	
	private Client client;	
	private ResponseObject response;;
	
	private String nameField;
	private String emailField;
	private String pwField;
	private String refPersonField;
	private String addressField;
	
	public ClientForm(Client client) {
		this.client = client;
	}

	public void setNameField(String name) {
		this.nameField = name;

	}

	public void setEmailField(String emailField) {
		this.emailField = emailField;

	}

	public void setRefPersonField(String refPersonField) {
		this.refPersonField = refPersonField;

	}

	public void setAddressField(String addressField) {
		this.addressField = addressField;

	}
	
	public ResponseObject submit() {
		if (this.validFields()) {
			this.client.setName(nameField);
			this.client.setEmail(emailField);
			this.client.setPw(pwField);
			this.client.setRefPerson(refPersonField);
			this.client.setAddress(addressField);
			
			response = new ResponseObject(200,"Client information successfully updated!");
			
		}else {
			response = new ResponseObject(100,"Invalid client information! Please try again!");
		}

		return this.response;
	}

	private boolean validFields() {
		Boolean result = true;		
		
		if (this.nameField.isEmpty() || this.addressField.isEmpty()) {
			System.out.println("Entered empty");
		}else {
			System.out.println("Entered filled");
		}
		if (this.nameField.isEmpty() || this.addressField.isEmpty() || this.pwField.isEmpty() || this.refPersonField.isEmpty() || this.addressField.isEmpty()) {
			result = false;
		}
		return result;
	}

	public void setPw(String string) {
		this.pwField = string;
		
	}
}
