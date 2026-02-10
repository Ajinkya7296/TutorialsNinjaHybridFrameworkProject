package com.tutorialsninja.com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	
	public RegisterPage (WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText="Register")
	private WebElement registerField;
	
	public void clickOnRegister() {
		registerField.click();
	}
	
	@FindBy (id="input-firstname")
	private WebElement firstNameField;
	
	public void enterFirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}
	
	@FindBy (id="input-lastname")
	private WebElement lastNameField;
	
	public void enterLastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}
	
	@FindBy (id="input-email")
	private WebElement emailField;
	
	public void enterEmail(String emailtext) {
		emailField.sendKeys(emailtext);
	}
	
	@FindBy (id="input-telephone")
	private WebElement telephoneField;
	
	public void enterTelephone(String telephonetext) {
		telephoneField.sendKeys(telephonetext);
	}
	
	@FindBy (id="input-password")
	private WebElement passwordField;
	
	public void enterPassword(String passwordtext) {
		passwordField.sendKeys(passwordtext);
	}
	
	@FindBy (id="input-confirm")
	private WebElement confirmPasswordField;
	
	public void enterPasswordConfirmation(String confirmPasswordtext) {
		confirmPasswordField.sendKeys(confirmPasswordtext);
	}
	
	
	@FindBy (xpath="(//input[@name='newsletter'])[1]")
	private WebElement newsLetterField;
	
	public void selectNewsLetterField() {
		newsLetterField.click();
	}
	
	
	@FindBy (xpath="//input[@type='checkbox']")
	private WebElement privacyPolicyField;
	
	public void selectPrivacyPolicyField() {
		privacyPolicyField.click();
	}
	
	@FindBy (xpath="//input[@type='submit']")
	private WebElement submitButtonField;
	
	public void clickOnsubmitButton() {
		submitButtonField.click();
	}
	
	@FindBy (xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement existingEmailWarningMessage;
	
	public String getExistingEmailarningMessage() {
		return existingEmailWarningMessage.getText();
	}

	
	@FindBy (xpath="//div[contains(@class,'alert alert-danger alert-dismissible')]")
	private WebElement actualPrivacyPolicywarning;
	
	public String getActualPrivacyPolicywarning() {
		return actualPrivacyPolicywarning.getText();
	}
	
	
	@FindBy (xpath="//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	public String getFirstNameWarningMessage() {
		return firstNameWarningMessage.getText();
	}
	
	
	@FindBy (xpath="//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	public String getLastNameWarningMessage() {
		return lastNameWarningMessage.getText();
	}
	
	@FindBy (xpath="//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;
	
	public String getEmailWarningMessage() {
		return emailWarningMessage.getText();
	}
	
	@FindBy (xpath="//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	public String getTelephoneWarningMessage() {
		return telephoneWarningMessage.getText();
	}
	
	@FindBy (xpath="//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;
	
	public String getPasswordWarningMessage() {
		return passwordWarningMessage.getText();
	}
	
	
}
