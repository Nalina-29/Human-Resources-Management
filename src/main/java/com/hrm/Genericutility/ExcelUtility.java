package com.hrm.Genericutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtility 
{
	/**
	 * This method used to get the data from Excel
	 * @param sheetName
	 * @param rowNo
	 * @param cellNO
	 * @return
	 * @throws Throwable
	 */
  public String readDatafromExcel(String sheetName, int rowNo, int cellNO) throws Throwable
  {
	 FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	String value = wb.getSheet(sheetName).getRow(rowNo).getCell(cellNO).getStringCellValue();
  return value;
  
  }
  
  /**
   * This method is used to write the data into excel
   * @param sheetName
   * @param rowNo
   * @param cellNo
   * @param value
   * @throws Throwable
   */
  public void writeDataintoExcel(String sheetName, int rowNo, int cellNo, String value) throws Throwable
  {
	  FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi); 
		wb.getSheet(sheetName).createRow(rowNo).createCell(cellNo).setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
		wb.close();
  }
  /**
   * This method is used to get the last row number
   * @param sheetName
   * @return
   * @throws Throwable
   */
  public int getLastRowNo(String sheetName) throws Throwable
  {
	  FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
			Workbook wb = WorkbookFactory.create(fi);
			
			int count = wb.getSheet(sheetName).getLastRowNum();
			return count;
  }
  /**
   * This method is used the get the multiple data from Excel
   * @param sheetName
   * @param keycellNo
   * @param valuecellNo
   * @return
   * @throws Throwable
   */
  public HashMap<String, String> getMultipleDataFromExce(String sheetName, int keycellNo, int valuecellNo, WebDriver driver) throws Throwable
  {
	  FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet(sheetName);
		int count =sh.getLastRowNum();
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i=0; i<=count; i++)
		{
			String key = sh.getRow(i).getCell(keycellNo).getStringCellValue();
			 String value = sh.getRow(i).getCell(valuecellNo).getStringCellValue();
			 map.put(key, value);
	    }
		return map;
  }
  
  public Object[][] DPmultipledata(String sheetName) throws Throwable
  {
	  FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet(sheetName);
		int lastRowno =sh.getLastRowNum()+1; 
		int lastcellno= sh.getRow(0).getLastCellNum();
		Object[][] obj= new Object[lastRowno][lastcellno];
		for(int i=0; i<lastRowno; i++)
		{
			for(int j=0; j<lastcellno; j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
  }
}
