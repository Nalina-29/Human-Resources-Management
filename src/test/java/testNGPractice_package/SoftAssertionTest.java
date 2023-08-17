package testNGPractice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertionTest 
{
	@Test
	 public void softassert()
	 {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		String title = driver.getTitle();
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(title, "Facebook  log in or sign up");
		//Assert.assertEquals(title, "Facebook  log in or sign up");
		
	 }
	 
	 @Test
	 public void sample()
	 {
		 WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		String url = driver.getCurrentUrl();
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(url, "https://www.flipkart.com/");
		//Assert.assertEquals(url, "https://www.flipkart.com/");
	 }
}
