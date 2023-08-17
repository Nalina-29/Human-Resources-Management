package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ReadDatafromCommandLineTest
{
  @Test
  public void readdatafromcommandLine()
  {
	//String BROWSER = System.getProperty("browser");
	String URL = System.getProperty("url");
	String USERNAME = System.getProperty("username");
	String PASSWORD = System.getProperty("password");
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	driver.get(URL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("hr_email")).sendKeys(USERNAME);
	driver.findElement(By.name("hr_password")).sendKeys(PASSWORD);
	WebElement ele = driver.findElement(By.xpath("//select[@id='hr_type']"));
	Select sc= new Select(ele);
	sc.selectByValue("HR Officer");  
	driver.findElement(By.name("login_hr")).click();
  }
  
}
