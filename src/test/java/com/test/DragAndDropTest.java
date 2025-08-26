package com.test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");		
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void testDragAndDrop() throws Exception {
		
		WebElement divOrigin = driver.findElement(By.id("draggable"));
		assertEquals("Drag me to my target", divOrigin.getText());

		WebElement divDestiny = driver.findElement(By.id("droppable"));
		assertEquals("Drop here", divDestiny.getText());
		
		new Actions(driver).dragAndDrop(divOrigin, divDestiny).perform();
		
		assertEquals("Dropped!", divDestiny.getText());		
		
		Thread.sleep(3000);
		new Actions(driver).dragAndDropBy(divOrigin, 200, 20).perform();
	}

}
