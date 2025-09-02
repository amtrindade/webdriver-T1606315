package com.test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.core.BaseTest;
import com.page.LoginBBPage;
import com.page.RegisterBBPage;

public class RegisterBBTest extends BaseTest{
	
	private LoginBBPage loginPage;
	private RegisterBBPage registerPage;
	
	@Test
	public void testRegisterAccount() throws InterruptedException {
		
		loginPage = new LoginBBPage();
		loginPage.open("https://bugbank.netlify.app/#");
		registerPage = loginPage.clickRegister();
		registerPage.inputEmail("test1@targettrust.com.br");
		registerPage.inputName("TargetTrust");
		registerPage.inputPassword("123");
		registerPage.inputPasswordConfirmation("123");
		Thread.sleep(3000);
		registerPage.clickToggleSaldo();
		registerPage.clickCadastrar();
		
		assertTrue(registerPage.getPartialMessage("foi criada com sucesso"));
		
		//TODO: CLICAR FECHAR E LOGAR
		
	}

}
