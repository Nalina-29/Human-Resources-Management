package testNGPractice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertionTest 
{
 @Test
 public void hardassert()
 {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com");
	String title = driver.getTitle();
	assertEquals(title, "Facebook  log in or sign up");
	
 }
 
 @Test
 public void sample()
 {
	 WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	String url = driver.getCurrentUrl();
	assertEquals(url, "https://www.flipkart.com/");
 }
 
}
