package com.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
				
			System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
			driver = new FirefoxDriver();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		}
				
		return driver;
	}
	
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
