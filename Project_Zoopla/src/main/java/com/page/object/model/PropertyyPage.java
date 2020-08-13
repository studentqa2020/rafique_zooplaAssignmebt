package com.page.object.model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PropertyyPage {   
	
	public PropertyyPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
     	}
	
	@FindBy(xpath="//input[@id='search-input-location']") 
	private WebElement LocationName;
	
	
	@FindBy(xpath="//*[@id='search-submit']") 
	private WebElement searchSelectBtn;
	
	@FindBy(xpath="//*[@class='listing-results-price text-price']") //26
	private List<WebElement> homePrice;
	
//	(//*[@class='ui-agent__logo'])[1]
	@FindBy(xpath="//*[@class='js-lazy-loaded']") 
	private WebElement selectLogo;
	
	@FindBy(xpath="(//*[@class='ui-agent__name'])[1]") 
	private WebElement agentName;
			
	@FindBy(xpath="(//*[@class='ui-agent__tel ui-agent__text'])[1]") 
	private WebElement PhoneAgent;
	@FindBy(xpath="(//*[text()='My Zoopla'])[1]") 
	private WebElement zoplaPage;
	//*[@class='icon--logged-out']
	
	//(//*[@class='ewzihio0 css-1rxdwmd e1lra66m0'])[5]
	@FindBy(xpath="(//*[@class='ewzihio0 css-1rxdwmd e1lra66m0'])[5]") 
	//*[contains(text(),'Sign out')]
	private WebElement logOutPage;
	
	public WebElement getlogOutPage() { 
		return logOutPage; 
		}	
	
	
	public WebElement getzoplaPage() { 
		return zoplaPage;
		}	
					
	public WebElement getPhoneAgent() { 
	return PhoneAgent;
	}

			public WebElement getagentName() { 
				return agentName;
			}

			
	public WebElement getselectLogo() { 
		return selectLogo;
	}

	
	public List<WebElement> homePrice() {
		return homePrice;
	}
	
	public WebElement getsearchSelectBtn() {
		return searchSelectBtn;
	}
	public WebElement getLocationName() {
		return LocationName;
	}
	
	

}


