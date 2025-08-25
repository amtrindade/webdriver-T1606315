package com.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalculatorTest {

	public WebDriver driver;

	@BeforeEach
	public void setUp() throws Exception {		
		System.setProperty("webdriver.geckodriver.driver", "/Users/umov.me/Dev/drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");			
	}

	@AfterEach
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testSoma() throws InterruptedException {
		
		WebElement tfNumber1 = driver.findElement(By.id("number1"));
		WebElement tfNumber2 = driver.findElement(By.id("number2"));
		WebElement tfTotal = driver.findElement(By.id("total"));
		WebElement btnSomar = driver.findElement(By.id("somar"));
		
		tfNumber1.sendKeys("8");
		tfNumber2.sendKeys("5");
		
		btnSomar.click();
		
		//TODO corrigir espera pelo texto do elemento
		Thread.sleep(3000);
		
		assertEquals("13", tfTotal.getAttribute("value"));		
	}
	
	@Test
	public void testSomaComConversao() throws InterruptedException {
		
		Random random = new Random();

        // Define o valor máximo (100). O valor mínimo é 1.
        int valorMaximo = 100;
        int valorMinimo = 1;
		
		Integer valor1 = random.nextInt(valorMaximo) + valorMinimo;
		Integer valor2 = random.nextInt(valorMaximo) + valorMinimo;
		
		WebElement tfNumber1 = driver.findElement(By.id("number1"));
		WebElement tfNumber2 = driver.findElement(By.id("number2"));
		WebElement tfTotal = driver.findElement(By.id("total"));
		WebElement btnSomar = driver.findElement(By.id("somar"));
		
		//Operação matemática de soma
		Integer valorTotal = valor1 + valor2;
		
		tfNumber1.sendKeys(valor1.toString());
		tfNumber2.sendKeys(valor2.toString());
		
		btnSomar.click();
		
		//TODO corrigir espera pelo texto do elemento
		Thread.sleep(3000);
		
		assertEquals(valorTotal.toString(), tfTotal.getAttribute("value"));			
		
	}
}
