package testNGPractice_package;

import org.testng.annotations.Test;

import com.hrm.Genericutility.BaseClass;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;

public class HrAssistantTestNGTest extends BaseClass
{ 
  @Test
  public void create() throws Throwable
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
		 lp.login(HROUS, HROPWD, hro, driver);
		 HrofficerHomePage hoh= new HrofficerHomePage(driver);
		 hoh.hrologout(driver);
  }
}
