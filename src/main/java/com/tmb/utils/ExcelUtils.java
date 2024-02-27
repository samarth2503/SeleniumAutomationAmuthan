package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.FrameworkException.InvalidPathforExcelException;
import com.tmb.constants.FrameworkConstants;

public final class ExcelUtils {
	
	private ExcelUtils() {}
	
	public static List<Map<String,String>> getTestDetails(String sheetname)
	{
		List<Map<String,String>> list = null;
		
		try(FileInputStream fs = new FileInputStream(FrameworkConstants.getExcelpath())) {
			
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetname);
			
			Map<String,String> hm = null;
			list = new ArrayList<>();
			
			int rowNum = sh.getLastRowNum();
			int columnNum = sh.getRow(0).getLastCellNum();
			
			for(int i=1;i<rowNum;i++)
			{
				hm = new HashMap<String,String>();
				
				for(int j=0;j<columnNum;j++)
				{
					hm.put(sh.getRow(0).getCell(j).getStringCellValue(), sh.getRow(i).getCell(j).getStringCellValue());
					CellType cell = sh.getRow(0).getCell(j).getCellType();
					
				}
				
				list.add(hm);
			}
			
			
		} catch (FileNotFoundException e) {
			throw new InvalidPathforExcelException("Excel File you are trying to read is not found..",e.getCause());
		}  catch (IOException e) {
			throw new RuntimeException("Some IO Exception happended while reading Excel file..");
		}
		
		return list;
	}

}
