package testNGTestsript_package;

import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;
import com.hrm.Objectrepository.AddAdminPage;
import com.hrm.Objectrepository.AdminPage;
import com.hrm.Objectrepository.CreatedEmployeeInfoPage;
import com.hrm.Objectrepository.HrheadHomePage;
import com.hrm.Objectrepository.LoginPage;

public class CreateHrofficerinHRheadTestNGTest extends BaseClass
{
@Test
public void createhrofficer() throws Throwable
{
	String HeadUn= fLib.readDatafromPropertyFile("hrheadus");
	 String Headpwd=fLib.readDatafromPropertyFile("hrheadpassword");
	 String hrheadType = eLib.readDatafromExcel("Sheet1", 1, 2);
//	 String empID =eLib.readDatafromExcel("Admin", 1, 0);
//	 String first =eLib.readDatafromExcel("Admin", 1, 1);
//	 String last =eLib.readDatafromExcel("Admin", 1, 2);
//	 String middle =eLib.readDatafromExcel("Admin", 1, 3);
//	 String number =eLib.readDatafromExcel("Admin", 1, 4);
 String htype =eLib.readDatafromExcel("Admin", 5, 1);
 String email =eLib.readDatafromExcel("Admin", 6, 1);
	 String password =eLib.readDatafromExcel("Admin", 7, 1);
	 
	 
	 LoginPage lp= new LoginPage(driver);
		lp.login(HeadUn, Headpwd, hrheadType, driver);
		
		HrheadHomePage hhp= new HrheadHomePage(driver);
		hhp.adminclick(driver);
		AdminPage ap= new AdminPage(driver);
		ap.clickonAdminBtn();
		AddAdminPage aap= new AddAdminPage(driver);

		aap.addadmin(eLib.getMultipleDataFromExce("Admin", 0, 1, driver), driver);
		
		
		wLib.acceptAlert(driver);
		hhp.logout(driver);
		
		lp.login(email, password, htype);
		
		CreatedEmployeeInfoPage crp= new CreatedEmployeeInfoPage();
		crp.loginInfo(driver, "Login Successfully!!");
		
		
		
		
}

}
