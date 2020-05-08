package LogisticCompany.App;

import java.util.stream.Stream;
import LogisticCompany.domain.Container;


public interface ContainerRepository {

	
	void addContainer(Container container );
	
	Stream<Container> getAllContainersStream();

	void clearContainerDatabase();
	
	Container getContainer(String cargo);

	void updateContainer(Container container);
	

}
