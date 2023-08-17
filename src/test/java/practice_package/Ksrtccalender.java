package practice_package;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ksrtccalender {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://ksrtc.in/");
		//driver.findElement(By.name("fromPlaceName")).sendKeys("bengalore");
		//driver.findElement(By.name("toPlaceName")).sendKeys("Dharmastala");
		driver.findElement(By.xpath("//input[@id='txtJourneyDate']")).click();
		driver.findElement(By.xpath("//a[.='25']")).click();
		driver.findElement(By.name("txtReturnJourneyDate")).click();
		driver.findElement(By.xpath("//a[.='28']")).click();
		driver.findElement(By.name("singleLady")).click();
		driver.findElement(By.className("btn btn-primary btn-lg btn-block btn-booking")).click();
		}

}
