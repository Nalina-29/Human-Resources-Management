package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		String Monthandyear="October 2023";
		int date=14;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		 driver.navigate().refresh();
         Thread.sleep(3000);
         String Actualdate="//div[text()='"+Monthandyear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
         String nextmonth="//span[@aria-label='Next Month']";
         driver.findElement(By.xpath("(//span[@class='lbl_input appendBottom10'])[3]")).click();
        // driver.findElement(By.xpath("//div[text()='July 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='25']")).click();
      // driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click(); 
          for(;;)
			try {
				driver.findElement(By.xpath(Actualdate)).click();
				break;
			}
		catch (Exception e)
		{
			driver.findElement(By.xpath(nextmonth)).click();
		}
	}

}
