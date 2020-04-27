package LogisticCompany.gui;

import java.util.List;

import LogisticCompany.App.CalenderDate;
import LogisticCompany.domain.ContainerStatusEntry;
import LogisticCompany.domain.JourneyStatusEntry;
import LogisticCompany.info.ContainerInfo;
import LogisticCompany.info.JourneyInfo;

public class JourneyPrinter {
	
	private JourneyInfo journey;
	private ContainerInfo container;
//	private CalenderDate calenderDate = new CalenderDate();
//	private String localTime;
	private String location;
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
		JourneyStatusEntry journeyStatus;
		
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
		
		if (journey.getCurrentJourneyStatus()== null) {
			location = "not registered";
//			journeyStatus = new JourneyStatusEntry(journey.getOriginPort(),journey.getDestinationPort(),"not registered");
//			localTime = "";
		}else { 
			location = journey.getCurrentJourneyStatus().getLocation();
//			localTime = calenderDate.getCurrentDate() + " at ";
		}
		
		String tab = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		
		b.append("<html>"+String.format("<b>The journey has cargo:</b>     %s<br>", journey.getCargo()));
		b.append(String.format("<b>The journey starts at:</b>    %s<br>", journey.getOriginPort()));
		b.append(String.format("<b>The current location:</b>    %s<br>", location));
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
