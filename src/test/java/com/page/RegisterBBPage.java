package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;;

public class RegisterBBPage {
	
	public RegisterBBPage inputEmail(String email) {
		WebElement tfEmail = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='email']"));
		tfEmail.sendKeys(email);
		return this;
	}
	
	public RegisterBBPage inputName(String name) {
		WebElement tfName = getDriver().findElement(By.name("name"));
		tfName.sendKeys(name);		
		return this;
	}
	
	public RegisterBBPage inputPassword(String pass) {
		WebElement tfPassword = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='password']"));
		tfPassword.sendKeys(pass);		
		return this;
	}
	
	public RegisterBBPage inputPasswordConfirmation(String pass) {
		WebElement tfPassConfirmation = getDriver().findElement(By.name("passwordConfirmation"));
		tfPassConfirmation.sendKeys(pass);		
		return this;
	}
	
	public RegisterBBPage clickToggleSaldo() {
		WebElement toggleSaldo = getDriver().findElement(By.id("toggleAddBalance"));
		toggleSaldo.click();
		return this;
	}
	
	public RegisterBBPage clickCadastrar() {
		WebElement btnCadastrar = getDriver().findElement(By.xpath("//button[.='Cadastrar'] "));
		btnCadastrar.click();
		return this;
	}
	
	public Boolean getPartialMessage(String partialMessage) {
		String message = getDriver().findElement(By.id("modalText")).getText();
		return partialMessage.contains(message);
	}

}
