package com.tutorialsninja.com.qa.testcases;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tutorialsninja.com.qa.pages.SearchPage;

import com.tutorialsninja.com.qa.base.Base;

public class SearchTest extends Base {
	
	public WebDriver driver;
	
	public SearchTest() {
		super();
	}

	@BeforeMethod

	public void setUp() {
		driver =intializeBrowserAndOpenApplicaction(prop.getProperty("browserName"));
		
	}
	
	@Test (priority=1)
	public void verifySeachWithValidProduct()
	{	
		SearchPage searchPage = new SearchPage(driver);
		searchPage.enterProductName(dataProp.getProperty("validProduct"));
		searchPage.clickOnSearchButton();
		
		Assert.assertTrue(searchPage.verify_HPLP306Displayed(),"HP LP3065 is not displayed");
		
	}
	
	@Test (priority=2)
	public void verifySeachWithInValidProduct()
	{	
		
		SearchPage searchPage = new SearchPage(driver);
		
		searchPage.enterProductName(dataProp.getProperty("invalidProduct"));
		searchPage.clickOnSearchButton();
		Assert.assertTrue(searchPage.verifyNOProductmessageDisplayed(),"No product message not displayed");
		
		
	}
	
	@Test (priority=3, dependsOnMethods= {"verifySeachWithInValidProduct","verifySeachWithValidProduct"})
	public void verifySeachWithOutProduct()
	{	
		SearchPage searchPage = new SearchPage(driver);
		
		searchPage.clickOnSearchButton();
		
		boolean noProductMessage= searchPage.verifyNOProductmessageDisplayed();
		Assert.assertTrue(noProductMessage, "Searched produsct is matached");
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
}
