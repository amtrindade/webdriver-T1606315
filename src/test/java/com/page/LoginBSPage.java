package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginBSPage {
	
	public LoginBSPage open(String url) {		
		getDriver().get(url);		
		return this;
	}
	
	public LoginBSPage inputUser(String userName) {
		WebElement tfUser = getDriver().findElement(By.name("user"));
		tfUser.sendKeys(userName);
		return this;
	}
	
	public LoginBSPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.name("password"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public LoginBSPage clickLogarInvalid() {
		WebElement btnLogar = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogar.click();
		return this;
	}

	public String getMessageError() {
		WebElement divError = getDriver().findElement(By.id("errorMessage"));
		return divError.getText();
	}
	
	public MainBSPage clickLogarValid() {
		WebElement btnLogar = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogar.click();
		return new MainBSPage();
	}

}
