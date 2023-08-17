package testNGTestsript_package;

import static org.testng.Assert.fail;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;
import com.hrm.Objectrepository.EmployeePage;
import com.hrm.Objectrepository.EmployeePopupinfoPage;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;
@Listeners(com.hrm.Genericutility.ListenerImpleClass.class)
public class CreateEmployeepopupTestNGTest extends BaseClass
{
@Test
public void popup() throws Throwable
{
	String USERNAME=fLib.readDatafromPropertyFile("hrofficeusername");
	String PASSWORD=fLib.readDatafromPropertyFile("hroffipass");
	String hro = eLib.readDatafromExcel("Sheet1", 2, 2);
	
	LoginPage lp= new LoginPage(driver);
	lp.login(USERNAME, PASSWORD, hro,driver);
	
	HrofficerHomePage hop= new HrofficerHomePage(driver);
	hop.homepage(driver);
	fail();
	EmployeePage ep= new EmployeePage(driver);
	ep.addadmin();
	EmployeePopupinfoPage empp= new EmployeePopupinfoPage(driver);
	empp.popinfo("Add Employee",driver);
	
	
	
	
}
}
