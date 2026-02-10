package com.tutorialsninja.com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	
	public SearchPage (WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (name="search")
	private WebElement sendproductName;
	
	public void enterProductName(String productName) {
		sendproductName.sendKeys(productName);
	}
	
	
	@FindBy (xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	
	@FindBy (linkText="HP LP3065")
	private WebElement HPLP306isDisplayed;
	
	public boolean verify_HPLP306Displayed() {
		return HPLP306isDisplayed.isDisplayed();
	}
	
	@FindBy (xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement NOProductmessage;
	
	public boolean verifyNOProductmessageDisplayed() {
//		return NOProductmessage.isDisplayed();
		
		return false; // intentionally failing method
	
	}

}
