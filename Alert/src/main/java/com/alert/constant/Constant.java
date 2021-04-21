package com.alert.constant;

import java.io.File;

public class Constant {
     
	public static final String RESOURCES_PATH  = System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"resources";
	public static final String PROPERTIES_PATH = RESOURCES_PATH+File.separator+"properties"+File.separator+"alert.properties";
	public static final String EXCEL_PATH      = RESOURCES_PATH+File.separator+"excels"+File.separator+"AlertToolsQA.xlsx";
	public static final String CHROME_PATH     = RESOURCES_PATH+File.separator+"drivers"+File.separator+"chromedriver.exe";
}
