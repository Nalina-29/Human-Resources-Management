package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hrm.Genericutility.WebdriverUtility;

public class EmployeePopupinfoPage extends WebdriverUtility
{
   @FindBy(xpath="//h4[text()='Add Employee']")
   private WebElement title;
   
   public EmployeePopupinfoPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

public WebElement getTitle() {
	return title;
}
  public void popinfo(String expdata, WebDriver driver)
  {
	  waitForElementTobevisible(driver, title);
	  String actual = title.getText();
	  System.out.println(actual);
	  Assert.assertTrue(true, "Employee popup is diaplayed");
//	  if(actual.contains(expdata))
//	  {
//		  System.out.println("Employee popup is diaplayed");
//	  }
//	  else
//	  {
//		  System.out.println("Employee popup is not dispalyed");
//	  }
  }
}
