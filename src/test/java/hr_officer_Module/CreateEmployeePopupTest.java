package hr_officer_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.Genericutility.ExcelUtility;
import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEmployeePopupTest {

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib= new  WebdriverUtility();
		
		String BROWSER=fLib.readDatafromPropertyFile("browser");
		String URL =fLib.readDatafromPropertyFile("url");
		 String USERNAME =fLib.readDatafromPropertyFile("hrofficeusername");
		 String PASSWORD =fLib.readDatafromPropertyFile("hroffipass");
		/*
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Data.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
        String URL = pObj.getProperty("url");
       String USERNAME = pObj.getProperty("hrofficeusername");
      String PASSWORD = pObj.getProperty("hroffipass");
       
      FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
      Workbook wb = WorkbookFactory.create(fi);
    
     String hr_type = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
    
*/
		 String hr_type = eLib.readDatafromExcel("Sheet1", 2, 2);
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
      wLib.waitforPageLoad(driver);
      
       // driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.get(URL);
      driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
      driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
     WebElement hrtype = driver.findElement(By.name("hr_type"));
    // Select se= new Select(hrtype);
    // se.selectByVisibleText(hr_type);
     
     wLib.select(hr_type, hrtype);
     
      driver.findElement(By.name("login_hr")).click();
      driver.switchTo().alert().accept();
      driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
      driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
      driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
      
    WebElement actual = driver.findElement(By.xpath("//h4[text()='Add Employee']"));
      boolean act = actual.isDisplayed();
    
     if(act) 
     {
    	 System.out.println("Add employee popup is displayed");
     }
     else
     {
    	 System.out.println("Add employee popup is not displayed");
     }
	}

}
