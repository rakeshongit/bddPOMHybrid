package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	/**
	 * Initializes threadlocal driver
	 * @param browser
	 * @return WebDriver
	 */
	public WebDriver init_driver(String browser) {
		System.out.println("Got browser: "+browser);
		
		try {
			if(browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				tlDriver.set(new ChromeDriver(options));
			}
			
			getDriver().manage().deleteAllCookies();
			getDriver().manage().window().maximize();
			driver = getDriver();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed to set driver");
		}
		return driver;
	}
	/**
	 * Gets WebDriver instance with Threadlocal/Generic
	 * @return threadlocal WebDriver
	 */
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}
}
