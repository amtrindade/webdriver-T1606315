package com.page;

import static com.core.DriverFactory.getDriver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;;

public class RegisterBBPage {
	
	public RegisterBBPage inputEmail(String email) {
		WebElement tfEmail = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='email']"));
		tfEmail.clear();
		tfEmail.sendKeys(email);
		return this;
	}
	
	public RegisterBBPage inputName(String name) {
		WebElement tfName = getDriver().findElement(By.name("name"));
		tfName.clear();
		tfName.sendKeys(name);		
		return this;
	}
	
	public RegisterBBPage inputPassword(String pass) {
		WebElement tfPassword = getDriver().findElement(By.xpath("//div[@class='card__register']//input[@name='password']"));
		tfPassword.clear();
		tfPassword.sendKeys(pass);		
		return this;
	}
	
	public RegisterBBPage inputPasswordConfirmation(String pass) {
		WebElement tfPassConfirmation = getDriver().findElement(By.name("passwordConfirmation"));
		tfPassConfirmation.clear();
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
	
	public LoginBBPage clickClosed() {
		WebElement btnClose = getDriver().findElement(By.id("btnCloseModal"));
		btnClose.click();
		return new LoginBBPage();
	}
	
	public String getAccountNumber() {
		String message = getDriver().findElement(By.id("modalText")).getText();
		String accountNumber = extract(message);
		return accountNumber;
	}
	
	private String extract(String message) {
        Pattern pattern = Pattern.compile("\\b\\d+-\\w\\b");
        Matcher matcher = pattern.matcher(message);

        // Verifica se o padrão foi encontrado no texto
        if (matcher.find()) {
            // Retorna a primeira ocorrência encontrada
            return matcher.group(0);
        }

        // Retorna uma mensagem caso nenhum número de conta seja encontrado
        return "Número da conta não encontrado";
    }

}
