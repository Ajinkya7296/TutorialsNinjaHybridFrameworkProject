package com.tutorialsninja.com.qa.Utils;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v141.page.Page;
import org.openqa.selenium.io.FileHandler;

import java.io.*;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 5;

	public static Object[][] getTestDataFromExcelSheet(String sheetName) {

		File excelFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialsninja\\com\\qa\\testData\\TutorialsninjaTestData.xlsx");

		XSSFWorkbook workbook = null;

		try {
			FileInputStream fisExcel = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fisExcel);
		} catch (Throwable e) {

			e.printStackTrace();
		}

		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rows][cols];
		
		for ( int i=0; i<rows;i++) {
			XSSFRow row = sheet.getRow(i+1);
			
			for (int j=0; j<cols;j++) {
				XSSFCell cell =row.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				
				case STRING :  data[i][j]= cell.getStringCellValue();
				break;
				case NUMERIC :  data[i][j]= Integer.toString((int)cell.getNumericCellValue());
				break;
				case BOOLEAN:
				data [i][j]= cell.getBooleanCellValue();
				
				
				}
				
			}
		
		}
		return data;

	}

	public static String generateEmailTimeStamp() {

		Date date = new Date();
		String generateEmail = date.toString().replace(" ", "_").replace(":", "_");

		return (generateEmail + "@gmail.com");

	}
	
	public static String captureScreenShot(WebDriver driver, String testName) {
		

		
		File srcScreenShotFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath= System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		
		try {
			FileHandler.copy(srcScreenShotFile, new File(destinationScreenshotPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return destinationScreenshotPath;
	}

}
