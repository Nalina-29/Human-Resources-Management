package testNGPractice_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrm.Genericutility.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmployeeCreationTest 
{
@Test(dataProvider = "data")
public void fecth(String name)
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.get("http://rmgtestingserver/domain/HRM_System/Admin_Dashboard/Add_employee.php");
	driver.findElement(By.name("employee_firstname")).sendKeys(name);
}
	
	
	@DataProvider
	public Object[][] data() throws Throwable
	{
		ExcelUtility eLib= new ExcelUtility();
		Object[][] value = eLib.DPmultipledata("Dataprovid");
		return value;
	}
}
