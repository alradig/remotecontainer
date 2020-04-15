import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.Before;

public class InitiateDatabase {
	LogisticCompanyApp logisticCompanyApp;
	
	public InitiateDatabase(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
	}
	
	@Before
	public void connectDatabase() {
//		SqliteRepository repo = new SqliteRepository();
		InMemoryRepository repo = new InMemoryRepository();
		logisticCompanyApp.setRepositories(repo,repo,repo);
		logisticCompanyApp.clearDatabase();
		
	}
}
