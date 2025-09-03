package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.HomeBBPage;
import com.page.LoginBBPage;
import com.page.RegisterBBPage;

import static org.junit.jupiter.api.Assertions.*;

public class LoginBBTest extends BaseTest{
	
	private LoginBBPage loginPage;
	private RegisterBBPage registerPage;
	private HomeBBPage homePage;
	
	String email = "test2@targettrust.com.br";
	String pass = "321";
	
	@BeforeEach
	public void setUp() {
		loginPage = new LoginBBPage();
		loginPage.open("https://bugbank.netlify.app/#");
		registerPage = loginPage.clickRegister();
		registerPage.inputEmail(email);
		registerPage.inputName("TargetTrust");
		registerPage.inputPassword(pass);
		registerPage.inputPasswordConfirmation(pass);
		registerPage.clickToggleSaldo();
		registerPage.clickCadastrar();
		loginPage = registerPage.clickClosed();
	}
	
	@Test
	public void testLoginSuccess() {
		
		loginPage.inputEmail(email);
		loginPage.inputPassword(pass);
		homePage = loginPage.clickAcessar();
		assertEquals("Olá TargetTrust,", homePage.getUserLogged());
	}

}
