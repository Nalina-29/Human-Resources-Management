package hr_Head_module;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.Genericutility.ExcelUtility;
import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.WebdriverUtility;
import com.hrm.Objectrepository.AddAdminPage;
import com.hrm.Objectrepository.AdminPage;
import com.hrm.Objectrepository.CreatedEmployeeInfoPage;
import com.hrm.Objectrepository.HrheadHomePage;
import com.hrm.Objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateHrOfficerTest {

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib= new  WebdriverUtility();
		
		String BROWSER=fLib.readDatafromPropertyFile("browser");
		String URL =fLib.readDatafromPropertyFile("url");
		String HeadUn= fLib.readDatafromPropertyFile("hrheadus");
		 String Headpwd=fLib.readDatafromPropertyFile("hrheadpassword");
		 
		 String hrType = eLib.readDatafromExcel("Sheet1", 1, 2);
		 String empID =eLib.readDatafromExcel("Admin", 1, 0);
		 String first =eLib.readDatafromExcel("Admin", 1, 1);
		 String last =eLib.readDatafromExcel("Admin", 1, 2);
		 String middle =eLib.readDatafromExcel("Admin", 1, 3);
		 String number =eLib.readDatafromExcel("Admin", 1, 4);
		 String htype =eLib.readDatafromExcel("Admin", 1, 5);
		 String email =eLib.readDatafromExcel("Admin", 1, 6);
		 String password =eLib.readDatafromExcel("Admin", 1, 7);
		 
		/*FileInputStream  fis = new FileInputStream(".\\src\\test\\resources\\Data.properties");
		Properties p= new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("hrheadus");
		String PASSWORD = p.getProperty("hrheadpassword");
		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
		 Workbook wb = WorkbookFactory.create(fi);
		String hrType = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String empID = wb.getSheet("Admin").getRow(1).getCell(0).getStringCellValue();
		String first = wb.getSheet("Admin").getRow(1).getCell(1).getStringCellValue();
		String last = wb.getSheet("Admin").getRow(1).getCell(2).getStringCellValue();
		String middle = wb.getSheet("Admin").getRow(1).getCell(3).getStringCellValue();
		String number = wb.getSheet("Admin").getRow(1).getCell(4).getStringCellValue();
		String htype = wb.getSheet("Admin").getRow(1).getCell(5).getStringCellValue();
		String  email= wb.getSheet("Admin").getRow(1).getCell(6).getStringCellValue();
		String password = wb.getSheet("Admin").getRow(1).getCell(7).getStringCellValue();*/

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		LoginPage lp= new LoginPage(driver);
		lp.login(HeadUn, Headpwd, hrType, driver);
		/*driver.findElement(By.name("hr_email")).sendKeys(HeadUn);
		driver.findElement(By.name("hr_password")).sendKeys(Headpwd);
		WebElement hr_Type = driver.findElement(By.name("hr_type"));
//		Select se= new Select(hr_Type);
//		se.selectByVisibleText(hrType);
		wLib.select(hrType, hr_Type);
		driver.findElement(By.name("login_hr")).click();
		//driver.switchTo().alert().accept();*/
		wLib.acceptAlert(driver);
		HrheadHomePage hhp= new HrheadHomePage(driver);
		hhp.adminclick(driver);
		AdminPage ap= new AdminPage(driver);
		ap.clickonAdminBtn();
		AddAdminPage aap= new AddAdminPage(driver);
		aap.addadmin(empID, first, last, middle, number, htype, email, password);
		
		/*driver.findElement(By.xpath("//p[contains(text(),'ADMIN')]")).click();
		driver.findElement(By.xpath("//p[text()='Add Admin']")).click();
		driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
		driver.findElement(By.name("hr_companyid")).sendKeys(empID);
		driver.findElement(By.name("hr_firstname")).sendKeys(first);
		driver.findElement(By.name("hr_lastname")).sendKeys(last);
		driver.findElement(By.name("hr_middlename")).sendKeys(middle);
		driver.findElement(By.name("hr_contactno")).sendKeys(number);
		WebElement dd = driver.findElement(By.name("hr_type"));
		Select se1= new Select(dd);
		se1.selectByVisibleText(htype);
		wLib.select(htype, dd);
		driver.findElement(By.name("hr_email")).sendKeys(email);
		driver.findElement(By.name("hr_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[@name='hr_admin']")).click();
		wLib.acceptAlert(driver);
		driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[@href='log_out.php']")).click();*/
		wLib.acceptAlert(driver);
		hhp.logout(driver);
		wLib.acceptAlert(driver);
		lp.login(email, password, htype, driver);
		/*driver.findElement(By.name("hr_email")).sendKeys(email);
		driver.findElement(By.name("hr_password")).sendKeys(password);
		WebElement hr_Type1 = driver.findElement(By.name("hr_type"));
//		Select se2 = new Select(hr_Type1);
//		se2.selectByVisibleText(htype);
		wLib.select(htype, hr_Type1);
		
		driver.findElement(By.name("login_hr")).click();
		*/
		CreatedEmployeeInfoPage crp= new CreatedEmployeeInfoPage();
		crp.loginInfo(driver, "Login Successfully!!");
		wLib.acceptAlert(driver);
		
		
		

	}

}
