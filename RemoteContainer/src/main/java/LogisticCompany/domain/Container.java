package LogisticCompany.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import javax.persistence.*;

import LogisticCompany.info.ContainerInfo;


@Entity
public class Container {
	@Id
    @GeneratedValue
	private long id;
	private String cargo;
	@OneToMany
	private List<ContainerStatusEntry> containerStatusList = new ArrayList<>();
	
	public Stream<ContainerStatusEntry> getContainerStatusListStream() {
		return containerStatusList.stream();
	}

	public Container() {
	}

	public Container(ContainerInfo containerInfo) {
		this.cargo = containerInfo.getCargo();
	}
	
	public List<ContainerStatusEntry> getContainerStatusList() {
		return containerStatusList;
	}
	
	public void clearContainerStatusList() {
		containerStatusList.clear();
	}
	
	public void updateContainerStatus(ContainerStatusEntry containerStatus) {
		containerStatusList.add(containerStatus);
	}
	
	public long getId() {
		return id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public ContainerInfo asContainerInfo() {
		return new ContainerInfo(this, this.containerStatusList);
	}

	public boolean matchContainer(String searchCargo) {
		return cargo.contains(searchCargo);
	}

	public void updateContainerInfo(ContainerInfo containerInfo) {
		this.cargo = containerInfo.getCargo();
//		this.containerStatusList = containerInfo.getContainerStatusList();
	}
	
}
