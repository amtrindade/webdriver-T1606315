package com.test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


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
		Thread.sleep(3000);
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
	
	@Test
	public void testSelectSingle() throws InterruptedException {
		
		WebElement dropDownList = driver.findElement(By.name("dropdownlist"));	
		Select selectSingle = new Select(dropDownList);
		
		selectSingle.selectByVisibleText("Item 5");		
		selectSingle.selectByVisibleText("Item 6");		
		selectSingle.selectByVisibleText("Item 7");
		
		assertEquals("Item 7", selectSingle.getFirstSelectedOption().getText());
		
	}
	
	@Test
	public void testSelectMulti() {
		WebElement dropDownMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selectMulti = new Select(dropDownMulti);
		
		selectMulti.selectByValue("item1");
		
		selectMulti.selectByValue("item5");
		selectMulti.selectByValue("item8");
		selectMulti.selectByValue("item9");
						
		selectMulti.deselectByIndex(0);

		List<WebElement> listSelect = selectMulti.getAllSelectedOptions();
		
		assertEquals(3, listSelect.size());
		
		assertEquals("Item 5", listSelect.get(0).getText());
		assertEquals("Item 8", listSelect.get(1).getText());
		assertEquals("Item 9", listSelect.get(2).getText());
		
		selectMulti.deselectAll();
		
		listSelect = selectMulti.getAllSelectedOptions();
		assertEquals(0, listSelect.size());
	}
	
	@Test
	public void testIFrame() {
		
		//Entra no iframe
		driver.switchTo().frame(0);
		
		WebElement tfIframe = driver.findElement(By.id("tfiframe"));
		tfIframe.sendKeys("Curso WebDriver");
		assertEquals("Curso WebDriver", tfIframe.getAttribute("value"));
		
		//Sai do iframe
		driver.switchTo().defaultContent();
	}
	
	@Test
	public void testAlert() throws InterruptedException {
		
		WebElement btnAlert = driver.findElement(By.name("alertbtn"));
		btnAlert.click();
		
		Alert alert = driver.switchTo().alert();
		assertEquals("Eu sou um alerta!", alert.getText());
		
		alert.accept();
		
	}
	
	@Test
	public void testConfirm() {
		WebElement btnConfirm = driver.findElement(By.name("confirmbtn"));
		btnConfirm.click();
		
		Alert confirm = driver.switchTo().alert();
		assertEquals("Pressione um botão!", confirm.getText());
		confirm.dismiss();
		
		btnConfirm.click();
		confirm = driver.switchTo().alert();
		assertEquals("Pressione um botão!", confirm.getText());
		confirm.accept();
		
	}
	
	@Test
	public void testPrompt() {
		WebElement btnPrompt = driver.findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Alert prompt1 = driver.switchTo().alert();
		prompt1.sendKeys("2025");
		prompt1.accept();
		
		Alert prompt2 = driver.switchTo().alert();
		assertEquals("O ano é 2025?", prompt2.getText());
		prompt2.accept();
		
		Alert prompt3 = driver.switchTo().alert();
		assertEquals("Feito!", prompt3.getText());
		prompt3.accept();
		
	}
	
	@Test
	public void testPromptDismiss() {
		WebElement btnPrompt = driver.findElement(By.id("promptBtn"));
		btnPrompt.click();
		
		Alert prompt1 = driver.switchTo().alert();
		prompt1.sendKeys("2025");
		prompt1.accept();
		
		Alert prompt2 = driver.switchTo().alert();
		assertEquals("O ano é 2025?", prompt2.getText());
		prompt2.dismiss();
		
		Alert prompt3 = driver.switchTo().alert();
		assertEquals("Nada feito!", prompt3.getText());
		prompt3.dismiss();
		
	}
	
	
	
		
}
