package hr_Head_module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.Genericutility.ExcelUtility;
import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.JavaUtility;
import com.hrm.Genericutility.WebdriverUtility;
import com.hrm.Objectrepository.AddCorporatePage;
import com.hrm.Objectrepository.AddEmployeePage;
import com.hrm.Objectrepository.CreatedEmployeeInfoPage;
import com.hrm.Objectrepository.EmployeePage;
import com.hrm.Objectrepository.HrheadHomePage;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCorporatePOM
{
	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib= new  WebdriverUtility();
		JavaUtility jLib= new JavaUtility();
		String BROWSER=fLib.readDatafromPropertyFile("browser");
		String URL =fLib.readDatafromPropertyFile("url");
		 String USERNAME =fLib.readDatafromPropertyFile("hrofficeusername");
		 String PASSWORD =fLib.readDatafromPropertyFile("hroffipass");
		String HeadUn= fLib.readDatafromPropertyFile("hrheadus");
		 String Headpwd=fLib.readDatafromPropertyFile("hrheadpassword");
		
		 String hrH = eLib.readDatafromExcel("Sheet1", 1, 2);
		 String hro = eLib.readDatafromExcel("Sheet1", 2, 2);
		 String cor = eLib.readDatafromExcel("dep&br", 1, 0);
		 String bran = eLib.readDatafromExcel("dep&br", 1, 1);
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
		driver.get(URL);
		LoginPage lp= new LoginPage(driver);
		lp.login(HeadUn, Headpwd, hrH, driver);
		
		/*driver.findElement(By.name("hr_email")).sendKeys(HeadUn);
		driver.findElement(By.name("hr_password")).sendKeys(Headpwd);
		WebElement hr_Type = driver.findElement(By.name("hr_type"));
		//Select se= new Select(hr_Type);
		//se.selectByVisibleText(hrH);
		wLib.select(hrH, hr_Type);
		driver.findElement(By.name("login_hr")).click();*/
		
		wLib.acceptAlert(driver);
		
		HrheadHomePage hhp= new HrheadHomePage(driver);
		hhp.corporateclick(driver);
		AddCorporatePage acp= new AddCorporatePage(driver);
		acp.addCorporate(cor, driver);
		
		/*driver.findElement(By.xpath("//p[contains(text(),'CORPORATE')]")).click();
		driver.findElement(By.xpath("//p[text()='Add Corporate']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Corporate')]")).click();
		driver.findElement(By.name("corporate_name")).sendKeys(cor);
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();*/
		
		hhp.logout(driver);
		/*driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[@href='log_out.php']")).click();*/
		
		lp.login(USERNAME, PASSWORD, hro, driver);
		
		/* driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
	      driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
	     WebElement hrtype = driver.findElement(By.name("hr_type"));
	     //Select se1= new Select(hrtype);
	     //se1.selectByVisibleText(hro);
	     wLib.select(hro, hrtype);
	      driver.findElement(By.name("login_hr")).click();*/
	      wLib.acceptAlert(driver);
	      HrofficerHomePage hop= new HrofficerHomePage(driver);
	      hop.homepage(driver);
	       EmployeePage ep= new EmployeePage(driver);
	      ep.addadmin();
	     /* driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
	      driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
	      driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
	      /* HashMap<String, String> map = new HashMap<String,String>();
	      for(int i=0; i<=count ;i++)
	      {
	    	 String key = sh.getRow(i).getCell(0).getStringCellValue();
	    	 String value = sh.getRow(i).getCell(3).getStringCellValue();
	    	 map.put(key, value);
	      }
	       for(Entry<String, String> set:map.entrySet())
	       {
	    	   driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	       }*/
	       AddEmployeePage aep= new AddEmployeePage(driver);
	       aep.createEmployee(eLib.getMultipleDataFromExce("emp", 0, 2, driver), driver, jLib, cor, bran);
	      /* eLib.getMultipleDataFromExce("emp", 0, 3, driver);
	       WebElement dep = driver.findElement(By.name("employee_department"));
           //Select sc1= new Select(dep);
           //sc1.selectByVisibleText(cor);
           wLib.select(cor, dep);
           dep.isDisplayed();
           WebElement br = driver.findElement(By.name("employee_branches"));
          // Select sc2= new Select(br);
          // sc2.selectByVisibleText(bran);
           wLib.select(bran, br);
           
           File f1 = new File(".\\src\\test\\resources\\Doc1.docx");
           String path1 = f1.getAbsolutePath();
           File f2 = new Fil;e(".\\src\\test\\resources\\pic.png");
           String path2 = f2.getAbsolutePath();
           driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(path1);
	  driver.findElement(By.xpath("(//input[@name='employee_image'])[1]")).sendKeys(path2);
	   driver.findElement(By.xpath("//button[@name='emplo']")).click();
	   Thread.sleep(2000);
	   //driver.switchTo().alert().accept();*/
          CreatedEmployeeInfoPage cpip= new CreatedEmployeeInfoPage();
          cpip.info(driver, "Insert Successfully!!!");
        
         hop.hrologout(driver);
         
	}


}
