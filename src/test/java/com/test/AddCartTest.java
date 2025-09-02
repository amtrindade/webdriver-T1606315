package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.core.BaseTest;
import com.page.LoginBSPage;
import com.page.MainBSPage;

public class AddCartTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private MainBSPage mainPage;
	
	@BeforeEach
	public void setUp() {
		loginPage = new LoginBSPage();		
		loginPage.open("http://sahitest.com/demo/training/login.htm");
		
		loginPage.inputUser("test");
		loginPage.inputPassword("secret");
		mainPage = loginPage.clickLogarValid();
	}
	
	@Test
	public void testAddProductsToCart() {
		
		mainPage.inputQuantityBook("2", "Core Java");
		mainPage.inputQuantityBook("3", "Ruby for Rails");
		mainPage.inputQuantityBook("4", "Python Cookbook");
		mainPage.addCart();
		
		assertEquals("2600", mainPage.getTotalValue());
		
	}
	

}
