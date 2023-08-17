package hr_officer_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.Genericutility.DatabaseUtility;
import com.hrm.Genericutility.ExcelUtility;
import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.JavaUtility;
import com.hrm.Genericutility.WebdriverUtility;
import com.hrm.Objectrepository.AddEmployeePage;
import com.hrm.Objectrepository.EmployeePage;
import com.hrm.Objectrepository.HrheadHomePage;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEmployeePOMTest 
{
public static void main(String[] args) throws Throwable
{
	DatabaseUtility dLib = new DatabaseUtility();
	ExcelUtility eLib= new ExcelUtility();
	FileUtility fLib = new FileUtility();
	JavaUtility jLib = new JavaUtility();
	WebdriverUtility wLib = new WebdriverUtility();
	
	String BROWSER=fLib.readDatafromPropertyFile("browser");
	String URL=fLib.readDatafromPropertyFile("url");
	String USERNAME=fLib.readDatafromPropertyFile("hrofficeusername");
	String PASSWORD=fLib.readDatafromPropertyFile("hroffipass");
	String HEADUS=fLib.readDatafromPropertyFile("hrheadus");
	String HEADPWD=fLib.readDatafromPropertyFile("hrheadpassword");
	String hro = eLib.readDatafromExcel("Sheet1", 2, 2);
	String hrh = eLib.readDatafromExcel("Sheet1", 1, 2);
	String dep = eLib.readDatafromExcel("dep&br", 1, 0);
	String branch= eLib.readDatafromExcel("dep&br", 1, 1);
	
	String empName = eLib.readDatafromExcel("emp", 1, 1);
	
	WebDriver driver;
	
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	}
	else
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}
	wLib.maximize(driver);
	driver.get(URL);
	wLib.waitforPageLoad(driver);
	LoginPage lp= new LoginPage(driver);
	lp.login(USERNAME, PASSWORD, hro,driver);
	wLib.acceptAlert(driver);
	HrofficerHomePage hop= new HrofficerHomePage(driver);
	hop.homepage(driver);
	EmployeePage ep= new EmployeePage(driver);
	ep.addadmin();
	AddEmployeePage aep= new AddEmployeePage(driver);
	aep.createEmployee(eLib.getMultipleDataFromExce("emp", 0, 1, driver), driver, jLib, dep, branch);
	
	wLib.acceptAlert(driver);
	hop.hrologout(driver);
	wLib.acceptAlert(driver);
	lp.login(HEADUS, HEADPWD, hrh,driver);
	wLib.acceptAlert(driver);
	HrheadHomePage hhp= new HrheadHomePage(driver);
	hhp.employeeclick();
	ep.searchemp(empName);
	
	boolean emp = driver.findElement(By.xpath("//table[@id='example1']/descendant::td[text()='"+empName+"']")).isDisplayed();
	if(emp)
	{
		System.out.println("Employee is created");
		
	}
	
	
}
}
