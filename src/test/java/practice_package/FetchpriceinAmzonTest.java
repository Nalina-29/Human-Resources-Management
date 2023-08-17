package practice_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchpriceinAmzonTest {

	public static void main(String[] args) 
	{
	  WebDriverManager.chromedriver().setup();
	  WebDriver driver= new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("https://www.amazon.in/");
	  driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("iphone14");
	  driver.findElement(By.id("nav-search-submit-button")).click();
	  List<WebElement> phone = driver.findElements(By.xpath("//span[.='Apple']/ancestor::h2/../following-sibling::div[@class='sg-row']/descendant::span[@class='a-price']"));
	 
	  for(int i=0; i<phone.size(); i++)
	  {
		  System.out.println(phone.get(i).getText()); 
		  /*
		 String actual = phone.get(i).getText();
		 String a = actual.replace(",", "");
		 Integer b = Integer.valueOf(a);
		 if(b<=70000)
		 {
			System.out.println(phone.get(i).getText()); 
		 }
		 */
	  }

	}

}
