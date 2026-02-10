package com.tutorialsninja.com.qa.base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.tutorialsninja.com.qa.Utils.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Base {
	
	
	public Properties prop;
	public Properties dataProp;
	
	  WebDriver driver;

 
	
	public Base() {
		
		dataProp= new Properties();
		File testFile= new File(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tutorialsninja\\com\\qa\\testdata\\testdata.properties");		
		
		try {		
		FileInputStream dataFis= new FileInputStream(testFile);
		dataProp.load(dataFis);		
		}catch(Throwable e) {
			e.printStackTrace();
		}

		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir") + "\\src\\main\\java\\com\\tutorialsninja\\com\\qa\\config\\config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			
			e.printStackTrace();
		}
		
	}
	public WebDriver intializeBrowserAndOpenApplicaction(String browserName) {
		
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("URL"));
		
		return driver;
		
	}
}


