package testNGPractice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.Genericutility.ExcelUtility;

public class DPGeneric_Test 
{
@Test(dataProvider = "genericdata")
public void exceldata(String qee, String asd, String zxc)
{
	System.out.println(qee+" "+asd+"  "+zxc);
}
	
	
@DataProvider
public Object[][] genericdata() throws Throwable
{
	ExcelUtility eLib = new ExcelUtility();
	Object[][] value = eLib.DPmultipledata("Dataprovid");
	return value;
}
}
  