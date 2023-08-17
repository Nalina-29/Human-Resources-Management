package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.Genericutility.WebdriverUtility;

public class AddCorporatePage extends WebdriverUtility
{
   @FindBy(xpath="//button[contains(text(),'Add Corporate')]")
   private WebElement addCorporatebtn;
   @FindBy(xpath="//input[@placeholder='Corporate Name']")
   private WebElement corName;
   @FindBy(xpath="//button[contains(text(),'Save')]")
   private WebElement corsaveBtn;
   @FindBy(xpath="//button[contains(text(),'Save')]/preceding-sibling::button[@type='button']")
   private WebElement corCancelBtn;
   
   public AddCorporatePage(WebDriver driver)
   {
	  PageFactory.initElements(driver, this); 
   }

public WebElement getAddCorporatebtn() {
	return addCorporatebtn;
}

public WebElement getCorName() {
	return corName;
}

public WebElement getCorsaveBtn() {
	return corsaveBtn;
}

public WebElement getCorCancelBtn() {
	return corCancelBtn;
}
   public void addCorporate(String corpoName, WebDriver driver)
   {
	   addCorporatebtn.click();
	   waitForElementTobevisible(driver, corName);
	   corName.sendKeys(corpoName);
	   corsaveBtn.click();
	   acceptAlert(driver);
   }
}
