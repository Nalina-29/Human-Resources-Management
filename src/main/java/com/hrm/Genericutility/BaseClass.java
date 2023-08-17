package com.hrm.Genericutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
     public DatabaseUtility dLib= new DatabaseUtility();
     public  ExcelUtility eLib = new ExcelUtility();
     public FileUtility fLib= new FileUtility();
     public JavaUtility jLib= new JavaUtility();
     public WebdriverUtility wLib = new WebdriverUtility();
     public WebDriver driver;
     public static WebDriver sdriver;
     
    @BeforeSuite(alwaysRun = true)
     public void config_BS() throws Throwable
     {
    	 dLib.connectToDB();
    	 System.out.println("-- connect to DB ---");
     }
    
    
    
    
    
   // @Parameters("BROWSER")
    @BeforeClass(alwaysRun = true)
     public void config_BC() throws IOException
     {
    	String BROWSER = fLib.readDatafromPropertyFile("browser");
    	 String URL = fLib.readDatafromPropertyFile("url");
    	 if(BROWSER.equalsIgnoreCase("chrome"))
    	 {
    		 WebDriverManager.chromedriver().setup();
    		 driver= new ChromeDriver();
    	 }
    	 else if(BROWSER.equalsIgnoreCase("firefox"))
    	 {
    		 WebDriverManager.firefoxdriver().setup();
    		 driver= new FirefoxDriver();
    	 }
    	 else
    	 {
    		
    		 WebDriverManager.edgedriver().setup();
    		 driver=new EdgeDriver();
    	 }
    	 sdriver=driver;
    		wLib.maximize(driver);
    		System.out.println("-- launch the browser --");
    		driver.get(URL);
     }
     @BeforeMethod(alwaysRun = true)
     public void config_BM() throws Throwable
     {
    	
    	
    	System.out.println("-- Login to app --");
   }
     @AfterMethod(alwaysRun = true)
     public void config_AM()
     {
    	
    	 
    	 System.out.println("-- logout from app --");
     }
     @AfterClass(alwaysRun = true)
     public void config_AC()
     {
    	driver.quit(); 
    	System.out.println(" -- close the browser --");
     }
     @AfterSuite(alwaysRun = true)
     public void config_AS() throws Throwable
     {
    	 dLib.closeDB();
    	 System.out.println("-- close the DB --");
     }
}
