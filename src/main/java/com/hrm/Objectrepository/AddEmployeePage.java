package com.hrm.Objectrepository;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.JavaUtility;
import com.hrm.Genericutility.WebdriverUtility;

public class AddEmployeePage extends WebdriverUtility

{
  @FindBy(name="employee_companyid")
  private WebElement employeeID;
  @FindBy(name="employee_firstname")
  private WebElement empfirstName;
  @FindBy(name="employee_lastname")
  private WebElement emplastName;
  @FindBy(name="employee_middlename")
  private WebElement empmiddleName;
  @FindBy(name="employee_position")
  private WebElement empPosition;
  @FindBy(name="employee_contact")
  private WebElement empcontact;
  @FindBy(name="employee_sss")
  private WebElement empSSS;
  @FindBy(name="employee_tin")
  private WebElement empTin;
  @FindBy(name="employee_hdmf_pagibig")
  private WebElement emphdmf;
  @FindBy(name="employee_gsis")
  private WebElement empgsis;
  @FindBy(name="branches_datefrom")
  private WebElement brandatefrom;
  @FindBy(name="branches_recentdate")
  private WebElement branrecedate;
  @FindBy(name="employee_department")
  private WebElement empdep;
  @FindBy(name="employee_branches")
  private WebElement empbran;
  @FindBy(xpath="(//input[@name='employee_file201'])[1]")
  private WebElement emplFile;
  @FindBy(xpath="(//input[@name='employee_image'])[1]")
  private WebElement empimg;
  @FindBy(xpath="//button[@name='emplo']")
  private WebElement empsavebtn;
  @FindBy(xpath="//button[@name='emplo']/preceding-sibling::button[@type='button']")
  private WebElement empcancelbtn;
  
  public AddEmployeePage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
  }

public WebElement getEmployeeID() {
	return employeeID;
}

public WebElement getEmpfirstName() {
	return empfirstName;
}

public WebElement getEmplastName() {
	return emplastName;
}

public WebElement getEmpmiddleName() {
	return empmiddleName;
}

public WebElement getEmpPosition() {
	return empPosition;
}

public WebElement getEmpcontact() {
	return empcontact;
}

public WebElement getEmpSSS() {
	return empSSS;
}

public WebElement getEmpTin() {
	return empTin;
}

public WebElement getEmphdmf() {
	return emphdmf;
}

public WebElement getEmpgsis() {
	return empgsis;
}

public WebElement getBrandatefrom() {
	return brandatefrom;
}

public WebElement getBranrecedate() {
	return branrecedate;
}

public WebElement getEmpdep() {
	return empdep;
}

public WebElement getEmpbran() {
	return empbran;
}

public WebElement getEmplFile() {
	return emplFile;
}

public WebElement getEmpimg() {
	return empimg;
}

public WebElement getEmpsavebtn() {
	return empsavebtn;
}

public WebElement getEmpcancelbtn() {
	return empcancelbtn;
}
    
		  
  public void createEmployee(HashMap<String, String> map, WebDriver driver, JavaUtility jLib, String dep, String bran)
  {
	  for(Entry<String, String> set:map.entrySet())
      {
	   if(set.getKey().contains("employee_firstname"))
	   {
	    driver.findElement(By.name(set.getKey())).sendKeys(set.getValue()+jLib.getRandomNo());  
	   }
	   else
	   {
   	   driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
      }
      }
     select(dep, empdep);
     select(bran, empbran);
     FileUtility fLib= new FileUtility();
         fLib.fileupload(emplFile);
         fLib.imgupload(empimg);
     empsavebtn.click();
     
  }
}
