package LogisticCompany.gui;

import LogisticCompany.info.ClientInfo;

public class ClientPrinter {
	
	private ClientInfo client;

	public ClientPrinter(ClientInfo client) {
		this.client = client;
	}

	public String printDetail() {
		StringBuffer b = new StringBuffer();
		b.append(String.format("<html>+<b>Client name:</b>     %s<br>", client.getName()));
		b.append(String.format("<b>E-mail:</b>    %s<br>", client.getEmail()));
		b.append(String.format("<b>Address:</b>    %s<br>", client.getAddress()));
		b.append(String.format("<b>Reference person:</b> %s<br></html>", client.getReference_person()));
		return b.toString();
	}
	
	public String print() {
			return client.getName() + ", "+client.getEmail();
	}

}
