package com.stepdef;

import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.generic.code.BaseLogin;
import com.generic.code.BaseLoginCucumber;
import com.generic.code.PropertyallSelectionPage;
import com.page.object.model.PropertyyPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AutomationZooplacucumber {
	
PropertyyPage page;	
 WebDriver driver;


@Given("login")
public void login() throws Throwable {
	//BaseLogin.getLogin();
	
	driver=BaseLoginCucumber.getLogin();
}

@When("Property search")
public void property_search() throws Throwable {
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
			 page = new PropertyyPage(driver); 	
		    
		Wait.getExplicitWaitByElement(driver, page.getLocationName());		
		    Highlighter.getcolor(driver,page.getLocationName());
		    page.getLocationName().sendKeys(BaseConfig.getConfig("searchLocation"));
			
			
		    Highlighter.getcolor(driver,page.getsearchSelectBtn());
			page.getsearchSelectBtn().click(); 
				
}

@When("check price descinding order and select  {int}th  prperty")
public void check_price_descinding_order_and_select_th_prperty(Integer int1) {
   
	int total= page.homePrice().size();
	System.out.println("Total House Number = "+ total);// no of house

    String [] allprice;
	Set<Integer>price=new TreeSet<>(); 
 for(int i=0;i<page.homePrice().size();i++) {
	 
	allprice= page.homePrice().get(i).getText().split(" ");

 price.add(Integer.parseInt(allprice[0].replace("£", "").replace(",","").trim()));
// price.add(Integer.parseInt(allprice[0]));
	//System.out.println(page.homePrice().get(i).getText()); //only for price list
	

 
 }
	System.out.println("Total House Price Ascending order " +price); 
	
	//Wait.getExplicitWaitByElement(driver, page.homePrice().get(4));
	page.homePrice().get(4).click();
}


@When("get logo ,agent name, Agent telephone")
public void get_logo_agent_name_Agent_telephone() {
    
	Wait.getExplicitWaitByElement(driver, page.getselectLogo());
 	if(page.getselectLogo().isDisplayed()) {
 		
 		System.out.println("Logo Present"); 
 	}
 	else {
 		System.out.println("NO Logo");
 		 
 	}
 	
 	TakeAppScreenShot.captureScreenShot(driver, "Agent Name");
 System.out.println("Agent Name  ="+ page.getagentName().getText());
TakeAppScreenShot.captureScreenShot(driver, "Agent Telephone");
System.out.println("Agent Telephone #"+ page.getPhoneAgent().getText()); 

}

@Then("logout")
public void logout() {
	Actions signout=new Actions(driver);
	 signout.moveToElement(page.getzoplaPage()).build().perform();
	 Highlighter.getcolor(driver, page.getzoplaPage(), "green");
	  
	signout.moveToElement(page.getlogOutPage()).build().perform();
	 Highlighter.getcolor(driver,page.getlogOutPage(), "yellow");
	 TakeAppScreenShot.captureScreenShot(driver, "Log Out");
	
	 page.getlogOutPage().click(); 
	
	 driver.quit();
}


}

