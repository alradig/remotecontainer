package LogisticCompany.App;

import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;


public interface ContainerRepository {
	void clearContainerDatabase();
	void addContainer(Container container );

	

}
