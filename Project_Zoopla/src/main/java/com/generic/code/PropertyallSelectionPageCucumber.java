package com.generic.code;


import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Actions;

import com.config.BaseConfig;
import com.page.object.model.PropertyyPage;
import com.util.Highlighter;
import com.util.TakeAppScreenShot;
import com.util.Wait;

public class PropertyallSelectionPageCucumber extends BaseLoginCucumber {
	
	public static void propertySelections() throws Throwable{
	
		driver=getLogin();
		
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PropertyyPage page = new PropertyyPage(driver); 	
	    
		Wait.getExplicitWaitByElement(driver, page.getLocationName());		
	    Highlighter.getcolor(driver,page.getLocationName());
	    page.getLocationName().sendKeys(BaseConfig.getConfig("searchLocation"));
		
		
	    Highlighter.getcolor(driver,page.getsearchSelectBtn());
		page.getsearchSelectBtn().click(); 
			
			
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
