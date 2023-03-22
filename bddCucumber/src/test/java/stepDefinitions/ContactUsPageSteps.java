package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.pages.ContactUsPage;
import com.qa.factory.DriverFactory;
import com.qa.util.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsPageSteps {
	private ContactUsPage contactUsPage = new ContactUsPage(DriverFactory.getDriver());
	
	@Given("user navigates to contact us page")
	public void user_navigates_to_contact_us_page() {
		DriverFactory.getDriver().get("https://automationexercise.com/");
		contactUsPage.clickContactUsLink();	    
	}

	@When("user fills the form from given sheetname {string} and rownumber {int}")
	public void user_fills_the_form_from_given_sheetname_and_rownumber(String sheetName, Integer rowNumber) throws InvalidFormatException, IOException {
	    ExcelReader reader = new ExcelReader();
	    List<Map<String, String>> testData =
	    		reader.getData("src/test/resources/dataLoaders/excelDataBook.xlsx", sheetName);
		String name = testData.get(rowNumber).get("Name");
		String email = testData.get(rowNumber).get("Email");
		String subject = testData.get(rowNumber).get("Subject");
		String message = testData.get(rowNumber).get("Message");
		contactUsPage.fillContactUsForm(name, email, subject, message);	    
	}

	@When("user clicks on submit button")
	public void user_clicks_on_submit_button() {
		contactUsPage.clickSubmit();
		DriverFactory.getDriver().switchTo().alert().accept();	    
	}

	@Then("it shows a successful message {string}")
	public void it_shows_a_successful_message(String string) {
	    Assert.assertEquals(contactUsPage.readSuccessMessage(), string);	    
	}
}
