
public class Client {
 private int id;
 String name;
 String email;
 String pw;
 String refPerson;
 String address;
 boolean Register;
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
public void setAdress(String adress) {
	this.address = adress;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
}
