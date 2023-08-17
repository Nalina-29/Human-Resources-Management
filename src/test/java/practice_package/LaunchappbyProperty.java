package practice_package;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchappbyProperty {

	public static void main(String[] args) throws IOException, InterruptedException 
	{
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\Data.properties");
		Properties p= new Properties();
		p.load(fis);
		String BROWSER = p.getProperty("browser");
		String URL = p.getProperty("url");
		String UN = p.getProperty("username");
		String PWD =p.getProperty("password");
		
		WebDriver driver;
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
			driver= new ChromeDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.get(URL);
		driver.findElement(By.name("hr_email")).sendKeys(UN);
		driver.findElement(By.name("hr_password")).sendKeys(PWD);
		WebElement ele = driver.findElement(By.xpath("//select[@id='hr_type']"));
		Select sc= new Select(ele);
		sc.selectByValue("HR Officer");  
		driver.findElement(By.name("login_hr")).click();
		

	}

}
