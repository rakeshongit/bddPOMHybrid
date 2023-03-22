package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {
	private WebDriver driver;
	
	private By contactUsLink = By.xpath("//a[text()=' Contact us']");
	private By name = By.cssSelector("input[name='name']");
	private By email = By.cssSelector("input[name='email']");
	private By subject = By.cssSelector("input[name='subject']");
	private By message = By.cssSelector("textarea#message");
	private By submit = By.cssSelector("input[name='submit']");
	private By successMessage = By.cssSelector("div.status.alert");
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickContactUsLink() {
		driver.findElement(contactUsLink).click();
	}
	
	public void inputName(String nameData) {
		driver.findElement(name).sendKeys(nameData);
	}
	
	public void inputEmail(String emailData) {
		driver.findElement(email).sendKeys(emailData);
	}
	
	public void inputSubject(String subjectData) {
		driver.findElement(subject).sendKeys(subjectData);
	}
	
	public void inputMessage(String messageData) {
		driver.findElement(message).sendKeys(messageData);
	}
	
	public void clickSubmit() {
		driver.findElement(submit).click();
	}
	
	public void fillContactUsForm(String name, String email, String subject, String message) {
		clickContactUsLink();
		inputName(name);
		inputEmail(email);
		inputSubject(subject);
		inputMessage(message);		
	}
	
	public String readSuccessMessage() {
		return driver.findElement(successMessage).getText();
	}
}
