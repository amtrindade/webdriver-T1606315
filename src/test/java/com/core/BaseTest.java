package com.core;

import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {
	
	@AfterEach
	public void tearDown() {
		//TODO Screenshot com a evidencia do teste
		
		DriverFactory.killDriver();		
	}

}
