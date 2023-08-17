package xpathPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountryNameMatches30Test {

	public static void main(String[] args)
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> match = driver.findElements(By.xpath("//td[@class='table-body__cell u-center-text'  and text()>30 and text()<55]"));
		
		List<WebElement> country = driver.findElements(By.xpath("//td[@class='table-body__cell u-center-text'  and text()>30 and text()<55]/preceding-sibling::td[@class='table-body__cell rankings-table__team']"));
		System.out.println(match.size());
		System.out.println(country.size());
		for(int i=0; i<match.size(); i++)
		{
			System.out.println(country.get(i).getText()+"--"+match.get(i).getText());
		}
	}

}
