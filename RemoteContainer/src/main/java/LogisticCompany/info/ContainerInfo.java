package LogisticCompany.info;

import java.util.ArrayList;
import java.util.List;

import LogisticCompany.domain.Container;
import LogisticCompany.domain.ContainerStatusEntry;

public class ContainerInfo {
	
	private String cargo;
	private List<ContainerStatusEntry> containerStatusList = new ArrayList<>();
	
	public ContainerInfo(String cargo) {
		this.cargo = cargo;
	}
	
	public ContainerInfo(Container container) {
		this.cargo = container.getCargo();
		this.containerStatusList = container.getContainerStatusList();
	}
	
	public String getCargo() {
		return cargo;
	}
	
	public Container asContainer() {
		return new Container(this);
	}
	
	public List<ContainerStatusEntry> getContainerStatusList() {
		return containerStatusList;
	}
	
}
