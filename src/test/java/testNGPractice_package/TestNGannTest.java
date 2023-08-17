package testNGPractice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNGannTest 
{
 @BeforeSuite
	  public void config_BS()
	  {
		System.out.println("-- connect to BC --");  
	  }
	  @AfterSuite
	  public void config_AS()
	  {
		  System.out.println("-- close BD --");   
	  }
	  @BeforeClass
	  public void config_BC()
	  {
		  System.out.println("-- launch the browser --"); 
	  }
	  @AfterClass
	  public void config_Ac()
	  {
		  System.out.println("-- close the browser --"); 
	  }
	  @BeforeMethod
	  public void config_BM()
	  {
		  System.out.println("-- Login to app --"); 
	  }
	  @AfterMethod
	  public void config_AM()
	  {
		  System.out.println("-- Logout from app --"); 
	  }
	  @Test
	  public void test()
	  {
		  System.out.println("--hr assistant login --");
	  }
}
