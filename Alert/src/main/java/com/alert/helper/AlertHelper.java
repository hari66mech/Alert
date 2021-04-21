package com.alert.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.alert.constant.Constant;

public class AlertHelper {

	public XSSFSheet sheet(String sheetName) {

		File file = new File(Constant.EXCEL_PATH);
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(inputStream);
		} catch (IOException e) {

			e.printStackTrace();
		}
		XSSFSheet sheet = wb.getSheet(sheetName);
		return sheet;

	}

	public int find(XSSFSheet sheet, String data) {

		int cell = sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum();
		int fdata = 0;

		for (int row_data = 0; row_data < cell; row_data++) {

			if (sheet.getRow(0).getCell(row_data).getStringCellValue().equals(data)) {

				fdata = row_data;
			}
		}
		return fdata;
	}

	public int findXPath(XSSFSheet sheet, String helper_data) {
		int cells = sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum();
		int rows = sheet.getLastRowNum() - sheet.getFirstRowNum();
		int frow = 0;
		for (int row = 0; row <= rows; row++) {

			for (int cell = 0; cell < cells; cell++)

				if (sheet.getRow(row).getCell(cell).getStringCellValue().equals(helper_data)) {

					frow = row;

				}
		}

		return frow;

	}

	public void alert(XSSFSheet sheet, WebDriver driver, int cell, int row) {

		String xpath = sheet.getRow(row).getCell(cell).getStringCellValue();

		try {
			driver.findElement(By.xpath(xpath)).click();

			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());

			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}

	}

}
