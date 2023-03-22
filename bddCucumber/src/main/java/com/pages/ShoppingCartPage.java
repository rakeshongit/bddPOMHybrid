package com.pages;

import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage {
	private WebDriver driver;
	
	private By cartLink = By.xpath("//a[text()=' Cart']");
	
	private By cartSection = By.cssSelector("tr.cart_menu td");
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCart() {
		driver.findElement(cartLink).click();
	}
	
	public int getCartColumnsCount() {
		return driver.findElements(cartSection).size()-1;
	}
	
	public List<String> getCartColumns() {
		List<String> columnsList = new ArrayList<>();
		List<WebElement> cartColumnsList = driver.findElements(cartSection);
		
		for(WebElement e: cartColumnsList) {
			String text = e.getText();
			if(!text.isBlank()) {
				columnsList.add(text);
			}
		}
		return columnsList;
	}
}
