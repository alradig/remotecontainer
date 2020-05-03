//package JUnit_tests;
//
//import CucumberSteps.ClientHelper;
//import CucumberSteps.JourneyHelper;
//import LogisticCompany.App.LogisticCompanyApp;
//import LogisticCompany.domain.Client;
//import LogisticCompany.domain.Journey;
//import LogisticCompany.persistence.SQLRepository;
//import io.cucumber.java.Before;
//
//public class testSQLRepository {
//	
//	LogisticCompanyApp logisticCompanyApp;
//	JourneyHelper journeyHelper;
//	ClientHelper clientHelper;
//	Client client;
//	Journey journey;
//
//	@Before
//	public void setUp() {
//		SQLRepository repository = new SQLRepository(false);
//		logisticCompanyApp = new LogisticCompanyApp(repository, repository, repository);
//		journeyHelper = new JourneyHelper(logisticCompanyApp);
//		clientHelper = new ClientHelper(logisticCompanyApp, journeyHelper);
//		setUpDatabase();
//	}
//	
//	protected void setUpDatabase() throws Exception {
//		client = clientHelper.registerExampleClient().asClient();
//		journey = journeyHelper.registerExampleJourney().asJourney();
//	}
//	
//	
//	
//}
