package com.tutorialsninja.com.qa.testcases;

import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.com.qa.Utils.Utilities;
import com.tutorialsninja.com.qa.base.Base;
import com.tutorialsninja.com.qa.pages.AccountSuccessPage;
import com.tutorialsninja.com.qa.pages.HomePage;
import com.tutorialsninja.com.qa.pages.RegisterPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterTest extends Base {
	public WebDriver driver;

	public RegisterTest() {
		super();
	}
	
	@BeforeMethod

	public void set() {

		driver =intializeBrowserAndOpenApplicaction(prop.getProperty("browserName"));
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnRegister();
	}

	@Test(priority = 1)
	public void verifyregistrationWithValidMandatoryFields() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirmation(prop.getProperty("validPassword"));
		registerPage.selectPrivacyPolicyField();
		registerPage.clickOnsubmitButton();
		AccountSuccessPage accountSuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccesspage.retriveSuccesHeadingMessage(),"Acount not created");
	}

	@Test(priority = 2)
	public void verifyregistrationWithValidAllFields() {
		
		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(Utilities.generateEmailTimeStamp());
		registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirmation(prop.getProperty("validPassword"));
		registerPage.selectNewsLetterField();
		registerPage.selectPrivacyPolicyField();
		registerPage.clickOnsubmitButton();
		AccountSuccessPage accountSuccesspage = new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccesspage.retriveSuccesHeadingMessage(),"Acount not created");

	}
	
	@Test(priority = 3)
	public void verifyregistrationWithExistingEmailAddress() {

		RegisterPage registerPage = new RegisterPage(driver);

		registerPage.enterFirstName(dataProp.getProperty("firstName"));
		registerPage.enterLastName(dataProp.getProperty("lastName"));
		registerPage.enterEmail(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataProp.getProperty("telephoneNumber"));
		registerPage.enterPassword(prop.getProperty("validPassword"));
		registerPage.enterPasswordConfirmation(prop.getProperty("validPassword"));
		registerPage.selectNewsLetterField();
		registerPage.selectPrivacyPolicyField();
		registerPage.clickOnsubmitButton();
		
		String actualWarnigMessage = registerPage.getExistingEmailarningMessage();
		
		Assert.assertTrue(actualWarnigMessage.equals(dataProp.getProperty("duplicateEmailWarning")), "Warning message not displayed");
	}
	
	@Test(priority = 4)
	public void verifyregistrationWithoutFillingAnydetails() {

		RegisterPage registerPage = new RegisterPage(driver);
	
		registerPage.clickOnsubmitButton();
		
		String actualPrivacyPolicywarning = registerPage.getActualPrivacyPolicywarning();
		
		Assert.assertTrue(actualPrivacyPolicywarning.equals(dataProp.getProperty("privacyPolicyWarning")), "Privacy Policy Warning message not displayed");
		
		String firstNameWarningMessage = registerPage.getFirstNameWarningMessage();
		Assert.assertTrue(firstNameWarningMessage.equals(dataProp.getProperty("firstNameWarning")), "Name warning message is not displayed.");
		
		String lastNameWarningMessage = registerPage.getLastNameWarningMessage();
		Assert.assertTrue(lastNameWarningMessage.equals(dataProp.getProperty("lastnameWarning")), "LastName warning message is not displayed.");
		
		String emailWarningMessage = registerPage.getEmailWarningMessage();
		Assert.assertTrue(emailWarningMessage.equals(dataProp.getProperty("eMailWarning")), "Email warning message is not displayed.");
		
		String telephoneWarningMessage = registerPage.getTelephoneWarningMessage();
		Assert.assertTrue(telephoneWarningMessage.equals(dataProp.getProperty("telephoneNumberwarning")), "Telephone warning message is not displayed.");
		
		String passwordWarningMessage = registerPage.getPasswordWarningMessage();
		Assert.assertTrue(passwordWarningMessage.equals(dataProp.getProperty("passwordWarning")), "Password warning message is not displayed.");
		
	}


	@AfterMethod
	public void tearDown() {

		driver.quit();
	}
}
