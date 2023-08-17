package xpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class IccteamRankingTest {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
	 List<WebElement> text = driver.findElements(By.xpath("//tr[*]"));

	for(int i=0; i<text.size(); i++)
	{
		String team = text.get(i).getText();
		System.out.println(team);
	}
	}

}
