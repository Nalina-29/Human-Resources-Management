package xpathPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KayakaTest {

	public static void main(String[] args) throws AWTException, InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//div[.='Flights']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("Bangalore");
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//input[@placeholder='To?']")).sendKeys("mangalore");
		driver.findElement(By.xpath("//span[.='Mangalore, Karnataka, India']"));
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//span[@aria-label='Start date calendar input']")).click();
		driver.findElement(By.xpath("//div[.='August 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[text()='28']")).click();
	
		driver.findElement(By.xpath("//span[@aria-label='End date calendar input']")).click();
		driver.findElement(By.xpath("//div[.='September 2023']/ancestor::div[@class='onx_ onx_-pres-mcfly onx_-double']/descendant::div[text()='7']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Search']")).click();
		driver.findElement(By.xpath("//label[.='Direct flights only']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@aria-label='Other sort']")).click();
		driver.findElement(By.xpath("//li[@aria-label='Slowest']")).click();
		WebElement ele = driver.findElement(By.xpath("//div[@class='Oihj']/../preceding-sibling::div[@class='nrc6-content-section']//div[text()='1h 10m']/ancestor::div[@class='nrc6-wrapper']/descendant::div[contains(text(),'10,430')]"));
		
		String actual = ele.getText();
		System.out.println(actual  );
		String price = actual.replace(",", "");
		String res = price.replace("₹", "");
		//Integer result = Integer.valueOf(res);
		int re1 = Integer.parseInt(res);
		System.out.println(re1);
		if(re1<=15000)
		{
			System.out.println("testcase is pass");
			
		}
	}

}
