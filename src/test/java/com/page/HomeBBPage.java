package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;;

public class HomeBBPage {
	
	public String getUserLogged() {
		return getDriver().findElement(By.id("textName")).getText();
	}
	
	public TransferBBPage clickTransfer() {
		WebElement btnTransfer = getDriver().findElement(By.id("btn-TRANSFERÊNCIA"));
		btnTransfer.click();
		return new TransferBBPage();
	}

}
