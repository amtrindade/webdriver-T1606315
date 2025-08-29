package com.test;

import static com.core.DriverFactory.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.core.BaseTest;

public class SelectorTest extends BaseTest{

	@BeforeEach
	public void setUp() throws Exception {				
		getDriver().get("https://antoniotrindade.com.br/treinoautomacao/localizandovalorestable.html");		
	}
	
	@Test
	public void testXPathCheckBox() {		
		String name = "Fulano";
		WebElement chkBox = getDriver().findElement(By.xpath("//*[contains(text(),'"+ name +"')]/../td/input"));
		chkBox.click();
		
		assertTrue(chkBox.isSelected());	
	}
	
	@Test
	public void testNomeParaReserva() {
		String email = "antoniosilva@gmail.com";
		
		WebElement colunaNome = getDriver().findElement(By.xpath("//*[.='"+email+"']/../td[1]"));
		String name = colunaNome.getText();		
		WebElement tfReserva = getDriver().findElement(By.xpath("//input[@id='txt01']"));
		tfReserva.sendKeys(name);
		
		assertEquals("Antônio Silva", tfReserva.getAttribute("value"));
		
	}
	
	

}
