package com.hrm.Objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.Genericutility.WebdriverUtility;

public class AddAdminPage extends WebdriverUtility
{
  @FindBy(name="hr_companyid")
  private WebElement companyID;
  @FindBy(name="hr_firstname")
  private WebElement firstName;
  @FindBy(name="hr_lastname")
  private WebElement lastName;
  @FindBy(name="hr_middlename")
  private WebElement middleName;
  @FindBy(name="hr_contactno")
  private WebElement contactNo;
  @FindBy(name="hr_type")
  private WebElement hrType;
  
  @FindBy(name="hr_email")
  private WebElement hr_email;
  @FindBy(name="hr_password")
  private WebElement hr_password;
  @FindBy(xpath="//button[@name='hr_admin']")
  private WebElement savebtn;
  @FindBy(xpath="//button[@name='hr_admin']/preceding-sibling::button[@type='button']")
  private WebElement cancelbtn;
  
  public AddAdminPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getCompanyID() {
	return companyID;
}

public WebElement getFirstName() {
	return firstName;
}

public WebElement getLastName() {
	return lastName;
}

public WebElement getMiddleName() {
	return middleName;
}

public WebElement getContactNo() {
	return contactNo;
}

public WebElement getHrType() {
	return hrType;
}

public WebElement getEmail() {
	return hr_email;
}

public WebElement getPassword() {
	return hr_password;
}

public WebElement getSavebtn() {
	return savebtn;
}

public WebElement getCancelbtn() {
	return cancelbtn;
}
 public void addadmin(String empId, String first, String last, String middle,String number, String hrdd,String email, String password )
 {
	 companyID.sendKeys(empId);
	 firstName.sendKeys(first);
	 lastName.sendKeys(last);
	 middleName.sendKeys(middle);
	 contactNo.sendKeys(number);
	 select(hrdd, hrType);
	 hr_email.sendKeys(email);
	 hr_password.sendKeys(password);
	 savebtn.click();
 }
 
 public void addadmin(HashMap<String, String> map, WebDriver driver)
 {
	 for(Entry<String, String> set:map.entrySet())
     {
	
  	   driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
   }
	 savebtn.click();
 }
}
