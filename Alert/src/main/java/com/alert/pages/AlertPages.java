package com.alert.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.alert.constant.Constant;

public class AlertPages {

	FileInputStream fis=null;
	Properties prop=null;

	String toolsQA_ALERT,Given_Data,header_Data,sheet=null;

		public void file() {
		
		File fine = new File(Constant.PROPERTIES_PATH);

		try {
			fis = new FileInputStream(fine);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	 prop =new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		toolsQA_ALERT=prop.getProperty("toolsQA_ALERT");
		Given_Data=prop.getProperty("Given_Data");
		header_Data=prop.getProperty("header_Data");
		sheet=prop.getProperty("sheet");
		
		}

	
		public String getToolsQA_ALERT() {
			return toolsQA_ALERT;
		}

		public String getGiven_Data() {
			return Given_Data;
		}

		public String getHeader_Data() {
			return header_Data;
		}


		public String getSheet() {
			return sheet;
		}
		
}
