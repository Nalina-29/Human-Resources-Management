package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.Genericutility.WebdriverUtility;

public class HrheadHomePage extends WebdriverUtility
{
  @FindBy(xpath="//p[contains(text(),'CORPORATE')]")
  private WebElement corporate;
  @FindBy(xpath="//p[contains(text(),'Add Corporate')]")
  private WebElement addCorporate;
  @FindBy(xpath="//p[contains(text(),'BRANCHES')]")
  private WebElement branches;
  @FindBy(xpath="//p[text()='Add Braches']")
  private WebElement addBranches;
  @FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
  private WebElement employee;
  @FindBy(xpath="//p[text()='Add Employee']")
  private WebElement addEmployee;
  @FindBy(xpath="//p[contains(text(),'ADMIN')]")
  private WebElement admin;
  @FindBy(xpath="//p[text()='Add Admin']")
  private WebElement addAdmin;
  @FindBy(xpath="//a[@data-toggle='dropdown']")
  private WebElement logoutimg;
  @FindBy(xpath="//a[@href='log_out.php']")
  private WebElement logoutbtn;
  
  public HrheadHomePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getCorporate() {
	return corporate;
}

public WebElement getAddCorporate() {
	return addCorporate;
}

public WebElement getBranches() {
	return branches;
}

public WebElement getAddBranches() {
	return addBranches;
}

public WebElement getEmployee() {
	return employee;
}

public WebElement getAddEmployee() {
	return addEmployee;
}

public WebElement getAdmin() {
	return admin;
}

public WebElement getAddAdmin() {
	return addAdmin;
}

public WebElement getLogoutimg() {
	return logoutimg;
}

public WebElement getLogoutbtn() {
	return logoutbtn;
}

public void corporateclick(WebDriver driver)
{
	corporate.click();
	waitForElementTobevisible(driver, addCorporate);
	addCorporate.click();
}
  public void branchclick()
  {
	  branches.click();
	  addBranches.click();
  }
  public void employeeclick()
  {
	  employee.click();
	  addEmployee.click();
  }
  public void adminclick(WebDriver driver)
  {
	  admin.click();
	  waitForElementTobevisible(driver, addAdmin);
	  addAdmin.click();
  }
  public void logout(WebDriver driver)
  {
	  logoutimg.click();
	  logoutbtn.click();
	  acceptAlert(driver);
  }
}
