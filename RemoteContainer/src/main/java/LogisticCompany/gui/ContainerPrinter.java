package LogisticCompany.gui;

import java.util.List;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.domain.ContainerStatusEntry;
import LogisticCompany.info.ContainerInfo;

public class ContainerPrinter {
	
	private ContainerInfo container;
	List<ContainerStatusEntry> containerStatusList;
	ContainerStatusEntry containerStatus;

	public ContainerPrinter(LogisticCompanyApp logisticCompanyApp) {
		this.container = logisticCompanyApp.getSelectedContainerInfo();
		
		if (!(container ==null)) {
			containerStatusList = container.getContainerStatusList();
			if(containerStatusList.isEmpty()) {
				containerStatus = new ContainerStatusEntry("not registered","not registered","not registered");
				containerStatusList.add(containerStatus);
			}
		}
		else {
			containerStatus = new ContainerStatusEntry("not registered","not registered","not registered");
			containerStatusList.add(containerStatus);
		}
	
	}

	public String printTemperatureDetail() {
		StringBuffer b = new StringBuffer();
		b.append("<html>"+String.format("<b></b>     %s<br>",""));
		for (int i=0; i<containerStatusList.size(); i++) {
	        b.append(String.format(containerStatusList.get(i).getTemperature()));
	    }		
		b.append(String.format("<b>%s</b>   %s<br></html>", ""));
		return b.toString();
	}
	
	
	public String printAirHumDetail() {
		StringBuffer b = new StringBuffer();
		b.append("<html>"+String.format("<b></b>     %s<br>",""));
		for (int i=0; i<containerStatusList.size(); i++) {
	        b.append(String.format(containerStatusList.get(i).getAirHumidity()));
	    }	
		b.append(String.format("<b>%s</b>   %s<br></html>", ""));
		return b.toString();
	}
	
	public String printPressureDetail() {
		StringBuffer b = new StringBuffer();
		b.append("<html>"+String.format("<b></b>     %s<br>",""));
		for (int i=0; i<containerStatusList.size(); i++) {
	        b.append(String.format(containerStatusList.get(i).getAtmPressure()));
	    }	
		b.append(String.format("<b>%s</b>   %s<br></html>", ""));

		return b.toString();
	}
	
}
