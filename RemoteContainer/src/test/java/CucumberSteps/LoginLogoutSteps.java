package CucumberSteps;

import static org.junit.Assert.assertTrue;

import LogisticCompany.App.LogisticCompanyApp;
import LogisticCompany.persistence.InMemoryRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginLogoutSteps {
	
	private InMemoryRepository repository = new InMemoryRepository();
	private LogisticCompanyApp logisticCompanyApp = new LogisticCompanyApp(repository,repository,repository);

	@Given("the password is {string}")
	public void the_password_is(String string) {
		assertTrue(logisticCompanyApp.logisticCompanyLogin(string));
	}

	@Then("the company login succeeds")
	public void the_comapny_login_succeeds() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the company is logged in")
	public void the_company_is_logged_in() {
		assertTrue(logisticCompanyApp.logisticCompanyLoggedIn());
	}

	@Then("the company login fails")
	public void the_company_login_fails() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
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