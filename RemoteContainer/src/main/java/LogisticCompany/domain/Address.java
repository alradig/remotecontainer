package LogisticCompany.domain;

import javax.persistence.Embeddable;
/**
 * This class represents an address with street, post code and city
 */

@Embeddable
public class Address {

	private String street;
	private String postCode;
	private String city;

	public Address(String street, String postCode, String city) {
		this.street = street;
		this.postCode = postCode;
		this.city = city;
	}
	
	public Address() {};

	public String getStreet() {
		return street;
	}

	public String getPostCode() {
		return postCode;
	}

	public String getCity() {
		return city;
	}

}
