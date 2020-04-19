package CucumberSteps;

import static org.junit.Assert.assertTrue;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.App.OperationNotAllowedException;
import LogisticCompany.domain.Address;
import LogisticCompany.info.ClientInfo;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import LogisticCompany.App.LogisticCompanyApp;

public class LoginLogoutSteps {
	
	private ClientInfo clientInfo;
	private String errorMessage;
	private InMemoryRepository repository = new InMemoryRepository();
	private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);
	public ClientHelper helper;
	private String password;
	
	public LoginLogoutSteps(LogisticCompanyApp logisticCompanyApp,ClientHelper helper) {
		this.logisticCompanyApp = logisticCompanyApp;
		this.helper = helper;
	}
	
	@Given("a client is logged in")
	public void a_client_is_logged_in() {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		
		clientInfo = helper.getClient();
		
		try {
			logisticCompanyApp.registerClient(clientInfo);
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}

		logisticCompanyApp.logisticCompanyLogout();
		
		logisticCompanyApp.clientLogin("client123");
	}
	
	@Given("the password is {string}")
	public void the_password_is(String string) {
		this.password = string;
	}

	@Then("the company login succeeds")
	public void the_comapny_login_succeeds() {
		assertTrue(logisticCompanyApp.logisticCompanyLogin(password));
	}

	@Then("the company is logged in")
	public void the_company_is_logged_in() {
		assertTrue(logisticCompanyApp.logisticCompanyLoggedIn());
	}

	@Then("the company login fails")
	public void the_company_login_fails() {
		assertTrue(!logisticCompanyApp.logisticCompanyLogin(password));
	}

	@When("the company logs out")
	public void the_company_logs_out() {
		logisticCompanyApp.logisticCompanyLogout();
	}

	@Then("the company is not logged in")
	public void the_company_is_not_logged_in() {
		assertTrue(!logisticCompanyApp.logisticCompanyLoggedIn());
	}
	
}