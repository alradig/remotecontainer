package LogisticCompany.App;

import java.util.stream.Stream;
import LogisticCompany.domain.Container;


public interface ContainerRepository {
	
	
	boolean contains(Container container );
	
	void addContainer(Container container );
	
	Stream<Container> getAllContainersStream();
	
	void updateContainer(Container container );

	void removeContainer(Container container );

	void clearContainerDatabase();
	
	Container getContainer(String cargo);
	

}
