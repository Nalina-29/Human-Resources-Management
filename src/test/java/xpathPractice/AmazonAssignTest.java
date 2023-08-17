package xpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssignTest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 driver.get("https://www.amazon.in/");
		 
	      driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("iphone 14");
	      driver.findElement(By.id("nav-search-submit-button")).click();
	     List<WebElement> phone = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//h2"));
	   List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//span[@class='a-price']"));
	    for(int i=0; i<phone.size(); i++)
	      {
	    	String act = price.get(i).getText();
	    	String actual = act.replace(",", "");
	    	System.out.println(phone.get(i).getText()+"------>"+actual);
	      }
	}

}
