package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.BaseTest;

public class CalculatorTest extends BaseTest{

	public WebDriverWait wait;

	@BeforeEach
	public void setUp() throws Exception {		
							
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");	
		wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
	}
	
	@Test
	public void testSoma() throws InterruptedException {
		
		WebElement tfNumber1 = getDriver().findElement(By.id("number1"));
		WebElement tfNumber2 = getDriver().findElement(By.id("number2"));
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		WebElement btnSomar = getDriver().findElement(By.id("somar"));
		
		tfNumber1.sendKeys("8");
		tfNumber2.sendKeys("5");
		
		btnSomar.click();
		
		//espera explícita pelo texto exibido no textfield		
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfTotal, "13"));
		
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
		
		WebElement tfNumber1 = getDriver().findElement(By.id("number1"));
		WebElement tfNumber2 = getDriver().findElement(By.id("number2"));
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		WebElement btnSomar = getDriver().findElement(By.id("somar"));
		
		//Operação matemática de soma
		Integer valorTotal = valor1 + valor2;
		
		tfNumber1.sendKeys(valor1.toString());
		tfNumber2.sendKeys(valor2.toString());
		
		btnSomar.click();
		
		//espera explícita pelo texto exibido no textfield
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfTotal, valorTotal.toString()));
		
		assertEquals(valorTotal.toString(), tfTotal.getAttribute("value"));			
		
	}
}
