package LogisticCompany.domain;
import java.util.concurrent.atomic.AtomicInteger;

import LogisticCompany.info.ContainerInfo;


public class Container {
	private static final AtomicInteger count = new AtomicInteger(0); 
	private final int id;
	private String cargo;
	private ContainerStatus containerStatus;
	
	
	public Container() {
		this.id = count.incrementAndGet(); 
	}

	public Container(String cargo) {
		this.cargo = cargo;
		this.id = count.incrementAndGet(); 
	}
	
	public void setContainerStatus(ContainerStatus containerStatus) {
		this.containerStatus = containerStatus;
	}
	public ContainerStatus getContainerStatus() {
		return containerStatus;
	}
	
	public int getId() {
		return id;
	}
		
	public static boolean containerRegistered(Container container) {
		return container.getId() == 0;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public ContainerInfo asContainerIfo() {
		return new ContainerInfo(this.getCargo());
	}
	
//	public void archive() {
//	String fileName = "Container_" + this.id + ".json";
//	String folderName = "Containers";
//	
//	Database JSONfile = new Database();
//	JSONfile.createFile(this,folderName, fileName);
//}

	
}
