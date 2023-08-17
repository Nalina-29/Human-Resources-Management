package hr_Head_module;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.Genericutility.ExcelUtility;
import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.WebdriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecorporateinhrHeadTest {

	public static void main(String[] args) throws Throwable 
	{
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wLib= new  WebdriverUtility();
		
		String BROWSER=fLib.readDatafromPropertyFile("browser");
		String URL =fLib.readDatafromPropertyFile("url");
		 String USERNAME =fLib.readDatafromPropertyFile("hrofficeusername");
		 String PASSWORD =fLib.readDatafromPropertyFile("hroffipass");
		String HeadUn= fLib.readDatafromPropertyFile("hrheadus");
		 String Headpwd=fLib.readDatafromPropertyFile("hrheadpassword");
		/*
		FileInputStream  fis = new FileInputStream(".\\src\\test\\resources\\Data.properties");
		Properties p= new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("hrheadus");
		String PASSWORD = p.getProperty("hrheadpassword");
		String USERNAME1=p.getProperty("hrofficeusername");
		String PASSWORD1=p.getProperty("hroffipass");

		FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
		 Workbook wb = WorkbookFactory.create(fi);
		 Sheet sh = wb.getSheet("emp");
		int count = sh.getLastRowNum();
		String hrH = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
	   String cor = wb.getSheet("dep&br").getRow(1).getCell(0).getStringCellValue();
	   String bran = wb.getSheet("dep&br").getRow(1).getCell(1).getStringCellValue();
	   String hro = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
			*/
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
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     wLib.waitforPageLoad(driver);
		driver.get(URL);
		driver.findElement(By.name("hr_email")).sendKeys(HeadUn);
		driver.findElement(By.name("hr_password")).sendKeys(Headpwd);
		WebElement hr_Type = driver.findElement(By.name("hr_type"));
		//Select se= new Select(hr_Type);
		//se.selectByVisibleText(hrH);
		wLib.select(hrH, hr_Type);
		driver.findElement(By.name("login_hr")).click();
		wLib.acceptAlert(driver);
		//driver.switchTo().alert().accept();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//p[contains(text(),'CORPORATE')]")).click();
		driver.findElement(By.xpath("//p[text()='Add Corporate']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Add Corporate')]")).click();
		driver.findElement(By.name("corporate_name")).sendKeys(cor);
		driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
		wLib.acceptAlert(driver);
		//driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
		driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
		Thread.sleep(2000);
		wLib.acceptAlert(driver);
		//driver.switchTo().alert().accept();
		 driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
	      driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
	     WebElement hrtype = driver.findElement(By.name("hr_type"));
	     //Select se1= new Select(hrtype);
	     //se1.selectByVisibleText(hro);
	     wLib.select(hro, hrtype);
	      driver.findElement(By.name("login_hr")).click();
	      Thread.sleep(2000);
	      wLib.acceptAlert(driver);
	      //driver.switchTo().alert().accept();
	      driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
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
	       
	       eLib.getMultipleDataFromExce("emp", 0, 3, driver);
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
           File f2 = new File(".\\src\\test\\resources\\pic.png");
           String path2 = f2.getAbsolutePath();
           driver.findElement(By.xpath("(//input[@name='employee_file201'])[1]")).sendKeys(path1);
	  driver.findElement(By.xpath("(//input[@name='employee_image'])[1]")).sendKeys(path2);
	   driver.findElement(By.xpath("//button[@name='emplo']")).click();
	   Thread.sleep(2000);
	      
	   wLib.acceptAlert(driver);
	   //driver.switchTo().alert().accept();
	}

}
