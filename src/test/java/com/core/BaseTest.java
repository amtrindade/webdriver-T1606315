package com.core;

import org.junit.jupiter.api.AfterEach;

public abstract class BaseTest {
	
	@AfterEach
	public void tearDown() {
		DriverFactory.killDriver();		
	}

}
