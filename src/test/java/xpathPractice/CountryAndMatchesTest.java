package xpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryAndMatchesTest {

	public static void main(String[] args) 
	{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		
		List<WebElement> CountryName = driver.findElements(By.xpath("(//tr[*]/descendant::span[@class='u-hide-phablet'])[position()<=10]"));
	     List<WebElement> matches = driver.findElements(By.xpath("(//tr[*]/descendant::td[3])[position()<=10]"));
for(int i=0; i<CountryName.size(); i++)
{
	System.out.println(CountryName.get(i).getText()+"--"+matches.get(i).getText());
}

	}

}
