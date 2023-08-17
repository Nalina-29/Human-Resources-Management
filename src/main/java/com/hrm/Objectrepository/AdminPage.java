 package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage
{
   @FindBy(xpath="//button[@data-toggle='modal']")
   private WebElement addAdminBtn;
   
   @FindBy(xpath="//input[@type='search']")
   private WebElement search;
   
   public AdminPage(WebDriver driver)
   {
	   PageFactory.initElements(driver, this);
   }

public WebElement getAddAdminBtn() {
	return addAdminBtn;
}

public WebElement getSearch() {
	return search;
}
   public void clickonAdminBtn() {
	   
	   addAdminBtn.click();
   }
   
   
}
