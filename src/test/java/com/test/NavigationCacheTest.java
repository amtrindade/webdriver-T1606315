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

public class NavigationCacheTest {
	
	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://antoniotrindade.com.br/treinoautomacao");		
	}

	@AfterEach
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void testNavigationCache() {
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement linkCalculadora = driver.findElement(By.linkText("Calculadora"));
		linkCalculadora.click();
		
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		
		WebElement linkLocalizarTable = driver.findElement(By.linkText("Localizar Table"));
		linkLocalizarTable.click();
		
		assertEquals("Trabalhando com tables", driver.getTitle());
		
		driver.navigate().back();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		driver.navigate().back();
		assertEquals("Treino Automação de Testes", driver.getTitle());
		driver.navigate().forward();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		driver.navigate().forward();
		assertEquals("Trabalhando com tables", driver.getTitle());
	}

}
