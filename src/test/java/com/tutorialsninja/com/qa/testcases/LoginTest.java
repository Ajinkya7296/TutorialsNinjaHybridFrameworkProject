package com.tutorialsninja.com.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.*;

import com.tutorialsninja.com.qa.Utils.Utilities;
import com.tutorialsninja.com.qa.base.Base;
import com.tutorialsninja.com.qa.pages.HomePage;
import com.tutorialsninja.com.qa.pages.LoginPage;
import com.tutorialsninja.com.qa.pages.MyAccountPage;

import java.time.Duration;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest extends Base {

	public WebDriver driver;
	
	public LoginTest() {
		super();
	}

	@BeforeMethod
	public void setup() {

		driver =intializeBrowserAndOpenApplicaction(prop.getProperty("browserName"));
		HomePage homePage= new HomePage(driver);
		homePage.clickOnMyAccountMenu();
		homePage.clickOnLoginOption();
	}

//	@Test(priority = 1)
//	public void verifyLoginWithValidCredentials() {
//	
//		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
//		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
//
//		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed(),
//				"Edit your account information not displayed");
//
//	}
//	
	
	@Test(priority = 1,dataProvider="validCreadentialsSupplier" )
	public void verifyLoginWithValidCredentials(String email, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnloginButton();
		
		MyAccountPage accountPage = new MyAccountPage(driver);
		
		Assert.assertTrue(accountPage.getDisplayStatusOfeditYourAcountInformationOption(),"Edit your account information not displayed");

	}
	
	@DataProvider (name="validCreadentialsSupplier")
	public Object [][] supplyTestData(){
		
		Object [][]data =Utilities.getTestDataFromExcelSheet("Login");
		return data;
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmailAddress(Utilities.generateEmailTimeStamp());
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnloginButton();		
		String ActualWarningMessage = loginPage.alerWarmingMessage();
		Assert.assertTrue(ActualWarningMessage.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Warning message not dispalyed");

	}
	
	@Test(priority = 3)
	public void verifyLoginWithValidEmailAndInvalidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);		
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataProp.getProperty("invalidPassword"));
		loginPage.clickOnloginButton();
		String ActualWarningMessage = loginPage.alerWarmingMessage();
		Assert.assertTrue(ActualWarningMessage.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Warning message not dispalyed");

	}
	
	@Test (priority = 4)
	public void verifyLoginWithInValidEmailAndvalidPassword() {

		LoginPage loginPage = new LoginPage(driver);	

		loginPage.enterEmailAddress(Utilities.generateEmailTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPassword"));		
		loginPage.clickOnloginButton();

		String ActualWarningMessage = loginPage.alerWarmingMessage();
		Assert.assertTrue(ActualWarningMessage.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Warning message not dispalyed");

	}
	
	@Test (priority = 5)
	public void verifyLoginWithoutProvidingEmailAndPassword() {

		LoginPage loginPage = new LoginPage(driver);	
		loginPage.clickOnloginButton();

		String ActualWarningMessage = loginPage.alerWarmingMessage();
		Assert.assertTrue(ActualWarningMessage.contains(dataProp.getProperty("emailPasswordNotMatchingWarning")),
				"Warning message not dispalyed");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
