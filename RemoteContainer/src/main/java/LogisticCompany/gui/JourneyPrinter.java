package LogisticCompany.gui;

import LogisticCompany.info.JourneyInfo;

public class JourneyPrinter {
	
	private JourneyInfo journey;

	public JourneyPrinter(JourneyInfo journey) {
		this.journey = journey;
	}

	public String printDetail() {
		StringBuffer b = new StringBuffer();
		b.append("<html>"+String.format("<b>The journey has cargo:</b>     %s<br>", journey.getCargo()));
		b.append(String.format("<b>The journey starts at:</b>    %s<br>", journey.getOriginPort()));
		b.append(String.format("<b>The journey ends at:</b>   %s<br></html>" , journey.getDestinationPort()));
		return b.toString();
	}
	
	public String print() {
		return "Journey from " + journey.getOriginPort() + " to " +journey.getDestinationPort();
	}

}
