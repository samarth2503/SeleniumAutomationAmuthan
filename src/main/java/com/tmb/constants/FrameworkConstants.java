package com.tmb.constants;

import com.tmb.enums.ConfigProperties;
import com.tmb.utils.ReadPropertyFile;

public final class FrameworkConstants {
	
	private FrameworkConstants() {}
	
	private static final String CONFIGPATH = System.getProperty("user.dir")+"/src/main/resources/config/config.properties";
	private static final int EXPLICTWAIT = 10;
	private static final String EXTENTREPORTPATH = System.getProperty("user.dir")+"/ExtentReports";
	private static final String EXCELPATH = System.getProperty("user.dir")+"/src/test/resources/excel/TestData.xlsx";
	
	public static String getExcelpath() {
		return EXCELPATH;
	}

	public static String getExtentreportpath() throws Exception {
		if(ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")) {
			return EXTENTREPORTPATH+"/"+System.currentTimeMillis()+"index.html";
		}
		return EXTENTREPORTPATH;
	}

	public static String getConfigpath() {
		return CONFIGPATH;
	}

	public static int getExplictwait() {
		return EXPLICTWAIT;
	}
	

}
