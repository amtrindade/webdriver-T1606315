package com.core;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
	public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		//"chrome/firefox"
		String browser = GlobalProperty.getProperty("webdriver.browser");
		
		if (driver == null) {
			
			if (browser.equals("firefox")) {
				
				System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
				driver = new FirefoxDriver();
			}
			else if (browser.equals("chrome")) {
				System.setProperty("webdriver.chromedriver.driver", "/Users/umov.me/Dev/drivers/chromedriver");
				driver = new ChromeDriver();
			}
			else {
				System.out.println("O driver não foi definido!");
			}
			
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
