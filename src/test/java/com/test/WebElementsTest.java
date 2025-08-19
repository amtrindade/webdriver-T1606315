package com.test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebElementsTest {
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {
//		System.setProperty("webdriver.chrome.driver", "/Users/umov.me/Dev/drivers/chromedriver");		
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/elementsweb.html");			
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(5000);
		driver.quit();
	}

	@Test
	public void testValidateTitle() {
		assertEquals("WebElements Test Page Lab", driver.getTitle());
	}
	
	@Test
	public void testEscreveHelloWorld() {
		//Passo 1) mapeia o elemento
		WebElement textFieldName = driver.findElement(By.name("txtbox1"));
		
		//Passo 2) Realiza a interação enviando um texto
		textFieldName.sendKeys("Hello world!");
		
		//Passo 3) Valida o resultado buscando o valor que está dentro do textfield
		assertEquals("Hello world!", textFieldName.getAttribute("value"));		
	}
	
	
}
