package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HrAssistantHomePage {
	 @FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
	    private WebElement employee;
	    @FindBy(xpath="//p[text()='Add Employee']")
	    private WebElement addEmployee;
	    
	    @FindBy(xpath="//a[@data-toggle='dropdown']")
	    private WebElement logoutimg;
	    @FindBy(xpath="//a[@href='log_out.php']")
	    private WebElement logoutbtn;
	    
	    public HrAssistantHomePage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }

		public WebElement getEmployee() {
			return employee;
		}

		public WebElement getAddEmployee() {
			return addEmployee;
		}
	    
		public WebElement getLogoutimg() {
			return logoutimg;
		}

		public WebElement getLogoutbtn() {
			return logoutbtn;
		}

		public void homepage()
		{
			employee.click();
			addEmployee.click();
		}
		public void hrologout()
		{
			logoutimg.click();
			logoutbtn.click();
		}
}
