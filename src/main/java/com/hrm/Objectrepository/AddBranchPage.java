package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddBranchPage {
	 @FindBy(xpath="//button[contains(text(),'Add Branches')]")
	   private WebElement addBranchbtn;
	   @FindBy(name="branches_name")
	   private WebElement branName;
	   @FindBy(xpath="//button[contains(text(),'Save')]")
	   private WebElement bransaveBtn;
	   @FindBy(xpath="//button[contains(text(),'Save')]/preceding-sibling::button[@type='button']")
	   private WebElement branCancelBtn;
	   
	   public AddBranchPage(WebDriver driver)
	   {
		   PageFactory.initElements(driver, this);
	   }

	public WebElement getAddBranchbtn() {
		return addBranchbtn;
	}

	public WebElement getBranName() {
		return branName;
	}

	public WebElement getBransaveBtn() {
		return bransaveBtn;
	}

	public WebElement getBranCancelBtn() {
		return branCancelBtn;
	}
	public void addBranch(String branchName)
	{
		addBranchbtn.click();
		branName.sendKeys(branchName);
		branName.click();
	}
}
