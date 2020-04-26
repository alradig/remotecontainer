package LogisticCompany.info;

import java.util.ArrayList;
import java.util.List;

import LogisticCompany.domain.Container;
import LogisticCompany.domain.ContainerStatusEntry;

public class ContainerInfo {
	
	private long id;
	private String cargo;
	private List<ContainerStatusEntry> containerStatusList = new ArrayList<>();
	
	public ContainerInfo(String cargo) {
		this.cargo = cargo;
		this.id = 0;
	}
	
	public ContainerInfo(Container container) {
		this.cargo = container.getCargo();
		this.containerStatusList = container.getContainerStatusList();
		this.id = container.getId();
	}
	
	public ContainerInfo(Container container, List<ContainerStatusEntry> containerStatusList) {
		this.cargo = container.getCargo();
		this.containerStatusList = containerStatusList;
		this.id = container.getId();
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
	
	public long getId() {
		return id;
	}
	
	public void addContainerStatus(ContainerStatusEntry newEntry) {
		containerStatusList.add(newEntry);
	}
	
}