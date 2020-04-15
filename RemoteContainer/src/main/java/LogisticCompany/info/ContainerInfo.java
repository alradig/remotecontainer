package LogisticCompany.info;

import LogisticCompany.domain.Container;

public class ContainerInfo {
	private String cargo;

	public ContainerInfo(String cargo) {
		this.cargo = cargo;
	}
	
	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	public Container asContainer() {
		// missing things to register container with .. Ask group ! ? 
		return new Container();
	}
	


	
	
	
	
}
