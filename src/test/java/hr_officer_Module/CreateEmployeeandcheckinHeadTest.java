package hr_officer_Module;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.Genericutility.ExcelUtility;
import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.JavaUtility;
import com.hrm.Genericutility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateEmployeeandcheckinHeadTest {

	public static void main(String[] args) throws Throwable 
	{
		//DatabaseUtility dLib= new DatabaseUtility();
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		String BROWSER=fLib.readDatafromPropertyFile("browser");	
		String URL=fLib.readDatafromPropertyFile("url");
		String USERNAME=fLib.readDatafromPropertyFile("hrofficeusername");
		String PASSWORD=fLib.readDatafromPropertyFile("hroffipass");
		String HeadUN=fLib.readDatafromPropertyFile("hrheadus");
		String Headpwd=fLib.readDatafromPropertyFile("hrheadpassword");
		
		/*
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Data.properties");
		Properties p= new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("hrofficeusername");
		String PASSWORD=p.getProperty("hroffipass");
		String HeadUN=p.getProperty("hrheadus");
		String Headpwd=p.getProperty("hrheadpassword");
		
		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("emp");
		int count = sh.getLastRowNum();
		System.out.println(count);
		String hro = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
		String hrh = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		*/
		String hro =eLib.readDatafromExcel("Sheet1", 2, 2);
		String hrh =eLib.readDatafromExcel("Sheet1", 1, 2);
		
		
		
		
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
		
		
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(URL);
		driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
		driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
		WebElement hr_Type = driver.findElement(By.name("hr_type"));
		//Select se= new Select(hr_Type);
		//se.selectByVisibleText(hro);
		
		wLib.select(hro, hr_Type);
		driver.findElement(By.name("login_hr")).click();
		Thread.sleep(2000);
		wLib.acceptAlert(driver);
		//driver.switchTo().alert().accept();
		Thread.sleep(2000);
		 driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
	      driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
	      driver.findElement(By.xpath("//button[@data-toggle='modal']")).click();
	   
	      
	      // String empname = sh.getRow(1).getCell(1).getStringCellValue();
	     /* HashMap<String, String> map = new HashMap<String,String>();
	      for(int i=0; i<=count ;i++)
	      {
	    	 String key = sh.getRow(i).getCell(0).getStringCellValue();
	    	 String value = sh.getRow(i).getCell(1).getStringCellValue();
	    	 map.put(key, value);
	      }
	       for(Entry<String, String> set:map.entrySet())
	       {
	    	   driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
	       }
	       */
	      eLib.getMultipleDataFromExce("emp", 0, 1, driver);
	       
	       
             WebElement dep = driver.findElement(By.name("employee_department"));
           //  Select sc1= new Select(dep);
            // sc1.selectByVisibleText("IT");
             
             wLib.select("IT", dep);
             WebElement br = driver.findElement(By.name("employee_branches"));
             //Select sc2= new Select(br);
             //sc2.selectByVisibleText("Bengaluru");
             
             wLib.select("Bengaluru", br);
             File f1 = new File(".\\src\\test\\resources\\Doc1.docx");
             String path1 = f1.getAbsolutePath();
             File f2 = new File(".\\src\\test\\resources\\pic.png");
             String path2 = f2.getAbsolutePath();
             driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(path1);
	  driver.findElement(By.xpath("(//input[@name='employee_image'])[1]")).sendKeys(path2);
	   driver.findElement(By.xpath("//button[@name='emplo']")).click();
	  
	wLib.acceptAlert(driver);
	driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
	driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
	Thread.sleep(2000);
	wLib.acceptAlert(driver);
	
	driver.findElement(By.name("hr_email")).sendKeys(HeadUN);
	driver.findElement(By.name("hr_password")).sendKeys(Headpwd);
	WebElement hr_Type1 = driver.findElement(By.name("hr_type"));
	//Select se1= new Select(hr_Type1);
	//se1.selectByVisibleText(hrh);
	wLib.select(hrh, hr_Type1);
	
	
	driver.findElement(By.name("login_hr")).click();
	Thread.sleep(2000);
	wLib.acceptAlert(driver);
	 driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
     driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
     //driver.findElement(By.xpath("//input[@type='search']")).sendKeys(empname);
    // boolean emp = driver.findElement(By.xpath("//table[@id='example1']/descendant::td[text()='"+empname+"']")).isDisplayed();
	//if(emp)
	//{System.out.println("Employee is created");}
    	driver.close();	 
	}

}
