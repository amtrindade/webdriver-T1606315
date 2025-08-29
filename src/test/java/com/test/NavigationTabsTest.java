package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class NavigationTabsTest extends BaseTest{
	
	@BeforeEach
	public void setUp() throws Exception {		
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao");		
	}

	@Test
	public void testNavigationTabs() throws InterruptedException {
		
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement linkDragAndDrop = getDriver().findElement(By.linkText("Drag and Drop"));
		linkDragAndDrop.click();
		
		WebElement linkJQuery = getDriver().findElement(By.linkText("Drag and Drop JQuery"));
		linkJQuery.click();
		
		//Criei array com as janelas que estão abertas		
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		//Navegação pelas tabs
		getDriver().switchTo().window(tabs.get(1));
		
		Thread.sleep(5000);
		assertEquals("jQuery UI Droppable - Default functionality", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(2));		
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());	
	}

}
