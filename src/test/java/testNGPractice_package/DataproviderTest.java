package testNGPractice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest 
{
	@Test(dataProvider = "test")
	public void fetchdata(String username, String password, int Hrtype)
	{
		System.out.println("USERNAME---->"+username+"   PASSWORD---->"+password+"   hrtype--->"+Hrtype);
	
	
	}
	
	@DataProvider
   public Object[][] data()
   {
	   Object[][] obj = new Object[3][3];
	   
	   obj[0][0]="hrhead@gmail.com";
	   obj[0][1]="hrhead@123";
	   obj[0][2]="HrHead";
	   
	   obj[1][0]="hrofficer@gmail.com";
	   obj[1][1]="hrofficer@123";
	   obj[1][2]="HrOfficer";
	   
	   obj[2][0]="hrassistant@gmail.com";
	   obj[2][1]="hrassistant@123";
	   obj[2][2]="HrAssistant";
	   
	   return obj;
   }
	@DataProvider
	public Object[][] test()
	{
		Object[][] obj = new Object[3][3];
		
		obj[0][0]="Bangalore";
		   obj[0][1]="tumkur";
		   obj[0][2]=70;
		   
		   obj[1][0]="Bangalore";
		   obj[1][1]="Mangalore";
		   obj[1][2]=400;
		   
		   obj[2][0]="Tumkur";
		   obj[2][1]="Mandya";
		   obj[2][2]=200;
		   return obj;
   }
}
