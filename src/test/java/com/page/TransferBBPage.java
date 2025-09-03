package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;

public class TransferBBPage {
	
	public TransferBBPage inputAccountNumber(String account) {
		WebElement tfAccount = getDriver().findElement(By.name("accountNumber"));
		tfAccount.sendKeys(account);
		return this;
	}
	
	public TransferBBPage inputDigit(String digit) {
		WebElement tfDigit = getDriver().findElement(By.name("digit"));
		tfDigit.sendKeys(digit);
		return this;
	}
	

}
