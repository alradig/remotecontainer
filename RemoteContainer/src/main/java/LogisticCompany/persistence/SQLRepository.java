package LogisticCompany.persistence;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import LogisticCompany.App.ClientRepository;
import LogisticCompany.App.ContainerRepository;
import LogisticCompany.App.JourneyRepository;
import LogisticCompany.domain.Client;
import LogisticCompany.domain.Container;
import LogisticCompany.domain.Journey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SQLRepository implements ClientRepository, ContainerRepository , JourneyRepository {

		EntityManagerFactory emf;
		EntityManager em;
		boolean isProduction = false;

		public SQLRepository() {
			this(false);
		}

		public SQLRepository(boolean isProduction) {
			this.isProduction = isProduction;
			Map<String, String> properties = new HashMap<String, String>();
			if (isProduction) {
				properties.put("javax.persistence.jdbc.url", "jdbc:sqlite:lib/db/production.db");
			} else {
				properties.put("javax.persistence.jdbc.url", "jdbc:sqlite:lib/db/test.db");
			}

			emf = Persistence.createEntityManagerFactory("RemoteContainerApp", properties);
			em = emf.createEntityManager();
		}

		@Override
		public void addClient(Client client) {
			em.getTransaction().begin();
			em.persist(client);
			em.getTransaction().commit();
		}
		
		@Override
		public void addContainer(Container container) {
			em.getTransaction().begin();
			em.persist(container);
			em.getTransaction().commit();
		}

		@Override
		public Client getClient(String email) {
			return em.createQuery("SELECT c FROM Client c WHERE c.email=:email", Client.class)
			  .setParameter("email", email)
			  .getResultStream().findFirst().orElse(null);
		}
		
		@Override
		public Container getContainer(String cargo) {		
			return em.createQuery("SELECT c FROM Container c WHERE c.cargo=:cargo", Container.class)
					  .setParameter("cargo", cargo)
					  .getResultStream().findFirst().orElse(null);
		}
		
		@Override
		public Journey getJourney(String cargo) {
			return em.createQuery("SELECT j FROM Journey j WHERE j.cargo=:cargo", Journey.class)
					  .setParameter("cargo", cargo)
					  .getResultStream().findFirst().orElse(null);
		}
		
		@Override
		public Stream<Client> getAllClientsStream() {
			return em.createQuery("SELECT c FROM Client c", Client.class).getResultStream();
		}

		@Override
		public void addJourney(Journey journey) {
			em.getTransaction().begin();
			em.persist(journey);
			em.getTransaction().commit();
			
		}

		@Override
		public Stream<Journey> getAllJourneysStream() {
			return em.createQuery("SELECT j FROM Journey j", Journey.class).getResultStream();
		}

		@Override
		public void updateJourney(Journey journey) {
			em.getTransaction().begin();
			em.merge(journey);
			em.getTransaction().commit();
		}
		
		@Override
		public void updateClient(Client client) {
			em.getTransaction().begin();
			em.merge(client);
			em.getTransaction().commit();
		}
		
		@Override
		public void updateContainer(Container container) {
			em.getTransaction().begin();
			em.merge(container);
			em.getTransaction().commit();
		}

		@Override
		public void removeJourney(Journey journey) {
			// TODO Auto-generated method stub

		}
		
		@Override
		public void removeContainer(Container container) {
			// TODO Auto-generated method stub
		
		}
		
		@Override
		public void removeClient(Client client) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean contains(Container container) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Client client) {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public boolean contains(Journey journey) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Stream<Container> getAllContainersStream() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void clearJourneyDatabase() {
			if (isProduction) {
				throw new Error("clearDatabase should not be called with a production database");
			}
			em.getTransaction().begin();
			em.createNativeQuery("DELETE FROM Journey").executeUpdate();
			em.createQuery("DELETE FROM Journey").executeUpdate();
			em.getTransaction().commit();
		}
		
		@Override
		public void clearContainerDatabase() {
			if (isProduction) {
				throw new Error("clearDatabase should not be called with a production database");
			}
			em.getTransaction().begin();
			em.createNativeQuery("DELETE FROM Container").executeUpdate();
			em.createQuery("DELETE FROM Container").executeUpdate();
			em.getTransaction().commit();
		}
		
		@Override
		public void clearClientDatabase() {
			if (isProduction) {
				throw new Error("clearDatabase should not be called with a production database");
			}
			em.getTransaction().begin();
			em.createNativeQuery("DELETE FROM Client").executeUpdate();
			em.createQuery("DELETE FROM Client").executeUpdate();
			em.getTransaction().commit();
		}
		
}
