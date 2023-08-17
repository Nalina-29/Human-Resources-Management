package testNGTestsript_package;

import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;
import com.hrm.Objectrepository.CreatedEmployeeInfoPage;
import com.hrm.Objectrepository.EditEmployeePage;
import com.hrm.Objectrepository.EmployeePage;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;

public class EditEmployeeinHROTestNGTest extends BaseClass
{
@Test
public void editemp() throws Throwable
{
	String USERNAME=fLib.readDatafromPropertyFile("hrofficeusername");
	String PASSWORD=fLib.readDatafromPropertyFile("hroffipass");
	String empname = eLib.readDatafromExcel("emp", 1, 3);
	String hro =eLib.readDatafromExcel("Sheet1", 2, 2);
	 LoginPage lp= new LoginPage(driver);
     lp.login(USERNAME, PASSWORD, hro, driver);
     HrofficerHomePage hop= new HrofficerHomePage(driver);
     hop.homepage(driver);
     EmployeePage ep=new EmployeePage(driver);
     ep.searchemp(empname);
     ep.editemp();
     
     EditEmployeePage eep= new EditEmployeePage();
    eep.edit(driver, empname, "qwery");
    
    CreatedEmployeeInfoPage crp=new CreatedEmployeeInfoPage();
    crp.updateinfo(driver, "Update Successfully!!!");
}
}
