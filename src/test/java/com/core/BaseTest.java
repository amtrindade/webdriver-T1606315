package com.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import static com.core.DriverFactory.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public abstract class BaseTest {
	
	@AfterEach
	public void tearDown(TestInfo testInfo) throws IOException {
		//Captura o nome do teste
		String nameTest = testInfo.getTestMethod().map(method -> method.getName()).orElse("test-desconhecido");
		
		//Captura a imagem da tela
		File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("target"+ File.separator + nameTest+LocalDateTime.now()+".jpg"));
				
		
		DriverFactory.killDriver();		
	}

}
