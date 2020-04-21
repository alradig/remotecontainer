package CucumberSteps;

import static org.junit.Assert.assertFalse;
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
	
	@Given("that a client is logged in")
	public void that_a_client_is_logged_in() throws Exception {
		logisticCompanyApp.logisticCompanyLogin("logisticCompany123");
		
		clientInfo = helper.getClient();
		
		try {
			logisticCompanyApp.registerClient(clientInfo);
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}

		logisticCompanyApp.logisticCompanyLogout();
		logisticCompanyApp.clientLogin("client123");
		
		try {
			logisticCompanyApp.checkClientLoggedIn();
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}
	}

	@Then("a client is logged in")
	public void a_client_is_logged_in() throws Exception {
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
	
	@Given("that a client logs out")
	public void that_a_client_logs_out() throws Exception {
		logisticCompanyApp.clientLogout();
	}

	@Given("that a client is not logged in")
	public void that_a_client_is_not_logged_in() throws Exception {
		try {
			logisticCompanyApp.checkClientLoggedIn();
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}
		assertFalse(logisticCompanyApp.clientLoggedIn());
	}

	@Then("a client login succeeds")
	public void a_client_login_succeeds() throws Exception {
		assertTrue(logisticCompanyApp.clientLogin(password));
	}

	@Then("a client login fails")
	public void a_client_login_fails() throws Exception {
		assertFalse(logisticCompanyApp.clientLogin(password));
	}

	@Then("a client is not logged in")
	public void a_client_is_not_logged_in() throws Exception {
		assertFalse(logisticCompanyApp.clientLoggedIn());
	}

	@When("a client logs out")
	public void a_client_logs_out() throws Exception {
		logisticCompanyApp.clientLogout();
	}

	@Given("the password is {string}")
	public void the_password_is(String password) throws Exception {
		this.password = password;
	}

	@Then("the logistic company login succeeds")
	public void the_logistic_company_login_succeeds() {
		assertTrue(logisticCompanyApp.logisticCompanyLogin(password));
	}

	@Then("the logistic company is logged in")
	public void the_logistic_company_is_logged_in() throws Exception {
		assertTrue(logisticCompanyApp.logisticCompanyLoggedIn());
	}
	
	@Given("that the logistic company is logged in")
	public void that_the_logistic_company_is_logged_in() throws Exception  {
		try {
			logisticCompanyApp.checkLogisticCompanyLoggedIn();
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}
		assertTrue(logisticCompanyApp.logisticCompanyLogin("logisticCompany123"));
	}

	@Given("that the logistic company is not logged in")
	public void that_the_logistic_company_is_not_logged_in() throws Exception  {
		try {
			logisticCompanyApp.checkLogisticCompanyLoggedIn();
		} catch (OperationNotAllowedException e) {
			this.errorMessage = e.getMessage();
		}
		assertFalse(logisticCompanyApp.logisticCompanyLoggedIn());
	}
	
	@Then("the logistic company login fails")
	public void the_logistic_company_login_fails() throws Exception {
		assertFalse(logisticCompanyApp.logisticCompanyLogin(password));
	}
	
	@Given("the logistic company logs out")
	public void the_logistic_company_logs_out() throws Exception {
		logisticCompanyApp.logisticCompanyLogout();
	}

	@Then("the logistic company is not logged in")
	public void the_logistic_company_is_not_logged_in() throws Exception {
		assertFalse(logisticCompanyApp.logisticCompanyLoggedIn());
	}

	
}