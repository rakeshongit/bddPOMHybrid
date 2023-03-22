package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.LoginPage;
import com.pages.ShoppingCartPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ShoppingCartPageSteps {
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	private ShoppingCartPage cartPage;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable credsTable) {
	    List<Map<String, String>> creds = credsTable.asMaps();	    
	    
	    DriverFactory.getDriver().get("https://automationexercise.com/");
	    cartPage = loginPage.doLogin(creds.get(0).get("username"), creds.get(0).get("password"));
	}

	@Given("I am on Shopping Cart page")
	public void i_am_on_shopping_cart_page() {
		cartPage.clickCart();
	}

	@Then("I get Shopping Cart page section")
	public void i_get_shopping_cart_page_section(DataTable cartColumnsTable) {
		List<String> expectedColumns = cartColumnsTable.asList();
		List<String> actualColumns = cartPage.getCartColumns();
		
		Assert.assertTrue(expectedColumns.containsAll(actualColumns));
	}

	@Then("Shopping Cart page section count should be {int}")
	public void shopping_cart_page_section_count_should_be(Integer int1) {
		Assert.assertTrue(cartPage.getCartColumnsCount() == int1);
	}
}
