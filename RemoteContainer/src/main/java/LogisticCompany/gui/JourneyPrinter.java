package LogisticCompany.gui;

import java.util.List;

import LogisticCompany.domain.ContainerStatusEntry;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;

public class JourneyPrinter {
	
	private JourneyInfo journey;
	private ContainerInfo container;

	public JourneyPrinter(JourneyInfo journey) {
		this.journey = journey;
	}
	
	public JourneyPrinter(JourneyInfo journey, ContainerInfo container) {
		this.journey = journey;
		this.container = container;
	}

	public String printDetail() {
		StringBuffer b = new StringBuffer();
		List<ContainerStatusEntry> containerStatusList;
		ContainerStatusEntry containerStatus;
		
		
		if(container == null) {
			containerStatusList = journey.getContainerInfo().getContainerStatusList();
		}else {
			containerStatusList = container.getContainerStatusList();
		}
		
		if(containerStatusList.isEmpty()) {
			containerStatus = new ContainerStatusEntry("not registered","not registered","not registered");
		}else {
			containerStatus = containerStatusList.get(containerStatusList.size()-1);
		}
		
		String tab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		
		b.append("<html>"+String.format("<b>The journey has cargo:</b>     %s<br>", journey.getCargo()));
		b.append(String.format("<b>The journey starts at:</b>    %s<br>", journey.getOriginPort()));
		b.append(String.format("<b>The current location:</b>    %s<br>", journey.getLocation()));
		b.append(String.format("<b>The journey ends at:</b>   %s<br>" , journey.getDestinationPort()));
		
		b.append(String.format("<b>Container status:</b><br>"));
		b.append(String.format("<b>%slatest temperature:</b>   %s<br>" ,tab , containerStatus.getTemperature()));
		b.append(String.format("<b>%slatest humidity:</b>   %s<br>" ,tab , containerStatus.getAirHumidity()));
		b.append(String.format("<b>%slatest atm pressure:</b>   %s<br></html>" ,tab , containerStatus.getAtmPressure()));
		
		return b.toString();
	}
	
	public String print() {
		return "Journey from " + journey.getOriginPort() + " to " +journey.getDestinationPort();
	}

}
