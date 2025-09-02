package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;;

public class MainBSPage {
	
	public Boolean isUserLogged() {
		WebElement divAvailable = getDriver().findElement(By.id("available"));
		return divAvailable.isDisplayed();		
	}
	
	public MainBSPage inputQuantityBook(String quantity, String bookDescription) {
		WebElement lineCoreJava = getDriver()
				.findElement(By.xpath("//td[contains(text(),'"+ bookDescription +"')]/..//input"));
		lineCoreJava.sendKeys(quantity);
		return this;	
	}
	
	public String getTotalValue() {
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		return tfTotal.getAttribute("value");
	}
	
	public MainBSPage addCart() {
		WebElement btnAdd = getDriver().findElement(By.xpath("//*[@value='Add']"));
		btnAdd.click();
		return this;
	}

}
