package com.generic.code;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.util.Wait;
import com.util.Highlighter;

import com.util.TakeAppScreenShot;

public class BaseLoginTestNg {
	
	protected static WebDriver driver;
	public static  WebDriver getLogin() throws Throwable {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		 driver = new ChromeDriver();
		
		LoginPage login = new LoginPage(driver);
		
		driver.manage().window().maximize();
		driver.get(BaseConfig.getConfig("URL")); 
				
		login.getAcceptCookie().click();

		
		Highlighter.getcolor(driver, login.getSignInBtn());				
		
		TakeAppScreenShot.captureScreenShot(driver, "Sign in Page");
		login.getSignInBtn().click();
			
		Wait.getExplicitWaitByElement(driver,  login.getEmail()); 
		
		login.getEmail().sendKeys(BaseConfig.getConfig("userName"));
		
		Highlighter.getcolor(driver, login.getEmail(),"red");
				
		login.getPassWord().sendKeys(BaseConfig.getConfig("passWord"));
		Highlighter.getcolor(driver, login.getPassWord());		
				
		Highlighter.getcolor(driver, login.getSubmitBtn());		
		TakeAppScreenShot.captureScreenShot(driver, "Login Page");
		login.getSubmitBtn().click();
		System.out.println("Title of the Page is: "+driver.getTitle());
		TakeAppScreenShot.captureScreenShot(driver, "Home Page");
	return driver;
		
	}	

}
