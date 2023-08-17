package testNGPractice_package;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.Genericutility.IPathConstants;

public class DataPro_Excel 
{
  @Test(dataProvider = "getdatafromExcel")
  public void fetchdata(String qw, String asd, String mb)
  {
	  System.out.println(qw+"  "+asd+"  "+mb);
	  
  }

	@DataProvider
   public Object[][] getdatafromExcel() throws Throwable
   {
	   FileInputStream fi= new FileInputStream(IPathConstants.ExcelPath);
	   Workbook wb = WorkbookFactory.create(fi);
	  Sheet sh = wb.getSheet("Dataprovid");
	 int lastRowno = sh.getLastRowNum()+1;
	int lastCellno = sh.getRow(0).getLastCellNum();
	Object[][] obj = new Object[lastRowno][lastCellno];
	for(int i=0; i<lastRowno; i++)
	{
		for(int j=0; j<lastCellno; j++)
		{
			obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		}
	}
	return obj;
   }
}
