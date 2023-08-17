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

public class ReadmultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int r = wb.getSheet("Sheet1").getLastRowNum();
		Sheet sh = wb.getSheet("Sheet1");
		
		for(int i=0; i<=r; i++)
		{
			Row d = sh.getRow(i);
			Cell ce = d.getCell(0);
			String value = ce.toString();
			System.out.println(value);
		}
wb.close();
	}

}
