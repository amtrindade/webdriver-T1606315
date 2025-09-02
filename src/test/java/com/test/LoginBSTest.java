package com.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.LoginBSPage;
import com.page.MainBSPage;

public class LoginBSTest extends BaseTest{
	
	private LoginBSPage loginPage;
	private MainBSPage mainPage;
	
	@Test
	public void testLoginInvalid() {
		
		loginPage = new LoginBSPage();		
		loginPage.open("http://sahitest.com/demo/training/login.htm");		
		loginPage.inputUser("test");
		loginPage.inputPassword("wrongpassword");
		loginPage.clickLogarInvalid();
		
		assertEquals("Invalid username or password", loginPage.getMessageError());
		
	}	

}
