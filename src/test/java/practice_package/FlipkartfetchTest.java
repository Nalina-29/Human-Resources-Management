package practice_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipkartfetchTest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.flipkart.com");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@title='Search for products, brands and more']")).sendKeys("sumsung phone");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		List<WebElement> phone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		 List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']")); 
	   for(int i=0; i<phone.size(); i++)
	   {
		  System.out.println( phone.get(i).getText()+"------->"+prices.get(i).getText());
	   }
	
	}

}
