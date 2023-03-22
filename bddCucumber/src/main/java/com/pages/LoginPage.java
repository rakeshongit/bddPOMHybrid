package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;
	
	//1. By Locators
	private By loginSignUpLink = By.xpath("//a[text()=' Signup / Login']");
	private By emailId = By.name("email");
	private By password = By.name("password");
	private By login = By.xpath("//button[text()='Login']");
	private By invalidLoginMessage = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");
	
	//2. Constructor of the LoginPage class
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3. Page actions: features/ behavior
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean loginSignUpLinkExists() {
		return driver.findElement(loginSignUpLink).isDisplayed();
	}
	
	public void clickloginSignUpLink() {
		driver.findElement(loginSignUpLink).click();
	}
	
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}
	
	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	public String getInvalidLoginMessage() {
		return driver.findElement(invalidLoginMessage).getText();
	}
	
	public ShoppingCartPage doLogin(String username, String pwd) {
		clickloginSignUpLink();
		enterUserName(username);
		enterPassword(pwd);
		clickLogin();
		return new ShoppingCartPage(driver);
	}
}
