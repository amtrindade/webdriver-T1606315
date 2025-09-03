package com.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.core.BaseTest;
import com.page.HomeBBPage;
import com.page.LoginBBPage;
import com.page.RegisterBBPage;
import com.page.TransferBBPage;

public class TransferBBTest extends BaseTest{
	
	private LoginBBPage loginPage;
	private RegisterBBPage registerPage;
	private HomeBBPage homePage;
	private TransferBBPage transferPage;
	
	String email1 = "test1@targettrust.com.br";
	String pass1 = "321";
	String conta1;
	String email2 = "test2@targettrust.com.br";
	String pass2 = "123";
	String conta2;
	
	@BeforeEach
	public void setUp() {
		loginPage = new LoginBBPage();
		loginPage.open("https://bugbank.netlify.app/#");
		
		//Cria a primeira conta
		registerPage = loginPage.clickRegister();
		registerPage.inputEmail(email1);
		registerPage.inputName("TargetTrust");
		registerPage.inputPassword(pass1);
		registerPage.inputPasswordConfirmation(pass1);
		registerPage.clickToggleSaldo();
		registerPage.clickCadastrar();
		conta1 = registerPage.getAccountNumber();
		
		loginPage = registerPage.clickClosed();
		
		//Cria a segunda conta
		registerPage = loginPage.clickRegister();
		
		registerPage.inputEmail(email2);
		registerPage.inputName("TargetTrust");
		registerPage.inputPassword(pass2);
		registerPage.inputPasswordConfirmation(pass2);
		registerPage.clickToggleSaldo();
		registerPage.clickCadastrar();
		conta2 = registerPage.getAccountNumber();
		
		loginPage = registerPage.clickClosed();
		
		System.out.println(conta1);
		System.out.println(conta2);
		
		loginPage.inputEmail(email1);
		loginPage.inputPassword(pass1);
		homePage = loginPage.clickAcessar();
	}
	
	@Test
	public void testTransferValue() throws InterruptedException {
		transferPage = homePage.clickTransfer();
		
		String[] partes = conta2.split("-");             
        String numeroConta = partes[0]; // A primeira parte é o número
        String digito = partes[1];      // A segunda parte é o dígito
        
        transferPage.inputAccountNumber(numeroConta);
        transferPage.inputDigit(digito);
        Thread.sleep(5000);
        //TODO finalizar a transferência
        
	}

}
