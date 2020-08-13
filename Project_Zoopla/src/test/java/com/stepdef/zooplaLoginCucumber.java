package com.stepdef;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.LoginPage;
import com.page.object.model.PropertyyPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class zooplaLoginCucumber {
	
 WebDriver driver;
	LoginPage login;
	PropertyyPage page;
	@Given("open a browser")
	public void open_a_browser() {
		
System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		
		 driver = new ChromeDriver();
	    
	}

	@Given("Put URL")
	public void put_URL() throws Throwable {
		driver.manage().window().maximize();
		driver.get(BaseConfig.getConfig("URL")); 
		
	}

	@When("Click cookie")
	public void click_cookie() {
		login= new LoginPage(driver);
		Wait.getExplicitWaitByElement(driver, login.getAcceptCookie());
		
		Highlighter.getcolor(driver, login.getAcceptCookie());			
		login.getAcceptCookie().click();
	}

	@When("Click Signin")
	public void click_Signin() {
		login= new LoginPage(driver);
		
        Highlighter.getcolor(driver, login.getSignInBtn());				
		
		TakeAppScreenShot.captureScreenShot(driver, "Sign in Page");
		login.getSignInBtn().click();
	}

	@When("put valid user name")
	public void put_valid_user_name() throws Throwable {
       Wait.getExplicitWaitByElement(driver,  login.getEmail()); 
		
		login.getEmail().sendKeys(BaseConfig.getConfig("userName"));
		
		Highlighter.getcolor(driver, login.getEmail(),"red");
	}

	@When("put valid password")
	public void put_valid_password() throws Throwable {
		login.getPassWord().sendKeys(BaseConfig.getConfig("passWord"));
		Highlighter.getcolor(driver, login.getPassWord());	

	}

	@When("click sign in button")
	public void click_sign_in_button() {
		Highlighter.getcolor(driver, login.getSubmitBtn());		
		TakeAppScreenShot.captureScreenShot(driver, "Login Page");
		login.getSubmitBtn().click();
		
	}

	@Then("Validate login was success")
	public void validate_login_was_success() {
		System.out.println("Title of the Page is: "+driver.getTitle());
		TakeAppScreenShot.captureScreenShot(driver, "Home Page");
	}

	

	
	 	
	}

	
	
