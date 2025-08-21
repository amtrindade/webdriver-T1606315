package com.test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

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
		assertEquals("Hello world!", textFieldName.getAttribute("value"), "O texto está diferente!");		
	}
	
	@Test
	public void testEnableDisableTextField() {
		
		WebElement txtBox1 = driver.findElement(By.name("txtbox1"));
		WebElement txtBox2 = driver.findElement(By.name("txtbox2"));
		
		txtBox1.sendKeys("Antonio");
		
		assertTrue(txtBox1.isEnabled());
		assertFalse(txtBox2.isEnabled());
	}
	
	@Test
	public void testRadioButton() {
		List<WebElement> listRadio = driver.findElements(By.name("radioGroup1"));
		
		assertEquals(4, listRadio.size());
		
		for (WebElement element : listRadio) {
			if (element.getAttribute("value").equals("Radio 3")) {
				element.click();
			}
		}
		
		assertTrue(listRadio.get(2).isSelected());
		assertFalse(listRadio.get(0).isSelected());
		assertFalse(listRadio.get(1).isSelected());
		assertFalse(listRadio.get(3).isSelected());
	}
	
	@Test
	public void testCheckBoxes() {
		
		List<WebElement> listCheck = driver.findElements(By.name("chkbox"));
		
		assertEquals(4, listCheck.size());
		
		for (WebElement checkBox : listCheck) {
			if ((checkBox.getAttribute("value").equals("Check 3"))
					|| (checkBox.getAttribute("value").equals("Check 4"))) {
				checkBox.click();
			}			
		}
		
//		listCheck.get(2).click();
//		listCheck.get(3).click();
		
		assertTrue(listCheck.get(2).isSelected(), "O check 3 não foi validado!");
		assertTrue(listCheck.get(3).isSelected(), "O check 4 não foi validado!");
		assertFalse(listCheck.get(0).isSelected());
		assertFalse(listCheck.get(1).isSelected());	
	}
		
}
