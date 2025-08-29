package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.core.BaseTest;

public class DragAndDropTest extends BaseTest {
	

	@BeforeEach
	public void setUp() throws Exception {				
		getDriver().get("https://jqueryui.com/resources/demos/droppable/default.html");		
	}
	
	@Test
	public void testDragAndDrop() throws Exception {
		
		WebElement divOrigin = getDriver().findElement(By.id("draggable"));
		assertEquals("Drag me to my target", divOrigin.getText());

		WebElement divDestiny = getDriver().findElement(By.id("droppable"));
		assertEquals("Drop here", divDestiny.getText());
		
		new Actions(getDriver()).dragAndDrop(divOrigin, divDestiny).perform();
		
		assertEquals("Dropped!", divDestiny.getText());		
		
		Thread.sleep(3000);
		new Actions(getDriver()).dragAndDropBy(divOrigin, 200, 20).perform();
	}

}
