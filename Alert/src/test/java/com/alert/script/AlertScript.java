package com.alert.script;

import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alert.helper.AlertHelper;
import com.alert.pages.AlertPages;

public class AlertScript {

	AlertPages page = null;
	AlertHelper help = null;
	XSSFSheet sheet = null;
	WebDriver driver = null;
	int cell,row=0;

	@BeforeSuite
	public void driverSetUp() {
		page = new AlertPages();
		help = new AlertHelper();
	}

	@BeforeClass
	public void urlAndClassCall() {
		page.file();
		System.setProperty("webdriver.chrome.driver", com.alert.constant.Constant.CHROME_PATH);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.get(page.getToolsQA_ALERT());

	}
//------------dataProvider(this program didn't used)--------------
	@DataProvider(name = "test1")
	public Object[] sheetObject() {
		return new Object[] { page.getSheet() };
	}
	
	@DataProvider(name = "test2")
	public Object[][] headerDataObject() {
		return new Object[][] {{sheet, page.getHeader_Data()}};
	}

	@DataProvider(name = "test3")
	public Object[][] givenDataObject() {
		return new Object[][] {{sheet, page.getGiven_Data()}};
	}
	
	@DataProvider(name = "test4")
	public Object[][] allAlertObject() {
		return new Object[][] {{sheet, driver, cell, row}};
	}
//----------------------------------------------------------------	
	@Test
	public void excelInitiation() {

		sheet = help.sheet(page.getSheet());
	}

	@Test(dependsOnMethods = { "excelInitiation" })
	public void findHeaderCell() {

		cell = help.find(sheet, page.getHeader_Data());		
	}
	
	@Test(dependsOnMethods = { "findHeaderCell" })
	public void findGivenDataRow() {

		row = help.findXPath(sheet, page.getGiven_Data());
	}
	
	@Test(dependsOnMethods = { "findGivenDataRow" })
	public void find() {
		
		help.alert(sheet, driver, cell, row);
	}
		
	@AfterClass
	public void driverClose() {
		driver.close();
	}
}