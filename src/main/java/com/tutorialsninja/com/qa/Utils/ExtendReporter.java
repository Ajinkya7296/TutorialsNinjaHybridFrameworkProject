package com.tutorialsninja.com.qa.Utils;
import java.io.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.util.Properties;

public class ExtendReporter {


	public static ExtentReports generateExtendReport() {

		ExtentReports extendReport = new ExtentReports();
		
		File extendReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extendReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results Report");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:SS");
		
		extendReport.attachReporter(sparkReporter);
		
		
		Properties configProp= new Properties ();
		
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\com\\qa\\config\\config.properties");
		
		
		try {
			FileInputStream fis	 = new FileInputStream(configPropFile);
			configProp.load(fis);
		} catch (Throwable e) {			
			e.printStackTrace();
		}
		
		extendReport.setSystemInfo("Application URL", configProp.getProperty("URL"));
		extendReport.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extendReport.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extendReport.setSystemInfo("Password", configProp.getProperty("validPassword"));
		extendReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extendReport.setSystemInfo("Username", System.getProperty("user.name"));
		extendReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extendReport;
		
	}
}
