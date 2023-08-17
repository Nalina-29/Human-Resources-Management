package com.hrm.Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.WebdriverUtility;

public class EditEmployeePage 

{

//business lib
 public void edit(WebDriver driver, String name, String dep, String bran, String middle)
 {
	 WebdriverUtility wLib= new WebdriverUtility();
	 driver.findElement(By.xpath("//input[@value='"+name+"']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_middlename']")).sendKeys(middle);
	 
	 WebElement department = driver.findElement(By.xpath("//input[@value='"+name+"']/ancestor::div[@class='modal-body']/descendant::select[@name='employee_branches']"));
       wLib.select(dep, department);
       WebElement branch = driver.findElement(By.xpath("//input[@value='"+name+"']/ancestor::div[@class='modal-body']/descendant::select[@name='employee_branches']"));
  wLib.select(bran, branch);
  FileUtility fLib= new FileUtility();
 
  WebElement file = driver.findElement(By.xpath("//input[@value='"+name+"']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_file201']"));
  WebElement img = driver.findElement(By.xpath("//input[@value='"+name+"']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_image']"));
  fLib.fileupload(file);
  fLib.imgupload(img);
  
  driver.findElement(By.xpath("//input[@value='"+name+"']/ancestor::div[@class='modal-body']/following-sibling::div[@class='modal-footer justify-content-between']/descendant::button[text()='Update']")).click();

 }
 
 public void edit(WebDriver driver, String empname, String lastname)
 {
	 driver.findElement(By.xpath("(//input[@value='"+empname+"']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_lastname'])[1]")).clear();
	 
	 driver.findElement(By.xpath("(//input[@value='"+empname+"']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_lastname'])[1]")).sendKeys(lastname);
 
	 FileUtility fLib= new FileUtility();
	 
	  WebElement file = driver.findElement(By.xpath("//input[@value='"+empname+"']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_file201']"));
	  WebElement img = driver.findElement(By.xpath("//input[@value='"+empname+"']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_image']"));
	  fLib.fileupload(file);
	  fLib.imgupload(img);
	  driver.findElement(By.xpath("//input[@value='"+empname+"']/ancestor::div[@class='modal-body']/following-sibling::div[@class='modal-footer justify-content-between']/descendant::button[text()='Update']")).click();

 }
}
