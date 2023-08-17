package testNGTestsript_package;

import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;
import com.hrm.Objectrepository.AddCorporatePage;
import com.hrm.Objectrepository.AddEmployeePage;
import com.hrm.Objectrepository.CreatedEmployeeInfoPage;
import com.hrm.Objectrepository.EmployeePage;
import com.hrm.Objectrepository.HrheadHomePage;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;

public class CreateCorporateuseinHrofficerTestNGTest extends BaseClass
{
@Test(retryAnalyzer = com.hrm.Genericutility.RetryImplementationClass.class)
public void createcorporate() throws Throwable
{
	 String HROUS =fLib.readDatafromPropertyFile("hrofficeusername");
	 String HROPWD =fLib.readDatafromPropertyFile("hroffipass");
	String HeadUn= fLib.readDatafromPropertyFile("hrheadus");
	 String Headpwd=fLib.readDatafromPropertyFile("hrheadpassword");
	 String hrH = eLib.readDatafromExcel("Sheet1", 1, 2);
	 String hro = eLib.readDatafromExcel("Sheet1", 2, 2);
	 String cor = eLib.readDatafromExcel("dep&br", 1, 0)+jLib.getRandomNo();
	 String bran = eLib.readDatafromExcel("dep&br", 1, 1);
	 
	 LoginPage lp= new LoginPage(driver);
	 lp.login(HeadUn, Headpwd, hrH, driver);
	 
	 
	 HrheadHomePage hhh= new HrheadHomePage(driver);
	 hhh.corporateclick(driver);
	 
	 AddCorporatePage acp= new AddCorporatePage(driver);
	 acp.addCorporate(cor, driver);
	 
	 hhh.logout(driver);
	 
	 lp.login(HROUS, HROPWD, hro, driver);
	 
	 HrofficerHomePage hoh= new HrofficerHomePage(driver);
	 hoh.homepage(driver);
	 
	 EmployeePage ep= new EmployeePage(driver);
     ep.addadmin();
     
     AddEmployeePage aep= new AddEmployeePage(driver);
     aep.createEmployee(eLib.getMultipleDataFromExce("emp", 0, 2, driver), driver, jLib, cor, bran);
  
     CreatedEmployeeInfoPage cpip= new CreatedEmployeeInfoPage();
     cpip.info(driver, "Insert Successfully!!!");
   
	 
}
	
	
}
