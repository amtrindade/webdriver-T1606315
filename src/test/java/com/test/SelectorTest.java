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

public class SelectorTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");		
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void testXPathCheckBox() {		
		String name = "Fulano";
		WebElement chkBox = driver.findElement(By.xpath("//*[contains(text(),'"+ name +"')]/../td/input"));
		chkBox.click();
		
		assertTrue(chkBox.isSelected());	
	}
	
	@Test
	public void testNomeParaReserva() {
		String email = "antoniosilva@gmail.com";
		
		WebElement colunaNome = driver.findElement(By.xpath("//*[.='"+email+"']/../td[1]"));
		String name = colunaNome.getText();		
		WebElement tfReserva = driver.findElement(By.xpath("//input[@id='txt01']"));
		tfReserva.sendKeys(name);
		
		assertEquals("Antônio Silva", tfReserva.getAttribute("value"));
		
	}
	
	

}
