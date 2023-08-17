package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		String Monthandyear="October 2023";
		int date=14;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		
		String Actualdate="//div[text()='"+Monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
		String nextmonth="//span[@aria-label='Next Month']";
		
		driver.findElement(By.xpath("//div[@class='sc-hUpaCq fKFvYE']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		
		for(;;)
			try {
				driver.findElement(By.xpath(Actualdate)).click();
				break;
			}
		catch (Exception e)
		{
			driver.findElement(By.xpath(nextmonth)).click();
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click(); 
	}

}
