package hr_officer_Module;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hrm.Genericutility.ExcelUtility;
import com.hrm.Genericutility.FileUtility;
import com.hrm.Genericutility.JavaUtility;
import com.hrm.Genericutility.WebdriverUtility;
import com.hrm.Objectrepository.EditEmployeePage;
import com.hrm.Objectrepository.EmployeePage;
import com.hrm.Objectrepository.HrAssistantHomePage;
import com.hrm.Objectrepository.HrofficerHomePage;
import com.hrm.Objectrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditEmployeeinHROfficercheckinhraTest {

	public static void main(String[] args) throws Throwable 
	{
		JavaUtility jLib = new JavaUtility();
		FileUtility fLib= new FileUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebdriverUtility wLib = new WebdriverUtility();
		
		String BROWSER=fLib.readDatafromPropertyFile("browser");	
		String URL=fLib.readDatafromPropertyFile("url");
		String USERNAME=fLib.readDatafromPropertyFile("hrofficeusername");
		String PASSWORD=fLib.readDatafromPropertyFile("hroffipass");
		String HassUN=fLib.readDatafromPropertyFile("hrassiuser");
		String Hasspwd=fLib.readDatafromPropertyFile("hrasspass");
		
		/*FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Data.properties");
		Properties p= new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
        String URL = p.getProperty("url");
       String USERNAME = p.getProperty("hrofficeusername");
      String PASSWORD = p.getProperty("hroffipass");
      String hraUN = p.getProperty("hrassiuser");
      String hraPS = p.getProperty("hrasspass");
       
      FileInputStream fi= new FileInputStream(".\\src\\test\\resources\\TestData50.xlsx");
      Workbook wb = WorkbookFactory.create(fi);
      Sheet sh = wb.getSheet("emp");
      String empname = sh.getRow(1).getCell(1).getStringCellValue();
      String hro = wb.getSheet("Sheet1").getRow(2).getCell(2).getStringCellValue();
      String hra = wb.getSheet("Sheet1").getRow(3).getCell(2).getStringCellValue();
      String midN = sh.getRow(3).getCell(1).getStringCellValue();
     String posi = sh.getRow(4).getCell(1).getStringCellValue();

	   String cor = wb.getSheet("dep&br").getRow(1).getCell(0).getStringCellValue();
	   String bran = wb.getSheet("dep&br").getRow(1).getCell(1).getStringCellValue();*/
		String empname = eLib.readDatafromExcel("emp", 1, 2);
		String hro =eLib.readDatafromExcel("Sheet1", 2, 2);
		String hra =eLib.readDatafromExcel("Sheet1", 3, 2);
		String midN =eLib.readDatafromExcel("emp", 3, 1);
		String posi =eLib.readDatafromExcel("emp", 4, 1);
		String cor =eLib.readDatafromExcel("dep&br", 3, 0);
		String bran =eLib.readDatafromExcel("dep&br", 3, 1);
		
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
        lp.login(USERNAME, PASSWORD, hro, driver);
     /* driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
      driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
     WebElement hrtype = driver.findElement(By.name("hr_type"));
        Select se= new Select(hrtype);
       se.selectByVisibleText(hro);
     wLib.select(hro, hrtype);
      driver.findElement(By.name("login_hr")).click();*/
     wLib.acceptAlert(driver);
      HrofficerHomePage hop= new HrofficerHomePage(driver);
      hop.homepage(driver);
      EmployeePage ep=new EmployeePage(driver);
      ep.searchemp(empname);
      ep.editemp();
      
      EditEmployeePage eep= new EditEmployeePage();     
     eep.edit(driver, empname, cor, bran,midN 
    		 
    		 );
      
     /* driver.findElement(By.xpath("//p[contains(text(),'EMPLOYEE')]")).click();
      driver.findElement(By.xpath("//p[text()='Add Employee']")).click();
      driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Nali142");
      driver.findElement(By.xpath("//i[@title='Edit Employee']")).click();
     WebElement dep = driver.findElement(By.xpath("//input[@value='rajesh108']/ancestor::div[@class='modal-body']/descendant::select[@name='employee_department']"));
//      Select sc1= new Select(dep);
//      sc1.selectByVisibleText(cor);
      wLib.select("Basavanagudi", dep);
      dep.isDisplayed();
      WebElement br = driver.findElement(By.xpath("//input[@value='rajesh108']/ancestor::div[@class='modal-body']/descendant::select[@name='employee_branches']"));
//      Select sc2= new Select(br);
//      sc2.selectByVisibleText(bran);
      wLib.select("Bengaluru", br);
      
      File f1 = new File(".\\src\\test\\resources\\Doc1.docx");
      String path1 = f1.getAbsolutePath();
      File f2 = new File(".\\src\\test\\resources\\pic.png");
      String path2 = f2.getAbsolutePath();
      driver.findElement(By.xpath("//input[@value='Nali142']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_file201']")).sendKeys(path1);
      driver.findElement(By.xpath("//input[@value='Nali142']/ancestor::div[@class='modal-body']/descendant::input[@name='employee_image']")).sendKeys(path2);
      driver.findElement(By.xpath("//input[@value='Nali142']/ancestor::div[@class='modal-body']/following-sibling::div[@class='modal-footer justify-content-between']/descendant::button[text()='Update']")).click();
     wLib.acceptAlert(driver);
     // driver.switchTo().alert().accept();*/
      
      hop.hrologout(driver);
    /*  driver.findElement(By.xpath("//a[@data-toggle='dropdown']")).click();
      driver.findElement(By.xpath("//a[@href='log_out.php']")).click();
      */
      wLib.acceptAlert(driver);
     lp.login(HassUN, Hasspwd, hra, driver);
      /*driver.findElement(By.name("hr_email")).sendKeys(HassUN);
      driver.findElement(By.name("hr_password")).sendKeys(Hasspwd);
     WebElement hrtype1 = driver.findElement(By.name("hr_type"));
//     Select se1= new Select(hrtype1);
//     se1.selectByVisibleText(hra);
     wLib.select(hra, hrtype1);
      driver.findElement(By.name("login_hr")).click();*/
      wLib.acceptAlert(driver);
      HrAssistantHomePage hap= new HrAssistantHomePage(driver);
      hap.homepage();
      ep.searchemp(empname);
    
      
      

	}

}
