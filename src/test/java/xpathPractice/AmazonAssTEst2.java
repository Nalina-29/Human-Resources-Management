package xpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonAssTEst2 {

	public static void main(String[] args)
	{

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		 driver.get("https://www.amazon.in/");
		 driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']")).sendKeys("phone");
	      driver.findElement(By.id("nav-search-submit-button")).click();
	      driver.findElement(By.xpath("//span[text()='realme']")).click();
	     List<WebElement> phone = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
    List<WebElement> price = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-micro puis-price-instructions-style']//span[@class='a-price']"));
	     for(int i=0; i<price.size(); i++)
     {
    	 System.out.println(phone.get(i).getText()+"------>"+price.get(i).getText());
     }
	}

}
