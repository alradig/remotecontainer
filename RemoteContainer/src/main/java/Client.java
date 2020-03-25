
public class Client {
 String name;
 String email;
 String pw;
 String refPerson;
 String adress;
 boolean Register;
String cargo;

	
	public void setCargo(String cargo) {
		this.cargo = cargo;		
	}
	
	public String getCargo() {
		return cargo;		
	}

	public void setClientName(String name) {
		this.name = name;
	}
	
	public String getClientName() {
		return name;
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
public String getAdress() {
	return adress;
}
public void setAdress(String adress) {
	this.adress = adress;
}

}
