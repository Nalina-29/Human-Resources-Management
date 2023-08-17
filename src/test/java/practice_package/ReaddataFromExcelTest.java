package practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReaddataFromExcelTest 
{
  public static void main(String[] args) throws  IOException, EncryptedDocumentException, InvalidFormatException 
  {
	  FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
	 Workbook wb = WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet("Sheet1");
	Row r = sh.getRow(1);
	Cell c = r.getCell(0);
	String value = c.getStringCellValue();
	System.out.println(value);
	wb.close();
}
}
