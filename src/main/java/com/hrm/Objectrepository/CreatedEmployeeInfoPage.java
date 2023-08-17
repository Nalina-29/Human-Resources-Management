package com.hrm.Objectrepository;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

public class CreatedEmployeeInfoPage 
{
  public void info(WebDriver driver, String expected)
  {
	  Alert al = driver.switchTo().alert();
	  String actual = al.getText();
	  assertEquals(actual, expected, "Employee inserted sucessfully");
	  
//	  if(actual.contains(expected))
//	  {
//		  System.out.println("Employee inserted sucessfully");
//	  }
//	  else
//	  {
//		  System.out.println("Employee is not inserted sucessfully");  
//	  }
  }
  public void loginInfo(WebDriver driver, String expected)
  {
	  Alert al = driver.switchTo().alert();
	  String actual = al.getText();
	  assertEquals(actual, expected, "Created hr is successfully logged in");
	  
//	  if(actual.contains(expected))
//	  {
//		  System.out.println("Created hr is successfully logged in");
//	  }
//	  else
//	  {
//		  System.out.println("hr is not creadted");  
//	  }
  }
  public void updateinfo(WebDriver driver, String expected)
  {
	  Alert al = driver.switchTo().alert();
	  String actual = al.getText();
	  assertEquals(actual, expected, "Employee updated successfully");
	  
//	  System.out.println(actual);
//	  if(actual.contains(expected))
//	  {
//		  System.out.println("Employee updated successfully");
//	  }
//	  else
//	  {
//		  System.out.println("Employee is  not updated");  
//	  } 
  }
 
}
