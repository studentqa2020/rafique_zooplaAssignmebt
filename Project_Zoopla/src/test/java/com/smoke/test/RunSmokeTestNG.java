package com.smoke.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.generic.code.BaseLoginTestNg;
import com.generic.code.PropertyallSelectionPage;


public class RunSmokeTestNG {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() throws Throwable {
		
		BaseLoginTestNg.getLogin();
		
		
	}

	@Test
	public void propertyselect() throws Throwable {
		
		PropertyallSelectionPage.propertySelections();
		
	}
	
	@AfterTest
	public void teardown() {

		driver.quit();

		//ExtentTestManager.endTest();// end
	}
}
