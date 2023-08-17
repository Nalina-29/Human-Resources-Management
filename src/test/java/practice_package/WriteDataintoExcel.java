package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataintoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		 FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
		 Workbook wb = WorkbookFactory.create(fis);
		   wb.getSheet("Sheet1").createRow(0).createCell(1).setCellValue("password");
		   
		   FileOutputStream fos= new FileOutputStream(".\\\\src\\\\test\\\\resources\\\\TestData50.xlsx");
           wb.write(fos);
           wb.close();
	}

}
