package testNGTestsript_package;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;
import com.hrm.Objectrepository.AddEmployeePage;
import com.hrm.Objectrepository.EmployeePage;
import com.hrm.Objectrepository.HrheadHomePage;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;

public class Createemployeeinhrofficer extends BaseClass
{
 @Test
	public void create() throws Throwable
	{
		String HEADUS = fLib.readDatafromPropertyFile("hrheadus");
		String HEADPWD = fLib.readDatafromPropertyFile("hrheadpassword");
		String hrhead = eLib.readDatafromExcel("Sheet1", 1, 2);
		String empName = eLib.readDatafromExcel("emp", 1, 1);
		String dep = eLib.readDatafromExcel("dep&br", 1, 0);
		String branch= eLib.readDatafromExcel("dep&br", 1, 1);
		String HROUN=fLib.readDatafromPropertyFile("hrofficeusername");
		String HROPWD=fLib.readDatafromPropertyFile("hroffipass");
		String hrotype=eLib.readDatafromExcel("Sheet1", 2, 2);
		
		LoginPage lp= new LoginPage(driver);
		lp.login(HROUN, HROPWD, hrotype, driver);
		
		HrofficerHomePage hop= new HrofficerHomePage(driver);
		hop.homepage(driver);
		EmployeePage ep= new EmployeePage(driver);
		ep.addadmin();
		AddEmployeePage aep= new AddEmployeePage(driver);
		aep.createEmployee(eLib.getMultipleDataFromExce("emp", 0, 1, driver), driver, jLib, dep, branch);
		wLib.acceptAlert(driver);
		HrofficerHomePage hrh= new HrofficerHomePage(driver);
		hrh.hrologout(driver);
		
		
		lp.login(HEADUS, HEADPWD, hrhead, driver);
		
		
		HrheadHomePage hhp= new HrheadHomePage(driver);
		hhp.employeeclick();
		
		ep.searchemp(empName);
		
		boolean emp = driver.findElement(By.xpath("//td[contains(text(),'"+empName+"')]")).isDisplayed();
		if(emp)
		{
			System.out.println("Employee is created");
			
		}
		hhp.logout(driver);
		
		
    	
		
		
	}
	
	
}
