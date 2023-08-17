package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.Genericutility.WebdriverUtility;

public class HrofficerHomePage extends WebdriverUtility
{
    @FindBy(xpath="//p[contains(text(),'EMPLOYEE')]")
    private WebElement employee;
    @FindBy(xpath="//p[contains(text(),'Add Employee')]")
    private WebElement addEmployee;
    
    @FindBy(xpath="//a[@data-toggle='dropdown']")
    private WebElement logoutimg;
    @FindBy(xpath="//a[@href='log_out.php']")
    private WebElement logoutbtn;
    
    public HrofficerHomePage(WebDriver driver)
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

	public void homepage(WebDriver driver)
	{
		employee.click();
		waitForElementTobevisible(driver, addEmployee);
		addEmployee.click();
	}
	public void hrologout(WebDriver driver)
	{
		
		logoutimg.click();
		logoutbtn.click();
		acceptAlert(driver);
	}
}
