package com.hrm.Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.Genericutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility
{
// Declaration
	
	@FindBy (name="hr_email")
	private WebElement UserName;
	
	@FindBy(name="hr_password")
	private WebElement Password;
	
	@FindBy(name="hr_type")
	private WebElement dropdown;
	
	@FindBy(name="login_hr")
	private WebElement LoginBtn;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// utilization

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	// bussiness libraries
	public void login(String USERNAME, String PASSWORD, String Text, WebDriver driver) throws Throwable
	{
		UserName.sendKeys(USERNAME);
		Password.sendKeys(PASSWORD);
		select(Text, dropdown);
		LoginBtn.click();
	
		acceptAlert(driver);
	}
	public void login(String USERNAME, String PASSWORD, String Text)
	{
		UserName.sendKeys(USERNAME);
		Password.sendKeys(PASSWORD);
		select(Text, dropdown);
		LoginBtn.click();
	}
}
