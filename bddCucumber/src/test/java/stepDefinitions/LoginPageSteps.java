package stepDefinitions;

import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private static String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("I am on login page")
	public void i_am_on_login_page() {
	    DriverFactory.getDriver().get("https://automationexercise.com/");
	}

	@When("I get the title of page")
	public void i_get_the_title_of_page() {
		title = loginPage.getLoginPageTitle();
	}

	@Then("I see the title as {string}")
	public void i_see_the_title_as(String expectedTitle) {
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Then("I see the Login or SignUp Link")
	public void i_see_the_login_or_sign_up_link() {
	    Assert.assertTrue(loginPage.loginSignUpLinkExists());
	}
	
	@Given("I click on Login or SignUp Link")
	public void i_click_on_login_or_sign_up_link() {
	    loginPage.clickloginSignUpLink();
	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String string) {
	   loginPage.enterUserName(string);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String string) {
		loginPage.enterPassword(string);
	}

	@When("I click on Login button")
	public void i_click_on_login_button() {
		loginPage.clickLogin();
	}

	@Then("I see message {string}")
	public void i_see_message(String string) {
		Assert.assertEquals(loginPage.getInvalidLoginMessage(),string);
	}

}
