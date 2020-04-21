import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.persistence.InMemoryRepository;
import LogisticCompany.persistence.SQLRepository;
import io.cucumber.java.Before;

public class InitiateDatabase {
	LogisticCompanyApp logisticCompanyApp;
	
	public InitiateDatabase(LogisticCompanyApp logisticCompanyApp) {
		this.logisticCompanyApp = logisticCompanyApp;
	}
	
	@Before
	public void connectDatabase() {
		SQLRepository repo = new SQLRepository();
//		InMemoryRepository repo = new InMemoryRepository();
		logisticCompanyApp.setRepositories(repo,repo,repo);
		logisticCompanyApp.clearDatabase();
		
	}
}
