package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationTabsTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void testNavigationTabs() throws InterruptedException {
		
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement linkDragAndDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		WebElement linkJQuery = driver.findElement(By.linkText("Drag and Drop JQuery"));
		linkJQuery.click();
		
		//Criei array com as janelas que estão abertas		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		//Navegação pelas tabs
		driver.switchTo().window(tabs.get(1));
		
		Thread.sleep(5000);
		assertEquals("jQuery UI Droppable - Default functionality", driver.getTitle());
		
		driver.switchTo().window(tabs.get(2));		
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());
		
		driver.switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		
	}

}
