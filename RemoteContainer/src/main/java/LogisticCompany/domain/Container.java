package LogisticCompany.domain;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.*;

import LogisticCompany.info.ContainerInfo;


@Entity
public class Container {
	private static final AtomicInteger count = new AtomicInteger(0); 
	@Id
	private final int id;
	private String cargo;
	@OneToMany
	private ArrayList<ContainerStatus> containerStatusList = new ArrayList<>();
	
	public Container() {
		this.id = count.incrementAndGet(); 
	}

	public Container(String cargo) {
		this.cargo = cargo;
		this.id = count.incrementAndGet();
	}
	
	public void addContainerStatus(ContainerStatus containerStatus) {
		containerStatusList.add(containerStatus);
	}
	
	public void clearContainerStatusList() {
		containerStatusList.clear();
	}
	
	public void addToMeasurementList(String currentTemp, String currentAirHum, String currentAtmPre) {
		ContainerStatus containerStatus = new ContainerStatus(currentTemp,currentAirHum,currentAtmPre);
		containerStatusList.add(containerStatus);
		
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
