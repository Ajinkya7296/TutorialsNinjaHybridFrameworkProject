package com.tutorialsninja.com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
		
	public  HomePage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy (xpath="//span[normalize-space()='My Account']")
	private WebElement myAccountDropMenu;
	
	public void clickOnMyAccountMenu() {
		myAccountDropMenu.click();
	}
	
	
	@FindBy (linkText="Login")
	private WebElement loginOption;
	public void clickOnLoginOption() {
		loginOption.click();
	}
	
	

}
