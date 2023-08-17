package xpathPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OlympicTest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		
		String name = driver.findElement(By.xpath("//span[text()='Argentina']")).getText();
		String Gold = driver.findElement(By.xpath("//span[text()='Argentina']/ancestor::div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']/following-sibling::div[@data-medal-id='gold-medals-row-1']")).getText();
		String Silver = driver.findElement(By.xpath("//span[text()='Argentina']/ancestor::div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']/following-sibling::div[@data-medal-id='silver-medals-row-1']")).getText();
		String Bronze = driver.findElement(By.xpath("//span[text()='Argentina']/ancestor::div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']/following-sibling::div[@data-medal-id='bronze-medals-row-1']")).getText();
		String Total = driver.findElement(By.xpath("//span[text()='Argentina']/ancestor::div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']/following-sibling::div[@data-medal-id='total-medals-row-1']")).getText();
		
		System.out.println(name+"  "+Gold+" "+Silver+" "+Bronze+" "+Total);
	}

}
