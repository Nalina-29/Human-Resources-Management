package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePage 
{
  @FindBy(xpath="//button[@data-toggle='modal']")
  private WebElement AddadminBtn;
  @FindBy(xpath="//input[@type='search']")
  private WebElement search;
  @FindBy(xpath="//i[@title='Edit Employee']")
  private WebElement editemp;
  
  public EmployeePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getAddadminBtn() {
	return AddadminBtn;
}

public WebElement getSearch() {
	return search;
}

public WebElement getEditemp() {
	return editemp;
}

public void addadmin()
{
	AddadminBtn.click();
}
  public void searchemp(String empNAme)
  {
	  search.sendKeys(empNAme);
  }
  public void editemp()
  {
	  editemp.click();
  }
}
