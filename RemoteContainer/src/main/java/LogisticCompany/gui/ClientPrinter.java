package LogisticCompany.gui;

import LogisticCompany.domain.Address;
import LogisticCompany.info.ClientInfo;

public class ClientPrinter {
	
	private ClientInfo client;

	public ClientPrinter(ClientInfo client) {
		this.client = client;

	}

	public String printDetail() {
		StringBuffer b = new StringBuffer();
		b.append("<html> "+String.format("<b>Client name:</b>     %s<br>", client.getName()));
		b.append(String.format("<b>E-mail:</b>    %s<br>", client.getEmail()));
		b.append(String.format("<b>Address:</b>    %s<br>"," "));
		b.append(String.format("<b>City:</b>    %s<br>", client.getAddress().getCity()));
		b.append(String.format("<b>Street:</b>    %s<br>", client.getAddress().getStreet()));
		b.append(String.format("<b>Post code:</b>    %s<br>", client.getAddress().getPostCode()));
		b.append(String.format("<b>Reference person:</b>    %s<br>", client.getReference_person()));
		b.append(String.format("<b>Number of on going journeys:</b> %s<br></html>", client.getJourneys().size()));
		return b.toString();
	}
	
	public String print() {
			return client.getName() + ", "+client.getEmail();
	}

}
