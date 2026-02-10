package com.tutorialsninja.com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;		
		PageFactory.initElements(driver, this);		
	}
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	public void enterEmailAddress(String emailText) {
		emailField.sendKeys(emailText);
	}
	
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	public void enterPassword(String passwordtext) {
		passwordField.sendKeys(passwordtext);
	}
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement button;
	
	public void clickOnloginButton() {
		button.click();
	}
	
	@FindBy(xpath="//div[contains (@class, 'alert alert-danger alert-dismissible')]")
	private WebElement alerWarmingMessage;
	
	public String alerWarmingMessage() {
		
		return alerWarmingMessage.getText();
	}

}
