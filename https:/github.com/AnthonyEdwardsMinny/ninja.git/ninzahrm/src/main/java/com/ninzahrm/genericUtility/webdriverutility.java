package com.ninzahrm.genericUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class webdriverutility {
	
	public void waittoloadpage(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}

}
